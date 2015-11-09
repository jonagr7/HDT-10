import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 */
public class main {

    public static void main(String[] args){
        
        Floyd matriz = new Floyd();
        matriz.Corto(); 
        int seleccion=1;
        int opcion; 
        Scanner scan = new Scanner(System.in);
       
        while(seleccion!=5){
            System.out.println("");
            System.out.println("1. Ruta corta entre las Ciudades ");
            System.out.println("2. Ciudad en el centro del grafo");
            System.out.println("3. Ingresar Ciudades");
            System.out.println("4. Mostrar Matriz de Adyacencia");
            System.out.println("5. Fin");
            System.out.print("Ingrese la opcion: ");
            seleccion = scan.nextInt();      
           
            if(seleccion==1){
                matriz.Corto();
                System.out.print("Ciudad de salida: ");
                String c1 = scan.next(); 
                System.out.print("Ciudad de destino: ");
                String c2 = scan.next();
                if(matriz.grafoIn.contenido(c1)&&matriz.grafoIn.contenido(c2)){
                    System.out.println("\nLa distancia minima es: "+matriz.grafoIn.gete(c1, c2)+".");
                    if(matriz.grafoIn.gete(c1, c2)!=9999){
                        System.out.print("La ruta es: "+c1);
                        try {
                        matriz.Intermedias(matriz.grafoIn.geti(c1), matriz.grafoIn.geti(c2));
                        } catch (Exception e) {
                           System.out.println("");
                        }
                        
                        System.out.println(", "+c2);
                    }
                }
            }
            
            
            if(seleccion==2){
                System.out.print("El centro del grafo es: ");
                matriz.Grafo();
            }
            
            
            if(seleccion==3){
                System.out.println("    1. Hay interrupciones en Ciudades");
                System.out.println("    2. Establecer nueva conexion");
                System.out.print("       Ingrese la opcion: ");
                opcion = scan.nextInt(); 
                if(opcion==1){
                    System.out.print("     Ciudad de salida: ");
                    String c1 = scan.next();
                    System.out.print("     Ciudad de destino: ");
                    String c2 = scan.next();
                    if(matriz.grafoIn.contenido(c1)&&matriz.grafoIn.contenido(c2)){
                        matriz.grafoIn.agregare(c1, c2, 9999);
                        try {
                            matriz.archivo.Escribir(c1+" "+c2+" 9999");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                if(opcion==2){
                    System.out.print("    Ciudad de salida: ");
                    String c1 = scan.next();
                    System.out.print("    Ciudad de destino: ");
                    String c2 = scan.next();
                    System.out.print("    Distancia entre las ciudades: ");
                    int d = scan.nextInt();
                    if(matriz.grafoIn.contenido(c1)&&matriz.grafoIn.contenido(c2)){
                        matriz.grafoIn.agregare(c1, c2, d);
                    }
                    else{
                        matriz.grafoIn.agregar(c1);
                        matriz.grafoIn.agregar(c2);
                        matriz.grafoIn.agregare(c1, c2, d);
                    }
                    try {
                        matriz.archivo.Escribir(c1+" "+c2+" "+d);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                matriz.Corto();
            }
            if(seleccion==4){
                    System.out.println("");
                    System.out.println("Matriz de adyacencia: ");
                    matriz.grafoIn.mostrar();
            }
        }
    }
}