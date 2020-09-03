package labjava;
import java.util.ArrayList;
/**
 * La clase ListaArchivos representa a las zonas de trabajo Workspace e Index.
 * Los atributos de esta clase son: un array list de tipo Archivo, y la cantidad de archivos de este array list.
 * Cabe destacar que, la clase ListaCommits tiene a Archivo, es decir, hay una relación de asociación entre estas dos clases.
 * */
public class ListaArchivos {
    //Atributos
    ArrayList<Archivo> listaArchivos; //ArrayList de tipo Archivo
    int cantidadArchivos; //Cantidad de archivos en la lista
    
    /** 
     * Crea una lista de archivos a partir de un ArrayList de Archivos.
     * @param archivos ArrayList de tipo Archivo.
     */
    public ListaArchivos(ArrayList<Archivo> archivos){
        this.listaArchivos=archivos;
        this.cantidadArchivos=0;
    }
    /** 
     * Agrega un archivo a una ListaArchivos.
     * @param archivo el archivo a agregar.
     */
    public void agregarArchivo(Archivo archivo){
        this.listaArchivos.add(archivo);
        this.cantidadArchivos++;
    }
    
    /** 
     * Verifica si un nombre de archivo corresponde al nombre de un archivo dentro de una ListaArchivos.
     * @param nombreArchivo Nombre del archivo
     * @return La posición del archivo dentro de la lista, o -1 si el archivo no está.
     */
    public int estaArchivo(String nombreArchivo){
        for(int i=0;i<this.cantidadArchivos;i++){
            if (this.listaArchivos.get(i).nombreArchivo.equals(nombreArchivo)){
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
                archivosMiembros.agregarArchivo(this.listaArchivos.get(posicion));

            }
        }
        return archivosMiembros;
    }
    
    /** 
     * Entrega un string para representar una
     * lista de archivos, indicando la cantidad de archivos y los archivos como tal.
     * @return un string que representa la lista de archivos
     */    
    @Override
    public String toString(){
        String listaToString="Cantidad de archivos: "+ this.cantidadArchivos;
        for(int i=0;i<this.cantidadArchivos;i++){
            listaToString=listaToString+"\n\n   MOSTRANDO ARCHIVO "+ (i+1)+"\n"+ this.listaArchivos.get(i).toString();
        }
        return listaToString;
    }
}
