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
    public void agregarArchivo(Archivo archivo){
        this.ListaArchivos.add(archivo);
        this.cantidadArchivos++;
    }
    
    //Método que verifica si un determinado archivo está dentro de una lista de archivos,
    //esta lista de archivos puede ser el Workspace o el Index
    public int estaArchivo(ListaArchivos lista, String nombreArchivo){
        for(int i=0;i<lista.cantidadArchivos;i++){
            if (lista.ListaArchivos.get(i).nombreArchivo.equals(nombreArchivo)){
                return 1;
            }
        }
        return 0;
    }
    //Método que entrega una lista de los archivos que sí están en el Workspace
    public ListaArchivos archivosQueEstanEnWS(ListaArchivos lista,ArrayList<String> nombreArchivos){
        ArrayList<Archivo> archivosQueEstan=new ArrayList<Archivo>();
        ListaArchivos archivosDeWs=new ListaArchivos(archivosQueEstan);
        for (int i=0;i<nombreArchivos.size();i++){
            if(lista.estaArchivo(lista,nombreArchivos.get(i))==1){
                archivosDeWs.agregarArchivo(lista.ListaArchivos.get(i));
            }
        }
        
        System.out.println("Archivos que están en WS: ");
        for(int i=0;i<archivosDeWs.cantidadArchivos;i++){
            Archivo archivo=archivosDeWs.ListaArchivos.get(i);
            archivo.imprimirArchivo(archivo);
        }
        
        return archivosDeWs;
    }
}
