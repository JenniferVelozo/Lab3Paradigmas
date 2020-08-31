package labjava;
import java.util.ArrayList;
/**
 * La clase ListaArchivos representa a las zonas de trabajo Workspace e Index.
 * Los atributos de esta clase son: un array list de tipo Archivo, y la cantidad de archivos de este array list.
 * */
public class ListaArchivos {
    //Atributos
    ArrayList<Archivo> ListaArchivos; //ArrayList de tipo Archivo
    int cantidadArchivos; //Cantidad de archivos en la lista
    
    /** 
     * Crea una lista de archivos a partir de un ArrayList de Archivos.
     * @param archivos ArrayList de tipo Archivo.
     */
    public ListaArchivos(ArrayList<Archivo> archivos){
        this.ListaArchivos=archivos;
        this.cantidadArchivos=0;
    }
    
    /** 
     * Agrega un archivo a una ListaArchivos.
     * @param archivo el archivo a agregar.
     */
    public void agregarArchivo(Archivo archivo){
        this.ListaArchivos.add(archivo);
        this.cantidadArchivos++;
    }
    
    /** 
     * Verifica si un nombre de archivo corresponde al nombre de un archivo dentro de una ListaArchivos.
     * @param nombreArchivo Nombre del archivo
     * @return La posición del archivo dentro de la lista, o -1 si el archivo no está.
     */
    public int estaArchivo(String nombreArchivo){
        for(int i=0;i<this.cantidadArchivos;i++){
            if (this.ListaArchivos.get(i).nombreArchivo.equals(nombreArchivo)){
                return i;
            }
        }
        return -1;
    }
    
    /** 
     * Entrega una lista de archivos que sí dentro una lista de archvivos, 
     * a partir de una lista de nombres de archivos.
     * @param nombreArchivos los nombres de archivos.
     * @return una lista con los archivos que sí están dentro.
     */
    public ListaArchivos archivosQueEstan(ArrayList<String> nombreArchivos){
        ListaArchivos archivosMiembros=new ListaArchivos(new ArrayList<>());
        for (int i=0;i<nombreArchivos.size();i++){
            int posicion=this.estaArchivo(nombreArchivos.get(i));
            if(posicion!=-1){
                archivosMiembros.agregarArchivo(this.ListaArchivos.get(posicion));

            }
        }
        return archivosMiembros;
    }
    
    /** 
     * Imprime una lista de archivos, indicando la cantidad de archivos y los archivos como tal.
     */
    public void imprimirListaArchivos(){
        System.out.println("Cantidad de archivos: "+ this.cantidadArchivos);
        for(int i=0;i<this.cantidadArchivos;i++){
            System.out.println("\n   MOSTRANDO ARCHIVO "+ (i+1));
            this.ListaArchivos.get(i).imprimirArchivo();
        }
    }
}
