/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package colossalblitzcronkadventure.items;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Louis Richard
 */
public class initItemsTest {
    
    public initItemsTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getList method, of class initItems.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        List<Item> expResult = null;
        List<Item> result = initItems.getList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creaItem method, of class initItems.
     */
    @Test
    public void testCreaItem() throws Exception {
        System.out.println("creaItem");
        initItems.creaItem();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printItem method, of class initItems.
     */
    @Test
    public void testPrintItem() {
        System.out.println("printItem");
        initItems.printItem();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
