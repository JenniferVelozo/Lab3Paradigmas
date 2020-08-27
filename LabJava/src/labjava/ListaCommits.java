
package labjava;
import java.util.ArrayList;

public class ListaCommits {
    //Atributos
    //Un arreglo de commits 
    ArrayList<Commit> ListaCommits;
    int cantidadCommits;
    
    //Constructor
    public ListaCommits(ArrayList<Commit> commits){
        this.ListaCommits=commits;
        this.cantidadCommits=0;
    }
    
    //Método que agrega un commit a una lista de commits, esto puede ser Local Repository o Remote Repository
    public void agregarCommit(ListaCommits lista,Commit commit){
        lista.ListaCommits.add(commit);
        lista.cantidadCommits++;
    }
    
    public void imprimirListaComits(ListaCommits lista){
        System.out.println("Cantidad de commits: "+ lista.cantidadCommits);
        for(int i=0;i<lista.cantidadCommits;i++){
            System.out.println("\nMOSTRANDO COMMIT "+ (i+1));
            lista.ListaCommits.get(i).imprimirCommit(lista.ListaCommits.get(i));
        }
    }
}
