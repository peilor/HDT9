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

public class MatrizGrafoTest {
    
    public MatrizGrafoTest() {
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
     * testAgregarNodo: Prueba unitaria del método agregarNodo.
     */
    @Test
    public void testAgregarNodo() {
        System.out.println("agregarNodo");
        Object contenido = null;
        MatrizGrafo instance = new MatrizGrafo();
        instance.agregarNodo(contenido);
        instance.obtenerNodo(1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * testAgregarConexion: Prueba unitaria del método agregarConexion.
     */
    @Test
    public void testAgregarConexion() {
        System.out.println("agregarConexion");
        Object v1 = null;
        Object v2 = null;
        Object contenido = null;
        MatrizGrafo instance = new MatrizGrafo();
        instance.agregarConexion(v1, v2, contenido);
        instance.obtenerNodo(1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
