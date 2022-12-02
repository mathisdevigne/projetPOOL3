/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package colossalblitzcronkadventure.items;

import colossalblitzcronkadventure.character.NPC;
import colossalblitzcronkadventure.character.Person;
import colossalblitzcronkadventure.map.MapID;
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
        String fusingItem = "Test";
        Item fusedItem = new Miscellaneous("Misc", "desc", null);
        Item instance = new Weapon("Name", "desc", 10);
        instance.addInter(fusingItem, fusedItem);
        assertTrue(instance.hasInterItem(fusingItem));
        assertEquals(fusedItem,instance.getInterItem(fusingItem));
        
    }

    /**
     * Test of addPInterPers method, of class Item.
     */
    @Test
    public void testAddPInterPers() {
        System.out.println("addPInterPers");
        Person p = new NPC("Bob", "test", "test");
        Item instance = new Weapon("Name", "desc", 10);
        instance.addPInterPers(p, MapID.END);
        assertEquals(MapID.END,instance.getInterPers(p));
        p = null;
        assertNotEquals(MapID.END, instance.getInterPers(p));

    }

    /**
     * Test of getInterItem method, of class Item.
     */
    @Test
    public void testGetInterItem() {
        System.out.println("getInterItem");
        String itemName = "Name";
        Item instance = new Weapon("Name", "desc", 10);
        Item expResult = new Miscellaneous("Misc", "desc", null);
        instance.addInter(itemName, expResult);   
        Item result = instance.getInterItem(itemName);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasInterPers method, of class Item.
     */
    @Test
    public void testHasInterPers() {
        System.out.println("hasInterPers");
        Person p = new NPC("Bob", "test", "test");
        Item instance = new Weapon("Name", "desc", 10);
        instance.addPInterPers(p, MapID.END);
        assertTrue(instance.hasInterPers(p));
        
    }

    /**
     * Test of hasInterItem method, of class Item.
     */
    @Test
    public void testHasInterItem() {
        System.out.println("hasInterItem");
        String fusingItem = "Test";
        Item fusedItem = new Miscellaneous("Misc", "desc", null);
        Item instance = new Weapon("Name", "desc", 10);
        instance.addInter(fusingItem, fusedItem);
        assertTrue(instance.hasInterItem(fusingItem));
    }
}
