
package labjava;
/**
 * Clase para representar un Archivo dentro de las zonas de trabajo Workspace e Index.
 * Cada Archivo queda determinado por su nombre, fecha de modificación, y su contenido.
 * @author Jennifer Velozo
 */
public class Archivo {
    //Atributos
    String nombreArchivo; //nombre del archivo
    String fechaMod; //fecha de modificación del archivo
    String contenido; //contenido del archivo
    
    /** 
     * Crea un archivo a partir de un nombre, fecha de modificación y contenido.
     * @param nombre El nombre del archivo.
     * @param fecha La fecha de modificación del archivo.
     * @param contenido El contenido del archivo.
     */
    public Archivo(String nombre, String fecha,String contenido){
        this.nombreArchivo=nombre;
        this.fechaMod=fecha;
        this.contenido=contenido;
    }
    
    /** 
     * Imprime un archivo, mostrando su nombre, fecha y contenido.
     * @param archivo Un archivo.
     */
    public void imprimirArchivo(Archivo archivo){
        System.out.println("    - Nombre del archivo: "+archivo.nombreArchivo);
        System.out.println("    - Fecha: "+archivo.fechaMod);
        System.out.println("    - Contenido: "+archivo.contenido);
    }
}
