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
                System.out.println("Ciudad de salida");
                String ciudad1 = scan.next(); 
                System.out.println("Ciudad de destino");
                String ciudad2 = scan.next();
                
                if(matriz.D.contenido(ciudad1)&&matriz.D.contenido(ciudad2)){
                    System.out.println("\nLa distancia minima es: "+matriz.D.gete(ciudad1, ciudad2)+".");
                    if(matriz.D.gete(ciudad1, ciudad2)!=9999){
                        System.out.print("La ruta es: "+ciudad1);
                        matriz.Intermedias(matriz.D.geti(ciudad1), matriz.D.geti(ciudad2));
                        System.out.println(", "+ciudad2);
                    }
                }
            }
            
            
            if(seleccion==2){
                System.out.print("El centro del grafo es: ");
                matriz.Grafo();
            }
            
            
            else if(seleccion==3){
                System.out.println("1. Hay interrupciones en Ciudades");
                System.out.println("2. Establecer nueva conexion");
                opcion = scan.nextInt();
                
                if(opcion==1){
                    System.out.println("Ciudad de salida");
                    String ciudad1 = scan.next();
                    System.out.println("Ciudad de destino");
                    String ciudad2 = scan.next();
                    if(matriz.D.contenido(ciudad1)&&matriz.D.contenido(ciudad2)){
                        matriz.D.agregare(ciudad1, ciudad2, 9999);
                        try {
                            matriz.archivo.Escribir(ciudad1+" "+ciudad2+" 9999");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                else if(opcion==2){
                    System.out.println("Ciudad de salida: ");
                    String ciudad1 = scan.next();
                    System.out.println("Ciudad de destino: ");
                    String ciudad2 = scan.next();
                    System.out.println("Distancia entre las ciudades");
                    int distancia = scan.nextInt();
                    if(matriz.D.contenido(ciudad1)&&matriz.D.contenido(ciudad2)){
                        matriz.D.agregare(ciudad1, ciudad2, distancia);
                    }
                    else{
                        matriz.D.agregar(ciudad1);
                        matriz.D.agregar(ciudad2);
                        matriz.D.agregare(ciudad1, ciudad2, distancia);
                    }
                    try {
                        matriz.archivo.Escribir(ciudad1+" "+ciudad2+" "+distancia);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                else if(opcion==4){
                    System.out.println("\nMatriz de adyacencia");
                    matriz.D.mostrar();
                }
                matriz.Corto();
            }
        }
    }
}