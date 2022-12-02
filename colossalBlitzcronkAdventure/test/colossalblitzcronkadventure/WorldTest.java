/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package colossalblitzcronkadventure;

import colossalblitzcronkadventure.character.Player;
import colossalblitzcronkadventure.map.Exit;
import colossalblitzcronkadventure.map.Location;
import colossalblitzcronkadventure.map.MapID;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Louis Richard
 */
public class WorldTest {
    World w = World.get();
    public WorldTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of parse method, of class World.
     */
    @Test
    public void testParseQuit() {
        System.out.println("parse");
        List<String> commandSplit = new ArrayList<>();
        commandSplit.add("QUIT");
        w.parse(commandSplit);
        assertTrue(w.isEnd());
    }

    /**
     * Test of parse method, of class World.
     */
    @Test
    public void testParseNoQuit() {
        System.out.println("parse");
        List<String> commandSplit = new ArrayList<>();
        commandSplit.add("Ahshad");
        w.parse(commandSplit);
        assertFalse(w.isEnd());
    }


    /**
     * Test of go method, of class World.
     */
    @Test
    public void testGo() {
        System.out.println("go");
        List<String> command = new ArrayList<>();
        command.add("GO");
        
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
}
