package labjava;
import java.util.ArrayList;
/**
 * La clase ListaArchivos representa a las zonas de trabajo Workspace e Index
 * Los atributos de esta clase son: un array list de tipo Archivo, y la cantidad de archivos de este array list
 * */
public class ListaArchivos {
    //Atributos
    //Un array list de archivos 
    ArrayList<Archivo> ListaArchivos;
    int cantidadArchivos;
    
    //Constructor
    public ListaArchivos(ArrayList<Archivo> archivos){
        this.ListaArchivos=archivos;
        this.cantidadArchivos=0;
    }
    //Método que agrega un archivo a una lista de archivos, esto puede ser Workspace o Index
    public void agregarArchivo(ListaArchivos lista,Archivo archivo){
        lista.ListaArchivos.add(archivo);
        lista.cantidadArchivos++;
    }
    
    //Método que verifica si un determinado archivo está dentro de una lista de archivos,
    //esta lista de archivos puede ser el Workspace o el Index
    //ENTRADA: lista de archivos, nombre de archivo (string)
    //SALIDA: posición del archivo dentro de la lista, o -1 si el archivo no está
    public int estaArchivo(ListaArchivos lista, String nombreArchivo){
        for(int i=0;i<lista.cantidadArchivos;i++){
            if (lista.ListaArchivos.get(i).nombreArchivo.equals(nombreArchivo)){
                return i;
            }
        }
        return -1;
    }
    //Método que entrega una lista de los archivos que sí están en el Workspace
    public ListaArchivos archivosQueEstanEnWS(ListaArchivos lista,ArrayList<String> nombreArchivos){
        ArrayList<Archivo> archivosQueEstan=new ArrayList<>();
        ListaArchivos archivosDeWs=new ListaArchivos(archivosQueEstan);
        for (int i=0;i<nombreArchivos.size();i++){
            int posicion=lista.estaArchivo(lista,nombreArchivos.get(i));
            if(posicion!=-1){
                //se agrega el archivo encontrado en el arreglo de archivos que están dentro
                //del workspace y la lista que ingresó el usuario
                archivosDeWs.agregarArchivo(archivosDeWs,lista.ListaArchivos.get(posicion));

            }
        }
        return archivosDeWs;
    }
    //Método que imprime una lista de archivos, ya sea el el Workspace, Index o bien, los cambios de un commit
    //ENTRADA: una lista de archivos
    public void imprimirListaArchivos(ListaArchivos lista){
        System.out.println("Cantidad de archivos: "+ lista.cantidadArchivos);
        for(int i=0;i<lista.cantidadArchivos;i++){
            System.out.println("\n   MOSTRANDO ARCHIVO "+ (i+1));
            lista.ListaArchivos.get(i).imprimirArchivo(lista.ListaArchivos.get(i));
        }
    }
}
