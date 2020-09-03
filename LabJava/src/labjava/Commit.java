
package labjava;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase para representar un Commit dentro de las zonas de trabajo Local Repository y Remote Repository.
 * Cada Commit queda determinado por su autor, una marca de tiempo, un mensaje descriptivo y los cambios.
 * @author Jennifer Velozo
 */
public class Commit {
    //Atributos
    String autor; //autor del commit
    String timeStamp; //marca de tiempo 
    String mensaje; //mensaje descriptivo
    ListaArchivos cambios; //cambios hechos
    
    /** 
     * Crea un commit a partir de un autor, fecha, mensaje descriptivo, y los cambios hechos.
     * @param autor El autor del commit.
     * @param msj El mensaje descriptivo
     * @param archivos los cambios hechos.
     */
    public Commit(String autor,String msj, ListaArchivos archivos){
        this.autor=autor;
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date fecha=new Date();
        this.timeStamp=df.format(fecha);
        this.mensaje=msj;
        this.cambios=archivos;
    }
    
    /** 
     * Entrega un string para representar un commit, indicando el mensaje descriptivo, autor, fecha y los cambios hechos.
     * @return un string que representa un commit.
     */
    @Override
    public String toString(){
        String commitToString=
                "Mensaje: "+mensaje+"\n"+
                "Autor: "+autor+"\n"+
                "Fecha: "+timeStamp+"\n"+
                "Cambios: "+cambios.toString();
        return commitToString;
    }
}
