/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labjava;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Jennifer
 */
public class LabJava {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\nINICIANDO REPOSITORIO GIT...");
        System.out.println("Ingrese nombre del nuevo repositorio: ");
        Scanner input = new Scanner(System.in);
        String nombreRepo=input.nextLine();
        System.out.println("El nombre del repo es: " + nombreRepo);
        System.out.println("Ingrese autor del nuevo repositorio");
        String autorRepo=input.nextLine();
        System.out.println("El autor del repo es: " + autorRepo);
        
        Archivo archivo1=new Archivo("archivo 1","25-08-2020","contenido1");
        Archivo archivo2=new Archivo("archivo 2","25-08-2020","contenido2");
        ArrayList<Archivo> workspace1=new ArrayList(2);
        workspace1.add(archivo1);
        workspace1.add(archivo2);
        ListaArchivos workspace=new ListaArchivos(workspace1);
        ArrayList<Archivo> index1=new ArrayList();
        ListaArchivos index= new ListaArchivos(index1);
      
        Repositorio MyRepo=new Repositorio(nombreRepo,autorRepo,workspace,index);
        
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
                System.out.println("\nHacer add");
                
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
                System.out.println("\nNombre del repositorio: "+ MyRepo.nombreRepo);
                System.out.println("\nAutor del repositorio: "+ MyRepo.autorRepo);
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
