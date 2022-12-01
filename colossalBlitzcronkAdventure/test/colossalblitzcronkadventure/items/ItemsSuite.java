/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package colossalblitzcronkadventure.items;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Louis Richard
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({colossalblitzcronkadventure.items.ConsumableTest.class, colossalblitzcronkadventure.items.MiscellaneousTest.class, colossalblitzcronkadventure.items.WeaponTest.class, colossalblitzcronkadventure.items.initItemsTest.class, colossalblitzcronkadventure.items.ItemTest.class})
public class ItemsSuite {

    @Before
    public void setUp() throws Exception {
    }
    
}
