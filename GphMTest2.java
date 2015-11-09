import static org.junit.Assert.*;

import org.junit.Test;

public class GphMTest2 {

	@Test
	public void test() {
		Floyd matriz = new Floyd();
        matriz.Corto(); 
        System.out.print("El centro del grafo es: ");
        matriz.Grafo();
	}

}
