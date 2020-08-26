
package labjava;
import java.util.ArrayList;


public class Repositorio {
    //Atributos 
    String nombreRepo;
    String autorRepo;
    ListaArchivos workspace;
    ListaArchivos index;
    ListaCommits localR;
    ListaCommits remoteR;
    
    //Método que inicializa un repositorio en base a un nombre y autor de repositorio entregados
    //ENTRADAS: un repositorio, nombre de repositorio y autor de repositorio
    //SALIDA: puesto que es de tipo void, no tiene salidas
    public void gitInit(Repositorio myRepo,String nombreRepo, String autorRepo){
        //Se crean 2 archivos para que el workspace no esté vacío
        Archivo archivo1=new Archivo("archivo 1","25-08-2020","contenido1");
        Archivo archivo2=new Archivo("archivo 2","25-08-2020","contenido2");
        //Se agregan estos 2 archivos al workspace
        ArrayList<Archivo> workspace1=new ArrayList(2);
        ListaArchivos myWS=new ListaArchivos(workspace1);
        myWS.agregarArchivo(archivo1);
        myWS.agregarArchivo(archivo2);
        
        int verificador=myWS.estaArchivo(myWS, "Archivo 1");
        System.out.println("verificador: "+ verificador);
        System.out.println("Cantidad de archivos en workspace: "+ myWS.cantidadArchivos);
        //Se inicializa vacío el index
        ArrayList<Archivo> index1=new ArrayList();
        ListaArchivos myIndex= new ListaArchivos(index1);
        
        //Se iniciliza vacío el local repository
        ArrayList<Commit> localR1=new ArrayList();
        ListaCommits myLocalR= new ListaCommits(localR1);
        //Se inicializa vacío el remote repository
        ArrayList<Commit> remoteR1=new ArrayList();
        ListaCommits myRemoteR= new ListaCommits(remoteR1);
        
        //Se asignan los datos correspondientes al repositorio
        myRepo.nombreRepo=nombreRepo;
        myRepo.autorRepo=autorRepo;
        myRepo.workspace=myWS;
        myRepo.index=myIndex;
        myRepo.localR=myLocalR;
        myRepo.remoteR=myRemoteR;
    }
    /*public void gitAdd(Repositorio repo, ListaArchivos archivos){
        
    }*/
    /*public void gitCommit(Repositorio repo, Commit commit){
        
    }*/
    
    /*public void gitPush(Repositorio repo){
        
    }*/
    
    /*public void gitPull(Repositorio repo){
        
    }*/
    
    public String obtenerNombreRepo(Repositorio repo){
        return repo.nombreRepo;
    }
    
    public String obtenerAutorRepo(Repositorio repo){
        return repo.autorRepo;
    }
}
