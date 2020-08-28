
package labjava;

//Clase Archivo que tiene como atributos un nombre, fecha de modificación y contenido
public class Archivo {
    //Atributos
    //Nombre, Fecha modificación, Contenido
    String nombreArchivo;
    String fechaMod;
    String contenido;
    
    //Constructor
    public Archivo(String nombre, String fecha,String contenido){
        this.nombreArchivo=nombre;
        this.fechaMod=fecha;
        this.contenido=contenido;
    }
    
    //Método para imprimir un archivo 
    public void imprimirArchivo(Archivo archivo){
        System.out.println("    - Nombre del archivo: "+archivo.nombreArchivo);
        System.out.println("    - Fecha: "+archivo.fechaMod);
        System.out.println("    - Contenido: "+archivo.contenido);
    }
}
