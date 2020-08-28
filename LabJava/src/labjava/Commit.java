
package labjava;
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
     * @param fecha La fecha actual del commit.
     * @param msj El mensaje descriptivo
     * @param archivos los cambios hechos.
     */
    public Commit(String autor, String fecha, String msj, ListaArchivos archivos){
        this.autor=autor;
        this.timeStamp=fecha;
        this.mensaje=msj;
        this.cambios=archivos;
    }
    
    /** 
     * Imprime un commit, mostrando el mensaje descriptivo, autor, fecha y los cambios hechos.
     * @param commit Un commit.
     */
    public void imprimirCommit(Commit commit){
        System.out.println("Mensaje: "+ commit.mensaje);
        System.out.println("Autor: "+ commit.autor);
        System.out.println("Fecha: "+ commit.timeStamp);
        System.out.println("Cambios en commit:");
        commit.cambios.imprimirListaArchivos(commit.cambios);
    }
}
