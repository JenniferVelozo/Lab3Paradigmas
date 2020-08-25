
package labjava;


public class Repositorio {
    String nombreRepo;
    String autorRepo;
    ListaArchivos workspace;
    ListaArchivos index;
    //ListaCommits localR;
    //ListaCommits remoteR;
    
    public Repositorio(String nombre, String autor, 
            ListaArchivos workspace, ListaArchivos index){
        this.nombreRepo=nombre;
        this.autorRepo=autor;
        this.workspace=workspace;
        this.index=index;
    }
    
    public String obtenerNombreRepo(Repositorio repo){
        return repo.nombreRepo;
    }
    
    public String obtenerAutorRepo(Repositorio repo){
        return repo.autorRepo;
    }
}
