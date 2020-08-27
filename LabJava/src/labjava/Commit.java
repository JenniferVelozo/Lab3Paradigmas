
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
    
    //Método para imprimir un commit
    public void imprimirCommit(Commit commit){
        System.out.println("Mensaje: "+ commit.mensaje);
        System.out.println("Autor: "+ commit.autor);
        System.out.println("Fecha: "+ commit.timeStamp);
        System.out.println("Cambios ");
        commit.cambios.imprimirListaArchivos(commit.cambios);
    }
}
