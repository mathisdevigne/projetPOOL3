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
public class EnemyTest {
    
    Enemy bloop;
    
    @Before
    public void setUp() {
        bloop = new Enemy("Bloop",10,10);
    }

    /**
     * Test of getName method, of abstract class Person.
     */
    @Test
    public void testName() {
        System.out.println("getName");
        Enemy instance = bloop;
        assertEquals("Bloop", instance.getName());
    }
    
    /**
     * Test of getMAX_PV method, of abstract class FighterCharacter.
     */
    @Test
    public void testGetMAX_PV() {
        System.out.println("getMAX_PV");
        Enemy instance = bloop;
        assertEquals(10, instance.getMAX_PV());
    }
    
    /**
     * Test of getPv method, of abstract class FighterCharacter.
     */
    @Test
    public void testGetPv() {
        System.out.println("getPv");
        Enemy instance = bloop;
        assertEquals(10, instance.getPv());
    }
    
    /**
     * Test of getMAX_PV method, of abstract class FighterCharacter.
     */
    @Test
    public void testGetSTRENGTH(){
        System.out.println("getSTRENGTH");
        Enemy instance = bloop;
        assertEquals(10, instance.getSTRENGTH());
    }
    
    /**
     * Test of getMAX_PV method, of abstract class FighterCharacter.
     */
    @Test
    public void testTakeDamage() {
        System.out.println("takeDamage");
        Enemy instance = bloop;
        instance.takeDamage(5);
        assertEquals(5, instance.getPv());
    }
    
}
