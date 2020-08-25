package labjava;
import java.util.ArrayList;
public class ListaArchivos {
    //Atributos
    ArrayList<Archivo> ListaArchivos;
    //int cantidadArchivos=ListaArchivos.size();
    //Métodos
    public ListaArchivos(ArrayList<Archivo> archivos){
        this.ListaArchivos=archivos;
        //this.cantidadArchivos=archivos.size();
    }
    public void agregarArchivo(Archivo archivo){
        this.ListaArchivos.add(archivo);
    }
}
