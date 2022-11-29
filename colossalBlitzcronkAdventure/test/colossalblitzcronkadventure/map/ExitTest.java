/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package colossalblitzcronkadventure.map;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Louis Richard
 */
public class ExitTest {
    private Exit exit;
    private MapID origin;
    private MapID dest;
            
    public ExitTest() {
    }
    
    @Before
    public void setUp() {
        origin = MapID.DEPTH;
        dest = MapID.DUMP;
        exit = new Exit(origin, dest);
        
    }

    /**
     * Test of getDESTINATION method, of class Exit.
     */
    @Test
    public void testGetDESTINATION() {
        System.out.println("getDESTINATION");
        Exit instance = exit;
        MapID expResult = dest;
        MapID result = instance.getDESTINATION();
        assertEquals(expResult, result);
    }

    /**
     * Test of isOrigin method, of class Exit.
     */
    @Test
    public void testIsOrigin() {
        System.out.println("isOrigin");
        MapID id = origin;
        Exit instance = exit;
        boolean expResult = true;
        boolean result = instance.isOrigin(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getORIGIN method, of class Exit.
     */
    @Test
    public void testGetORIGIN() {
        System.out.println("getORIGIN");
        Exit instance = exit;
        MapID expResult = origin;
        MapID result = instance.getORIGIN();
        assertEquals(expResult, result);
    }
    
}
