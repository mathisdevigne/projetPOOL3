/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package colossalblitzcronkadventure.map;

import colossalblitzcronkadventure.character.Person;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Louis Richard
 */
public class LocationTest {
    private MapID idOrig;
    private MapID idDest;
    private String description;
    private Location location;
    private Exit exit;
    private Person person;
    
    public LocationTest() {
    }
    
    @Before
    public void setUp() {
        idOrig = MapID.DUMP;
        idDest = MapID.DEPTH;
        description = "Desc";
        location = new Location(idOrig, description);
        exit = new Exit(idOrig, idDest);
        person = new Person("Name"){
            @Override
            public void print(){
                System.out.println(this.getName());
            }
        };
    }

    /**
     * Test of addExits method, of class Location.
     */
    @Test
    public void testAddExits() {
        System.out.println("addExits");
        Exit newExit = exit;
        Location instance = location;
        instance.addExits(newExit);
        assertTrue(instance.isExit(idDest.name()));
    }

    /**
     * Test of addExits method, of class Location.
     */
    @Test
    public void testAddExitsNull() {
        System.out.println("addExits");
        Location instance = location;
        instance.addExits(null);
    }

    /**
     * Test of addPerson method, of class Location.
     */
    @Test
    public void testAddPerson() {
        System.out.println("addPerson");
        Person p = person;
        Location instance = location;
        instance.addPerson(p);
        assertTrue(location.getPERSONS().contains(p));
    }

    /**
     * Test of addPerson method, of class Location.
     */
    @Test
    public void testAddPersonNull() {
        System.out.println("addPerson");
        Location instance = location;
        instance.addPerson(null);
        assertEquals(instance.getPERSONS().size(),0); 
    }

    /**
     * Test of getID method, of class Location.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Location instance = location;
        MapID expResult = idOrig;
        MapID result = instance.getID();
        assertEquals(expResult, result);
    }


    /**
     * Test of isExit method, of class Location.
     */
    @Test
    public void testIsExit() {
        System.out.println("isExit");
        MapID id = idDest;
        Location instance = location;
        instance.addExits(exit);
        boolean expResult = true;
        boolean result = instance.isExit(id.name());
        assertEquals(expResult, result);
    }

    /**
     * Test of isExit method, of class Location.
     */
    @Test
    public void testIsExitNot() {
        System.out.println("isExit");
        MapID id = idDest;
        Location instance = location;
        instance.addExits(exit);
        boolean expResult = false;
        boolean result = instance.isExit("no exit");
        assertEquals(expResult, result);
    }
    /**
     * Test of isExit method, of class Location.
     */
    @Test
    public void testIsExitNull() {
        System.out.println("isExit");
        MapID id = idDest;
        Location instance = location;
        instance.addExits(exit);
        boolean expResult = false;
        boolean result = instance.isExit(null);
        assertEquals(expResult, result);
    }

    /**
     * Test of getExit method, of class Location.
     */
    @Test
    public void testGetExit() {
        System.out.println("getExit");
        MapID id = idDest;
        Location instance = location;
        instance.addExits(exit);
        MapID expResult = idDest;
        Exit result = instance.getExit(id);
        assertEquals(expResult, result.getDESTINATION());
    }

    /**
     * Test of equals method, of class Location.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Location(idOrig, "");
        Location instance = location;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Location.
     */
    @Test
    public void testEqualsNull() {
        System.out.println("equals");
        Object obj = new Location(idOrig, "");
        Location instance = location;
        boolean expResult = false;
        boolean result = instance.equals(null);
        assertEquals(expResult, result);
    }

    
}
