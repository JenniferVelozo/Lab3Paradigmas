
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
     */
    public void imprimirArchivo(){
        System.out.println("    - Nombre del archivo: "+this.nombreArchivo);
        System.out.println("    - Fecha: "+this.fechaMod);
        System.out.println("    - Contenido: "+this.contenido);
    }
}
