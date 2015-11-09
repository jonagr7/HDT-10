import static org.junit.Assert.*;

import org.junit.Test;

public class GphMTest4 {

	@Test
	public void test() {
		 Floyd matriz = new Floyd();
	     matriz.Corto(); 
	     System.out.println("\nMatriz de adyacencia");
         matriz.D.mostrar();
	}

}
