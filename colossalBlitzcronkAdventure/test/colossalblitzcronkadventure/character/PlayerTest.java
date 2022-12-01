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
     * Test of getName method, of abstract class Person.
     */
    @Test
    public void testName() {
        System.out.println("getName");
        Player instance = p;
        assertEquals("Blitzcronk", instance.getName());
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
    
    /**
     * Test of getMAX_PV method, of abstract class FighterCharacter.
     */
    @Test
    public void testTakeTooMuchDamage() {
        System.out.println("takeDamage");
        Player instance = p;
        instance.takeDamage(30);
        assertEquals(0, instance.getPv());
    }
}
