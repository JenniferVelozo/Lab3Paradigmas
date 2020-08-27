
package labjava;
//import java.util.ArrayList;
import java.util.Scanner;

public class LabJava {

    public static void main(String[] args) {
        //Se inicializa el repositorio vacío
        Repositorio myRepo=new Repositorio();
        myRepo.gitInit(myRepo);
        System.out.println("EL REPOSITORIO INICIAL ES: ");
        myRepo.imprimirRepositorio(myRepo);
       
        int opcion=0;
        do{
        //Se presenta un menú al usuario
        System.out.println("\n### SIMULACIÓN DE GIT ###");
        System.out.println("\nEscoja su opción: ");
        System.out.println("\n1. add");
        System.out.println("\n2. commit");
        System.out.println("\n3. pull");
        System.out.println("\n4. push");
        System.out.println("\n5. status");
        System.out.println("\n6. Crear nuevo archivo");
        System.out.println("\n7. Finalizar simulación");
        System.out.println("\nINTRODUZCA SU OPCIÓN: ");
        Scanner input = new Scanner(System.in);
        opcion=input.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("\n*** GIT ADD ***");
                    myRepo.gitAdd(myRepo);
                    myRepo.imprimirRepositorio(myRepo);
                    break;
                case 2:
                    System.out.println("\n*** GIT COMMIT ***");
                    myRepo.gitCommit(myRepo);
                    myRepo.imprimirRepositorio(myRepo);

                    break;
                case 3:
                    System.out.println("\n*** GIT PULL ***");
                    break;
                case 4:
                    System.out.println("\n*** GIT PUSH ***");
                    break;
                case 5:
                    System.out.println("\n*** GIT STATUS ***");
                    myRepo.gitStatus(myRepo);
                    break;
                case 6:
                    System.out.println("\n *** CREAR ARCHIVO ***");
                    myRepo.crearArchivo(myRepo);
                    myRepo.imprimirRepositorio(myRepo);
                    break;
                case 7:
                    System.out.println("Simulación finalizada");
                    break;
                default:
                    System.out.println("\nLa opción ingresada no es correcta");
            }
        }while(opcion!=7);
    }
    
}
