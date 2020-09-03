
package labjava;
import java.util.ArrayList;

/**
 * La clase ListaCommits representa a las zonas de trabajo Local Repository y Remote Repository.
 * Los atributos de esta clase son: un array list de tipo Commit, y la cantidad de commits de este array list.
 * Cabe destacar que, la clase ListaCommits tiene a Commit, es decir, hay una relación de asociación entre estas dos clases.
 * @author Jennifer Velozo
 * */
public class ListaCommits {
    //Atributos
    ArrayList<Commit> listaCommits; //ArrayList de tipo Commit
    int cantidadCommits; //Cantidad de commits
    
    /** 
     * Crea una lista de commits a partir de un ArrayList de Commits.
     * @param commits ArrayList de tipo Commit.
     */
    public ListaCommits(ArrayList<Commit> commits){
        this.listaCommits=commits;
        this.cantidadCommits=0;
    }
    
    /** 
     * Verifica si un commit está dentro de una ListaCommits.
     * @param commit Commit a buscar.
     * @return La posición del commit dentro de la lista, o -1 si el commit no está.
     */
    public int estaCommit(Commit commit){
        for (int i=0;i<this.cantidadCommits;i++){
            if (this.listaCommits.get(i).equals(commit)){
                return 1;
            }
        }
        return 0;
    }
    
    /** 
     * Agrega un commit a una ListaCommits.
     * @param commit el commit a agregar.
     */
    public void agregarCommit(Commit commit){
        this.listaCommits.add(commit);
        this.cantidadCommits++;
    }
    
    /** 
     * Entrega un string para representar una
     * lista de commits, indicando la cantidad de archivos y los commits como tal.
     * @return un string que representa la lista de commits.
     */
    @Override
    public String toString(){
        String listaToString="Cantidad de commits: "+ this.cantidadCommits;
        for (int i=0;i<this.cantidadCommits;i++){
            listaToString=listaToString+"\n\nMOSTRANDO COMMIT "+ (i+1)+"\n"+ this.listaCommits.get(i).toString();
        }
        return listaToString;
    }
}
