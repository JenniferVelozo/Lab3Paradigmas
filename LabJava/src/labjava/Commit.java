
package labjava;

public class Commit {
    //Atributos
    String autor;
    String timeStamp;
    String mensaje;
    ListaArchivos cambios;
    
    //Constructor
    public Commit(String autor, String fecha, String msj, ListaArchivos archivos){
        this.autor=autor;
        this.timeStamp=fecha;
        this.mensaje=msj;
        this.cambios=archivos;
    }
    
}
