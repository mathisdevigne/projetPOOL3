/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package colossalblitzcronkadventure.items;

import colossalblitzcronkadventure.character.Person;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Louis Richard
 */
public class ItemTest {
    
    public ItemTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of addInter method, of class Item.
     */
    @Test
    public void testAddInter() {
        System.out.println("addInter");
        String fusingItem = "";
        Item fusedItem = null;
        Item instance = null;
        instance.addInter(fusingItem, fusedItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPInterPers method, of class Item.
     */
    @Test
    public void testAddPInterPers() {
        System.out.println("addPInterPers");
        Person p = null;
        Item instance = null;
        instance.addPInterPers(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNAME method, of class Item.
     */
    @Test
    public void testGetNAME() {
        System.out.println("getNAME");
        Item instance = null;
        String expResult = "";
        String result = instance.getNAME();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDes method, of class Item.
     */
    @Test
    public void testGetDes() {
        System.out.println("getDes");
        Item instance = null;
        String expResult = "";
        String result = instance.getDes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInterItem method, of class Item.
     */
    @Test
    public void testGetInterItem() {
        System.out.println("getInterItem");
        String itemName = "";
        Item instance = null;
        Item expResult = null;
        Item result = instance.getInterItem(itemName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasInterPers method, of class Item.
     */
    @Test
    public void testHasInterPers() {
        System.out.println("hasInterPers");
        Person pers = null;
        Item instance = null;
        boolean expResult = false;
        boolean result = instance.hasInterPers(pers);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasInterItem method, of class Item.
     */
    @Test
    public void testHasInterItem() {
        System.out.println("hasInterItem");
        String item = "";
        Item instance = null;
        boolean expResult = false;
        boolean result = instance.hasInterItem(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printInter method, of class Item.
     */
    @Test
    public void testPrintInter() {
        System.out.println("printInter");
        Item instance = null;
        instance.printInter();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of use method, of class Item.
     */
    @Test
    public void testUse_0args() {
        System.out.println("use");
        Item instance = null;
        instance.use();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of use method, of class Item.
     */
    @Test
    public void testUse_Item() {
        System.out.println("use");
        Item item = null;
        Item instance = null;
        instance.use(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of look method, of class Item.
     */
    @Test
    public void testLook_List() {
        System.out.println("look");
        List<String> command = null;
        Item instance = null;
        instance.look(command);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of look method, of class Item.
     */
    @Test
    public void testLook_0args() {
        System.out.println("look");
        Item instance = null;
        instance.look();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ItemImpl extends Item {

        public ItemImpl() {
            super("", "");
        }

        public void use() {
        }

        public void use(Item item) {
        }
    }
    
}
