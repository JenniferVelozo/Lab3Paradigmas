
package labjava;
import java.util.ArrayList;
import java.util.Scanner;

public class LabJava {

    public static void main(String[] args) {
        System.out.println("\nINICIANDO REPOSITORIO GIT...");
        System.out.println("Ingrese nombre del nuevo repositorio: ");
        Scanner input = new Scanner(System.in);
        String nombreRepo=input.nextLine();
        System.out.println("El nombre del repo es: " + nombreRepo);
        System.out.println("Ingrese autor del nuevo repositorio");
        String autorRepo=input.nextLine();
        System.out.println("El autor del repo es: " + autorRepo);
        
        //Se crea un nuevo repositorio
        Repositorio myRepo=new Repositorio();
        //Se inicializa el repositorio en base al nombre y autor entregados por el usuario
        myRepo.gitInit(myRepo,nombreRepo, autorRepo);
        
        System.out.println("\n### SIMULACIÓN DE GIT ###");
        System.out.println("\nEscoja su opción: ");
        System.out.println("\n1. add");
        System.out.println("\n2. commit");
        System.out.println("\n3. pull");
        System.out.println("\n4. push");
        System.out.println("\n5. status");
        System.out.println("\n6. Crear nuevo archivo");
        System.out.println("\nINTRODUZCA SU OPCIÓN: ");
        int opcion=input.nextInt();
        switch(opcion){
            case 1:
                System.out.println("*** GIT ADD ***");
                Scanner input1 = new Scanner(System.in);
                //Se le pide al usuario que ingrese una cantidad de archivos para añadir al Index
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
                ListaArchivos archivosToAdd=myRepo.workspace.archivosQueEstanEnWS(myRepo.workspace, arregloArchivos);
                //System.out.println("cantidad de archivos: " + (archivosToAdd.cantidadArchivos));
                myRepo.gitAdd(myRepo,archivosToAdd);
                myRepo.imprimirRepositorio(myRepo);
          
                break;
            case 2:
                System.out.println("\nHacer commit");
                break;
            case 3:
                System.out.println("\nHacer pull");
                break;
            case 4:
                System.out.println("\nHacer push");
                break;
            case 5:
                System.out.println("\n*** STATUS ***");
                System.out.println("\nNombre del repositorio: "+ myRepo.nombreRepo);
                System.out.println("\nAutor del repositorio: "+ myRepo.autorRepo);
                break;
            case 6:
                System.out.println("\n *** CREAR ARCHIVO ***");
                Scanner entrada = new Scanner(System.in);
                System.out.println("\nIngrese nombre del archivo: ");
                String nombreArchivo=entrada.nextLine();
                System.out.println("\nIngrese contenido del archivo: ");
                String contenidoArchivo=entrada.nextLine();
                Fecha fechaArchivo=new Fecha();
                String fechaModificacion=fechaArchivo.obtenerFechaActual();
                
                //Se crea un nuevo objeto de tipo Archivo
                Archivo archivo=new Archivo(nombreArchivo,fechaModificacion,contenidoArchivo);
                System.out.println("Nombre: "+ archivo.nombreArchivo);
                System.out.println("Fecha: "+ archivo.fechaMod);
                System.out.println("Contenido: "+ archivo.contenido);
                break;
            default:
                System.out.println("\nLa opción ingresada no es correcta");
        }
    }
    
}
