/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package colossalblitzcronkadventure.items;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Louis Richard
 */
public class WeaponTest {
    
    public WeaponTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of use method, of class Weapon.
     */
    @Test
    public void testUse() {
        System.out.println("use");
        Weapon instance = null;
        instance.use();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of use method, of class Weapon.
     */
    @Test
    public void testUse_Item() {
        System.out.println("use");
        Item item = null;
        Weapon instance = null;
        instance.use(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
