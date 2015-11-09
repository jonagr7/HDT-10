import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class GphMTest3 {

	@Test
	public void test() {
		Floyd matriz = new Floyd();
	    matriz.Corto(); 
		System.out.println("1. Hay interrupciones en Ciudades");
        System.out.println("2. Establecer nueva conexion");
        String ciudad1 = "Antigua";
        String ciudad2 = "Escuintla";
            System.out.println("Ciudad de salida");
            System.out.println("Ciudad de destino");
            if(matriz.D.contenido(ciudad1)&&matriz.D.contenido(ciudad2)){
                matriz.D.agregare(ciudad1, ciudad2, 9999);
                try {
                    matriz.archivo.Escribir(ciudad1+" "+ciudad2+" 9999");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
 
            System.out.println("Ciudad de salida: ");
            System.out.println("Ciudad de destino: ");
            System.out.println("Distancia entre las ciudades");
            int distancia = 250;
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
	}

}
