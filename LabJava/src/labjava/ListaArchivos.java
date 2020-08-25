package labjava;
import java.util.ArrayList;
public class ListaArchivos {
    //Atributos
    public ArrayList<ArrayList<String>> ListaArchivos;
    public int cantidadArchivos=ListaArchivos.size();
    //Métodos
    public ListaArchivos(ArrayList<ArrayList<String>> archivos){
        this.ListaArchivos=archivos;
        this.cantidadArchivos=archivos.size();
    }
    public void agregarArchivo(ArrayList<String> archivo){
        this.ListaArchivos.add(archivo);
    }
}
