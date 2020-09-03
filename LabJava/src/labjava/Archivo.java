
package labjava;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
     * @param contenido El contenido del archivo.
     */
    public Archivo(String nombre,String contenido){
        this.nombreArchivo=nombre;
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date fecha=new Date();
        this.fechaMod=df.format(fecha);
        this.contenido=contenido;
    }
    
    /** 
     * Entrega un string para representar un archivo, indicando el nombre, fecha y contenido.
     * @return un string que representa un archivo.
     */
    @Override
    public String toString(){
        String ArchivoToString=
                "    - Nombre del archivo: "+this.nombreArchivo+"\n"+
                "    - Fecha: "+this.fechaMod+"\n"+
                "    - Contenido: "+this.contenido;
        return ArchivoToString;
    }
}
