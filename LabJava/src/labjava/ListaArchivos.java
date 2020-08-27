package labjava;
import java.util.ArrayList;
public class ListaArchivos {
    //Atributos
    //Un arreglo de archivos 
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
        /*System.out.println("Archivos que están en WS: ");
        for(int i=0;i<archivosDeWs.cantidadArchivos;i++){
            Archivo archivo=archivosDeWs.ListaArchivos.get(i);
            archivo.imprimirArchivo(archivo);
        }*/
        return archivosDeWs;
    }
    
    public void imprimirListaArchivos(ListaArchivos lista){
        System.out.println("Cantidad de archivos: "+ lista.cantidadArchivos);
        for(int i=0;i<lista.cantidadArchivos;i++){
            System.out.println("\nMostrando archivo "+ (i+1));
            lista.ListaArchivos.get(i).imprimirArchivo(lista.ListaArchivos.get(i));
        }
    }
}
