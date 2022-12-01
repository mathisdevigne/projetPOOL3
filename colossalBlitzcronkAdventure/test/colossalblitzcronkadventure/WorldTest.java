/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package colossalblitzcronkadventure;

import colossalblitzcronkadventure.character.Player;
import colossalblitzcronkadventure.map.Location;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Louis Richard
 */
public class WorldTest {
    
    public WorldTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of get method, of class World.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        World expResult = null;
        World result = World.get();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class World.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        World instance = null;
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scanParse method, of class World.
     */
    @Test
    public void testScanParse() {
        System.out.println("scanParse");
        World instance = null;
        boolean expResult = false;
        boolean result = instance.scanParse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parse method, of class World.
     */
    @Test
    public void testParse() {
        System.out.println("parse");
        List<String> commandSplit = null;
        World instance = null;
        boolean expResult = false;
        boolean result = instance.parse(commandSplit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentLocation method, of class World.
     */
    @Test
    public void testGetCurrentLocation() {
        System.out.println("getCurrentLocation");
        World instance = null;
        Location expResult = null;
        Location result = instance.getCurrentLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class World.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        String id = "";
        World instance = null;
        Location expResult = null;
        Location result = instance.getLocation(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of go method, of class World.
     */
    @Test
    public void testGo() {
        System.out.println("go");
        List<String> command = null;
        World instance = null;
        instance.go(command);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lookAt method, of class World.
     */
    @Test
    public void testLookAt() {
        System.out.println("lookAt");
        List<String> command = null;
        World instance = null;
        instance.lookAt(command);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quit method, of class World.
     */
    @Test
    public void testQuit() {
        System.out.println("quit");
        List<String> command = null;
        World instance = null;
        boolean expResult = false;
        boolean result = instance.quit(command);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of use method, of class World.
     */
    @Test
    public void testUse() {
        System.out.println("use");
        List<String> command = null;
        World instance = null;
        instance.use(command);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of take method, of class World.
     */
    @Test
    public void testTake() {
        System.out.println("take");
        List<String> command = null;
        World instance = null;
        instance.take(command);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printFight method, of class World.
     */
    @Test
    public void testPrintFight() {
        System.out.println("printFight");
        Player p = null;
        World instance = null;
        instance.printFight(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fight method, of class World.
     */
    @Test
    public void testFight() {
        System.out.println("fight");
        List<String> command = null;
        World instance = null;
        instance.fight(command);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of heal method, of class World.
     */
    @Test
    public void testHeal() {
        System.out.println("heal");
        World instance = null;
        instance.heal();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leaves method, of class World.
     */
    @Test
    public void testLeaves() {
        System.out.println("leaves");
        World instance = null;
        instance.leaves();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attack method, of class World.
     */
    @Test
    public void testAttack() {
        System.out.println("attack");
        World instance = null;
        instance.attack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
