
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
      */
    public void gitInit(){
        System.out.println("\nINICIANDO REPOSITORIO GIT...");
        //Se le solicita al usuario que ingrese el nombre del nuevo repositorio
        System.out.println("Ingrese nombre del nuevo repositorio: ");
        Scanner input = new Scanner(System.in);
        String nombre=input.nextLine();
        //Se le solicita al usuario que ingrese el autor del nuevo repositorio
        System.out.println("Ingrese autor del nuevo repositorio");
        String autor=input.nextLine();
        
        //Se inicializa vacía la zona de trabajo Workspace
        ListaArchivos myWS=new ListaArchivos(new ArrayList());

        //Se inicializa vacía la zona de trabajo Index
        ListaArchivos myIndex= new ListaArchivos(new ArrayList());
        
        //Se iniciliza vacía la zona de trabajo Local Repository
        ListaCommits myLocalR= new ListaCommits(new ArrayList());

        //Se inicializa vacía la zona de trabajo Remote Repository
        ListaCommits myRemoteR= new ListaCommits(new ArrayList());
        
        //Se asignan los datos correspondientes al repositorio
        this.nombreRepo=nombre;
        this.autorRepo=autor;
        this.workspace=myWS;
        this.index=myIndex;
        this.localR=myLocalR;
        this.remoteR=myRemoteR;
    }
    
    /** 
      * Agrega al Index uno o más archivos de texto plano del Workspace.
      */
    public void gitAdd(){
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
        ListaArchivos archivos=this.workspace.archivosQueEstan(arregloArchivos);
        for(int i=0;i<archivos.cantidadArchivos;i++){
            this.index.agregarArchivo(archivos.ListaArchivos.get(i));
        }
    }
    
    /** 
      * Crea un nuevo commit en el Local Repository con los contenidos del Index, 
      * solicitando un mensaje descriptivo para dicho commit.
      */
    public void gitCommit(){
        //Se obtienen los cambios, que corresponden a los archivos del Index
        ListaArchivos cambios=this.index;
        /**
         * Si la cantidad de archivos en el index es igual a 0,
         * se imprime un mensaje indicando que no hay cambios en el index
         * */
        if (cambios.cantidadArchivos==0){
            System.out.println("No hay cambios en el Index");
        }
        else{
            //Se obtiene la fecha actual
            String fechaCommit=this.obtenerFechaActual();
            //Se le solicita al usuario que ingrese un mensaje descriptivo para el commit
            System.out.println("\nIngrese mensaje descriptivo");
            Scanner input = new Scanner(System.in);
            String mensaje=input.nextLine();
            //Se solicita que ingrese el autor del commit
            System.out.println("\nIngrese autor del commit");
            String autorCommit=input.nextLine();
            //Se crea un objeto de tipo Commit en base a los datos anteriores
            Commit commit=new Commit(autorCommit,fechaCommit,mensaje,cambios);
            this.localR.agregarCommit(commit);
        }
        //Luego de hacer un commit, el Index queda vacío
        ListaArchivos myIndex= new ListaArchivos(new ArrayList());
        this.index=myIndex;
    }
    
    /**
     * Toma todos los commits del Local Repository y los envía al Remote Repository.
     */
    public void gitPush(){
        //Si no hay commits en el Local Repository, se imprime un mensaje indicándolo
        if(this.localR.cantidadCommits==0){
            System.out.println("No hay commits en el Local Repository");
        }
        else{
            ListaCommits enviarToRemoteR=this.localR;
            for(int i=0;i<enviarToRemoteR.cantidadCommits;i++){
                if(this.remoteR.estaCommit(enviarToRemoteR.ListaCommits.get(i))==0){
                    this.remoteR.agregarCommit(enviarToRemoteR.ListaCommits.get(i));
                }
            }
        }
    }
    /**
     * Toma todos los archivos del Remote Repository y los copia en el Workspace.
     */
    public void gitPull(){
        //Se crea una lista de archivos para enviarlos al Workspace
        ListaArchivos enviarToWS=new ListaArchivos(new ArrayList());
        for(int i=0;i<this.remoteR.cantidadCommits;i++){
            //Se obtienen los archivos del commit analizado, que corresponde a los cambios de este
            ListaArchivos archivosCommit=this.remoteR.ListaCommits.get(i).cambios;
            //Se agregan los archivos a la lista de archivos que será enviada al Workspace
            for(int j=0;j<archivosCommit.cantidadArchivos;j++){
                enviarToWS.agregarArchivo(archivosCommit.ListaArchivos.get(j));
            }
        }
        //Se agregan los archivos en el Workspace
        for (int i=0;i<enviarToWS.cantidadArchivos;i++){
            this.workspace.agregarArchivo(enviarToWS.ListaArchivos.get(i));
        }
    }
    
    /**
     * Muestra el estado actual del repositorio git.
     */
    public void gitStatus(){
        System.out.println("\nNombre del repositorio: "+ this.nombreRepo);
        System.out.println("\nAutor del repositorio: "+ this.autorRepo);
        System.out.println("\nNumero de archivos en el Workspace: "+ this.workspace.cantidadArchivos);
        System.out.println("\nNumero de archivos en el Index: "+ this.index.cantidadArchivos);
        System.out.println("\nNumero de commits en Local Repository: "+this.localR.cantidadCommits);
        if(!this.localR.ListaCommits.equals(this.remoteR.ListaCommits)){
            System.out.println("\nEl Remote Repository no está al día");
        }
        else{
            System.out.println("\nEl Remote Repository está al día");
        }
    }
    
    /**
     * Crea un archivo, solictitando el nombre y contenido al usuario.
     */
    public void crearArchivo(){
        /**
         * Se le solicita al usuario que ingrese el nombre del archivo que desea crear
         * Si el nombre de archivo ingresado ya existe, se le pedirá al usuario que lo vuelva a ingresar
         * hasta que ingrese un archivo que no exista
         * */
        int esta;
        String nombreArchivo;
        do{
            //Se solicita el nombre de archivo
            System.out.println("\nIngrese nombre del archivo: ");
            Scanner entrada = new Scanner(System.in);
            nombreArchivo=entrada.nextLine();
            //Se verifica si está o no en el Workspace
            esta=this.workspace.estaArchivo(nombreArchivo);
            if(esta!=-1){
                System.out.println("El archivo ingresado ya existe");
            }
        }while(esta!=-1);
        //Se le solicita sl usuario que ingrese el contenido del archivo
        System.out.println("\nIngrese contenido del archivo: ");
        Scanner entrada = new Scanner(System.in);
        String contenidoArchivo=entrada.nextLine();
        //Se obtiene la fecha de creación del archivo
        String fechaArchivo=this.obtenerFechaActual();
        //Se crea un nuevo objeto de tipo Archivo
        Archivo archivo=new Archivo(nombreArchivo,fechaArchivo,contenidoArchivo);
        System.out.println("El archivo fue creado exitosamente ");
        //Se imprime el nuevo archivo creado
        archivo.imprimirArchivo();
        //Se agrega el nuevo archivo a la zona de trabajo Workspace
        this.workspace.agregarArchivo(archivo);
    }
    
    /**
     * Imprime un repositori0o, mostrando el contenido de cada una de las
     * zonas de trabajo.
     */
    public void imprimirRepositorio(){
        System.out.println("\n---------------- MOSTRANDO REPOSITORIO ----------------");
        System.out.println("\n----------------- Mostrando Workspace -----------------");
        this.workspace.imprimirListaArchivos();
        System.out.println("\n------------------- Mostrando Index -------------------");
        this.index.imprimirListaArchivos();
        System.out.println("\n-------------- Mostrando Local Repository -------------");
        this.localR.imprimirListaComits();
        System.out.println("\n------------- Mostrando Remote Repository -------------");
        this.remoteR.imprimirListaComits();
    }
}
