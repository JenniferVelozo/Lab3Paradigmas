
package labjava;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Repositorio {
    //Atributos 
    String nombreRepo;
    String autorRepo;
    ListaArchivos workspace;
    ListaArchivos index;
    ListaCommits localR;
    ListaCommits remoteR;
    
    public String obtenerFechaActual(){
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date fecha=new Date();
        return df.format(fecha);
    }
    
    //Método que inicializa un repositorio en base a un nombre y autor de repositorio entregados
    //ENTRADAS: un repositorio
    //SALIDA: puesto que es de tipo void, no tiene salidas
    public void gitInit(Repositorio myRepo){
        System.out.println("\nINICIANDO REPOSITORIO GIT...");
        System.out.println("Ingrese nombre del nuevo repositorio: ");
        Scanner input = new Scanner(System.in);
        String nombre=input.nextLine();
        System.out.println("Ingrese autor del nuevo repositorio");
        String autor=input.nextLine();
        //Se crean 2 archivos para que el workspace no esté vacío
        //Archivo archivo1=new Archivo("proyecto1.java","25-08-2020","contenido1");
        //Archivo archivo2=new Archivo("proyecto2.java","25-08-2020","contenido2");
        //Se agregan estos 2 archivos al workspace
        ArrayList<Archivo> workspace1=new ArrayList(2);
        ListaArchivos myWS=new ListaArchivos(workspace1);
        //myWS.agregarArchivo(myWS,archivo1);
        //myWS.agregarArchivo(myWS,archivo2);

        //Se inicializa vacío el index
        ArrayList<Archivo> index1=new ArrayList();
        ListaArchivos myIndex= new ListaArchivos(index1);
        //myIndex.agregarArchivo(myIndex, archivo2);
        
        //Se iniciliza vacío el local repository
        //Commit commit1=new Commit("Jennifer Velozo","26-08-2020","primer commit",myWS);
        ArrayList<Commit> localR1=new ArrayList();
        ListaCommits myLocalR= new ListaCommits(localR1);
        //myLocalR.agregarCommit(myLocalR, commit1);
        //Se inicializa vacío el remote repository
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
        System.out.println("cant: "+cantidadArchivos);
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
    
    /*public void gitPush(Repositorio repo){
        
    }*/
    
    /*public void gitPull(Repositorio repo){
        
    }*/
    
    public void gitStatus(Repositorio myRepo){
        System.out.println("\nNombre del repositorio: "+ myRepo.nombreRepo);
        System.out.println("\nAutor del repositorio: "+ myRepo.autorRepo);
        System.out.println("\nNumero de archivos en el Workspace: "+ myRepo.workspace.cantidadArchivos);
        System.out.println("\nNumero de archivos en el Index: "+ myRepo.index.cantidadArchivos);
        System.out.println("\nNumero de commits en Local repository: "+myRepo.localR.cantidadCommits);
    }
    
    public void crearArchivo(Repositorio myRepo){
        //Se le solicita al usuario que ingrese el nombre del archivo que desea crear
        System.out.println("\nIngrese nombre del archivo: ");
        Scanner entrada = new Scanner(System.in);
        String nombreArchivo=entrada.nextLine();
        //Se le solicita sl usuario que ingrese el contenido del archivo
        System.out.println("\nIngrese contenido del archivo: ");
        String contenidoArchivo=entrada.nextLine();
        //Se obtiene la fecha de creación del archivo
        Fecha fechaArchivo=new Fecha();
        String fechaModificacion=fechaArchivo.obtenerFechaActual();

        //Se crea un nuevo objeto de tipo Archivo
        Archivo archivo=new Archivo(nombreArchivo,fechaModificacion,contenidoArchivo);
        System.out.println("El archivo fue creado exitosamente ");
        archivo.imprimirArchivo(archivo);
        myRepo.workspace.agregarArchivo(myRepo.workspace,archivo);
    }
    public void imprimirRepositorio(Repositorio repo){
        System.out.println("\nMOSTRANDO REPOSITORIO: ");
        System.out.println("\nMostrando Workspace: ");
        repo.workspace.imprimirListaArchivos(repo.workspace);
        System.out.println("\nMostrando Index: ");
        repo.index.imprimirListaArchivos(repo.index);
        System.out.println("\nMostrando Local Repository: ");
        repo.localR.imprimirListaComits(repo.localR);
        System.out.println("\nMostrando Remote Repository: ");
        repo.localR.imprimirListaComits(repo.remoteR);
    }
}
