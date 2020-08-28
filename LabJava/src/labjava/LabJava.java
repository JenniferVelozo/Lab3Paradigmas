
package labjava;
//import java.util.ArrayList;
import java.util.Scanner;

public class LabJava {

    public static void main(String[] args) {
        //Se inicializa el repositorio vacío
        Repositorio myRepo=new Repositorio();
        myRepo.gitInit(myRepo);
        //Se muestra el repositorio inicial al usuario
        myRepo.imprimirRepositorio(myRepo);
       
        //Se presenta un menú al usuario mientras la opción sea distinta de 7, es decir, 
        //mientras el usuario no quiera finalizar la simulación
        int opcion;
        do{
            System.out.println("\n### SIMULACIÓN DE GIT ###");
            System.out.println("Escoja su opción: ");
            System.out.println("1. add");
            System.out.println("2. commit");
            System.out.println("3. push");
            System.out.println("4. pull");
            System.out.println("5. status");
            System.out.println("6. Crear nuevo archivo");
            System.out.println("7. Finalizar simulación");
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
                    System.out.println("\n*** GIT PUSH ***");
                    myRepo.gitPush(myRepo);
                    myRepo.imprimirRepositorio(myRepo);
                    break;
                case 4:
                    System.out.println("\n*** GIT PULL ***");
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
