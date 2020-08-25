
package labjava;

public class Archivo {
    //Nombre, Fecha modificación, Contenido
    String nombreArchivo;
    String fechaMod;
    String contenido;
    
    public Archivo(String nombre, String fecha,String contenido){
        this.nombreArchivo=nombre;
        this.fechaMod=fecha;
        this.contenido=contenido;
    }
}
