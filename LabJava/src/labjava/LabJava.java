/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labjava;
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
        
        Repositorio MyRepo=new Repositorio();
        Fecha fechaActual=new Fecha();
        String fechaCreacion=fechaActual.obtenerFechaActual();
        MyRepo.nombreRepo=nombreRepo;
        MyRepo.autorRepo=autorRepo;
        MyRepo.fechaCreacion=fechaCreacion;
        
        System.out.println("\n### SIMULACIÓN DE GIT ###");
        System.out.println("\nEscoja su opción: ");
        System.out.println("\n1. add");
        System.out.println("\n2. commit");
        System.out.println("\n3. pull");
        System.out.println("\n4. push");
        System.out.println("\n5. status");
        System.out.println("\n6. Crear nuevo archivo");
        System.out.println("\nINTRODUZCA SU OPCIÓN: ");
        //Scanner input = new Scanner(System.in);
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
                System.out.println("\nHacer status");
                break;
            case 6:
                System.out.println("\nCrear archivo");
                break;
            default:
                System.out.println("\nLa opción ingresada no es correcta");
        }
    }
    
}
