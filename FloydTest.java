/**
 * @author Pablo Argueta, Carnet: 13028
 * @author Héctor Möller, Carnet: 09002
 * 
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FloydTest {
    
    public FloydTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * testCaminoCorto: Prueba unitaria del método CaminoCorto.
     */
    @Test
    public void testCaminoCorto() {
        System.out.println("caminoCorto");
        Floyd instance = new Floyd();
        instance.caminoCorto();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * testCentroGrafo: Prueba unitaria del método centroGrafo.
     */
    @Test
    public void testCentroGrafo() {
        System.out.println("centroGrafo");
        Floyd instance = new Floyd();
        String expResult = "";
        String result = instance.centroGrafo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * testMostrarIntermedias: Prueba unitaria del método mostrarIntermedias.
     */
    @Test
    public void testMostrarIntermedias() {
        System.out.println("mostrarIntermedias");
        int num1 = 0;
        int num2 = 0;
        Floyd instance = new Floyd();
        instance.mostrarIntermedias(num1, num2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
