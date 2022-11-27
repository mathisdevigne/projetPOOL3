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
public class LockedExitTest {
    private LockedExit exit;
    private MapID origin;
    private MapID dest;

    public LockedExitTest() {
    }

    @Before
    public void setUp() {
        origin = MapID.DEPTH;
        dest = MapID.DUMP;
        exit = new LockedExit(origin, dest);
        
    }
    
    /**
     * Test of isLock method, of class LockedExit.
     */
    @Test
    public void testIsLock() {
        System.out.println("isLock");
        LockedExit instance = exit;
        boolean expResult = true;
        boolean result = instance.isLock();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of unLock method, of class LockedExit.
     */
    @Test
    public void testUnLock() {
        System.out.println("unLock");
        LockedExit instance = exit;
        instance.unLock();
        assertFalse(exit.isLock());
    }

    /**
     * Test of getDESTINATION method, of class LockedExit.
     */
    @Test
    public void testGetDESTINATION() {
        System.out.println("getDESTINATION");
        LockedExit instance = exit;
        MapID expResult = null;
        MapID result = instance.getDESTINATION();
        assertEquals(expResult, result);
    }
    
}
