/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package colossalblitzcronkadventure.character;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author theodusehu
 */
public class PlayerTest {
    
    Player p;
    
    @Before
    public void setUp() {
        p = Player.getPlayer();
    }

    /**
     * Test of getPlayer method, of class Player.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        Player expResult = p;
        Player result = Player.getPlayer();
        assertEquals(expResult, result);   
    }

    /**
     * Test of upIntelligence method, of class Player.
     */
    @Test
    public void testUpIntelligence() {
        System.out.println("upIntelligence");
        int val = 5;
        Player instance = p;
        instance.upIntelligence(val);
        assertEquals(5, instance.getIntelligence());
        
    }

    /**
     * Test of getIntelligence method, of class Player.
     */
    @Test
    public void testGetIntelligence() {
        System.out.println("getIntelligence");
        Player instance = p;
        assertEquals(5, instance.getIntelligence());
        
    }
    
    /**
     * Test of getName method, of abstract class Person.
     */
    @Test
    public void testName() {
        System.out.println("getName");
        Player instance = p;
        assertEquals("Blitzcrong", instance.getName());
    }
    
    /**
     * Test of getMAX_PV method, of abstract class FighterCharacter.
     */
    @Test
    public void testGetMAX_PV() {
        System.out.println("getMAX_PV");
        Player instance = p;
        assertEquals(20, instance.getMAX_PV());
    }
    
    /**
     * Test of getPv method, of abstract class FighterCharacter.
     */
    @Test
    public void testGetPv() {
        System.out.println("getPv");
        Player instance = p;
        assertEquals(20, instance.getPv());
    }
    
    /**
     * Test of getMAX_PV method, of abstract class FighterCharacter.
     */
    @Test
    public void testGetSTRENGTH(){
        System.out.println("getSTRENGTH");
        Player instance = p;
        assertEquals(10, instance.getSTRENGTH());
    }
    
    /**
     * Test of getMAX_PV method, of abstract class FighterCharacter.
     */
    @Test
    public void testTakeDamage() {
        System.out.println("takeDamage");
        Player instance = p;
        instance.takeDamage(5);
        assertEquals(15, instance.getPv());
    }
}
