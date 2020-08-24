/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labjava;
import java.util.ArrayList;
/**
 *
 * @author Jennifer
 */
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
