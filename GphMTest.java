import static org.junit.Assert.*;

import org.junit.Test;

public class GphMTest {

	@Test
	public void test() {
		Floyd v = new Floyd();
		v.Corto(); 
		if(v.D.contenido("Guatemala")&&v.D.contenido("Antigua")){
            System.out.println("\nLa distancia minima es: "+v.D.gete("Guatemala", "Antigua")+".");
            if(v.D.gete("Guatemala", "Antigua")!=10000){
                System.out.print("La ruta es: "+"Guatemala");
                v.Intermedias(v.D.geti("Guatemala"), v.D.geti("Antigua"));
                System.out.println(", "+"Antigua");
            }
        }
	}

}
