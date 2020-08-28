
package labjava;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 * Clase para representar un Repositorio en GitHub.
 * Un Repositorio queda determinado por su nombre, autor, y las 4 zonas de trabajo: Workspace, Index,
 * Local Repository y Remote Repository.
 * @author Jennifer Velozo
 */
public class Repositorio {
    //Atributos 
    String nombreRepo; //nombre del repositorio
    String autorRepo; //autor del repositorio
    ListaArchivos workspace; //zona de trabajo Workspace
    ListaArchivos index; //zona de trabajo Index
    ListaCommits localR; //zona de trabajo Local Repository
    ListaCommits remoteR; //zona de trabajo Remote Repository
    
    /** 
     * Obtiene la fecha actual del sistema.
     * @return String que representa la fecha actual.
     */
    public String obtenerFechaActual(){
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date fecha=new Date();
        return df.format(fecha);
    }
    
    /** 
      * Inicializa un nuevo repositorio
      * @param myRepo Repositorio
      */
    //Método que inicializa un repositorio
    //ENTRADAS: un repositorio
    //SALIDA: puesto que es de tipo void, no tiene salidas
    public void gitInit(Repositorio myRepo){
        System.out.println("\nINICIANDO REPOSITORIO GIT...");
        //Se le solicita al usuario que ingrese el nombre del nuevo repositorio
        System.out.println("Ingrese nombre del nuevo repositorio: ");
        Scanner input = new Scanner(System.in);
        String nombre=input.nextLine();
        //Se le solicita al usuario que ingrese el autor del nuevo repositorio
        System.out.println("Ingrese autor del nuevo repositorio");
        String autor=input.nextLine();
        
        //Se inicializa vacía la zona de trabajo Workspace
        ArrayList<Archivo> workspace1=new ArrayList();
        ListaArchivos myWS=new ListaArchivos(workspace1);

        //Se inicializa vacía la zona de trabajo Index
        ArrayList<Archivo> index1=new ArrayList();
        ListaArchivos myIndex= new ListaArchivos(index1);
        
        //Se iniciliza vacía la zona de trabajo Local Repository
        ArrayList<Commit> localR1=new ArrayList();
        ListaCommits myLocalR= new ListaCommits(localR1);

        //Se inicializa vacía la zona de trabajo Remote Repository
        ArrayList<Commit> remoteR1=new ArrayList();
        ListaCommits myRemoteR= new ListaCommits(remoteR1);
        
        //Se asignan los datos correspondientes al repositorio
        myRepo.nombreRepo=nombre;
        myRepo.autorRepo=autor;
        myRepo.workspace=myWS;
        myRepo.index=myIndex;
        myRepo.localR=myLocalR;
        myRepo.remoteR=myRemoteR;
    }
    public void gitAdd(Repositorio myRepo){
        //Se le pide al usuario que ingrese una cantidad de archivos para añadir al Index
        Scanner input1 = new Scanner(System.in);
        System.out.println("Ingrese cantidad de archivos para añadir al Index: ");
        int cantidadArchivos=input1.nextInt();
        ArrayList<String> arregloArchivos=new ArrayList<>(cantidadArchivos);
        Scanner input2 = new Scanner(System.in);
        //Se le solicita al usuario que ingrese el nombre de los archivos que desea añadir al Index
        for (int i=0;i<cantidadArchivos;i++){
            System.out.println("Ingrese archivo "+ (i+1));
            String archivo=input2.nextLine();
            arregloArchivos.add(archivo);
        }
        //Verificar qué archivos de los que ingresó el usuario pertenecen al Workspoace
        //para así agregarlos al Index
        System.out.println("Los archivos que desea añadir son: ");
        for(int i=0;i<cantidadArchivos;i++){
            System.out.println(arregloArchivos.get(i));
        }
        //Se crea una lista con aquellos archivos que pertenecen al Workspace
        ListaArchivos archivos=myRepo.workspace.archivosQueEstanEnWS(myRepo.workspace, arregloArchivos);
        for(int i=0;i<archivos.cantidadArchivos;i++){
            myRepo.index.agregarArchivo(myRepo.index,archivos.ListaArchivos.get(i));
        }
    }
    public void gitCommit(Repositorio myRepo){
        //Se obtienen los cambios, que corresponden a los archivos del Index
        ListaArchivos cambios=myRepo.index;
        //Si la cantidad de archivos en el index es igual a 0,
        //se imprime un mensaje indicando que no hay cambios en el index
        if (cambios.cantidadArchivos==0){
            System.out.println("No hay cambios en el Index");
        }
        else{
            //Se obtiene la fecha actual
            String fechaCommit=myRepo.obtenerFechaActual();
            //Se le solicita al usuario que ingrese un mensaje descriptivo para el commit
            System.out.println("\nIngrese mensaje descriptivo");
            Scanner input = new Scanner(System.in);
            String mensaje=input.nextLine();
            //Se solicita que ingrese el autor del commit
            System.out.println("\nIngrese autor del commit");
            String autorCommit=input.nextLine();
            //Se crea un objeto de tipo Commit en base a los datos anteriores
            Commit commit=new Commit(autorCommit,fechaCommit,mensaje,cambios);
            myRepo.localR.agregarCommit(myRepo.localR, commit);
        }
        //Luego de hacer un commit, el Index queda vacío
        ArrayList<Archivo> index1=new ArrayList();
        ListaArchivos myIndex= new ListaArchivos(index1);
        myRepo.index=myIndex;
    }
    
    public void gitPush(Repositorio repo){
        /*ArrayList<Commit> enviar=new ArrayList();
        ListaCommits enviarToRR= new ListaCommits(enviar);
        enviarToRR=repo.localR;
        for (int i=0;i<enviarToRR.cantidadCommits;i++){
            repo.remoteR.agregarCommit(repo.remoteR,repo.localR.ListaCommits.get(i));
        }*/
        if(repo.localR.cantidadCommits==0){
            System.out.println("No hay commits en el Local Repository");
        }
        else{
            //El remote Repository es igual al Local Repository
            ListaCommits enviarToRemoteR=repo.localR;
            for(int i=0;i<enviarToRemoteR.cantidadCommits;i++){
                if(repo.remoteR.estaCommit(repo.remoteR,enviarToRemoteR.ListaCommits.get(i))==0){
                    repo.remoteR.agregarCommit(repo.remoteR, enviarToRemoteR.ListaCommits.get(i));
                }
            }
        }
        
    }
    
    public void gitPull(Repositorio repo){
        ArrayList<Archivo> enviar=new ArrayList();
        ListaArchivos enviarToWS=new ListaArchivos(enviar);
        for(int i=0;i<repo.remoteR.cantidadCommits;i++){
            //Se obtienen los archivos del commit analizado, que corresponde a los cambios de este
            ListaArchivos archivosCommit=repo.remoteR.ListaCommits.get(i).cambios;
            //Se agregan los archivos a la lista de archivos que será enviada al Workspace
            for(int j=0;j<archivosCommit.cantidadArchivos;j++){
                enviarToWS.agregarArchivo(enviarToWS,archivosCommit.ListaArchivos.get(j));
            }
        }
        for (int i=0;i<enviarToWS.cantidadArchivos;i++){
            repo.workspace.agregarArchivo(repo.workspace, enviarToWS.ListaArchivos.get(i));
        }
    }
    
    public void gitStatus(Repositorio myRepo){
        System.out.println("\nNombre del repositorio: "+ myRepo.nombreRepo);
        System.out.println("\nAutor del repositorio: "+ myRepo.autorRepo);
        System.out.println("\nNumero de archivos en el Workspace: "+ myRepo.workspace.cantidadArchivos);
        System.out.println("\nNumero de archivos en el Index: "+ myRepo.index.cantidadArchivos);
        System.out.println("\nNumero de commits en Local repository: "+myRepo.localR.cantidadCommits);
    }
    
    public void crearArchivo(Repositorio myRepo){
        //Se le solicita al usuario que ingrese el nombre del archivo que desea crear
        //Si el nombre de archivo ingresado ya existe, se le pedirá al usuario que lo vuelva a ingresar
        //hasta que ingrese un nombre de archivo que no exista
        int esta;
        String nombreArchivo;
        do{
            System.out.println("\nIngrese nombre del archivo: ");
            Scanner entrada = new Scanner(System.in);
            nombreArchivo=entrada.nextLine();
            esta=myRepo.workspace.estaArchivo(myRepo.workspace, nombreArchivo);
            if(esta!=-1){
                System.out.println("El archivo ingresado ya existe");
            }
        }while(esta!=-1);
        //Se le solicita sl usuario que ingrese el contenido del archivo
        System.out.println("\nIngrese contenido del archivo: ");
        Scanner entrada = new Scanner(System.in);
        String contenidoArchivo=entrada.nextLine();
        //Se obtiene la fecha de creación del archivo
        String fechaArchivo=myRepo.obtenerFechaActual();
        //Se crea un nuevo objeto de tipo Archivo
        Archivo archivo=new Archivo(nombreArchivo,fechaArchivo,contenidoArchivo);
        System.out.println("El archivo fue creado exitosamente ");
        //Se imprime el nuevo archivo creado
        archivo.imprimirArchivo(archivo);
        //Se agrega el nuevo archivo a la zona de trabajo Workspace
        myRepo.workspace.agregarArchivo(myRepo.workspace,archivo);
    }
    
    //Método que permite imprimir el contenido de un repositorio, mostrando el contenido de cada una 
    // de las zonas de trabajo
    //ENTRADA: un repositorio
    public void imprimirRepositorio(Repositorio repo){
        System.out.println("\n---------------- MOSTRANDO REPOSITORIO ----------------");
        System.out.println("\n----------------- Mostrando Workspace -----------------");
        repo.workspace.imprimirListaArchivos(repo.workspace);
        System.out.println("\n------------------- Mostrando Index -------------------");
        repo.index.imprimirListaArchivos(repo.index);
        System.out.println("\n-------------- Mostrando Local Repository -------------");
        repo.localR.imprimirListaComits(repo.localR);
        System.out.println("\n------------- Mostrando Remote Repository -------------");
        repo.localR.imprimirListaComits(repo.remoteR);
    }
}
