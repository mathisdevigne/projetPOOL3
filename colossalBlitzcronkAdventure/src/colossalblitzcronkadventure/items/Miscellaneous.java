/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.items;

import colossalblitzcronkadventure.character.Player;

/** Reprend a Miscelleneous Item
 *
 * @author theodusehu
 */
public class Miscellaneous extends Item{

    private Item resItem;
    
    /** Constructor of object Miscellaneous
     * 
     * @param name Name of the Item
     * @param description Description of the Item
     * @param resItem Name of the Item get by using this Item
     */
    public Miscellaneous(String name, String description, Item resItem) {
        super(name, description);
        this.resItem = resItem;
    }

    @Override
    public void use() {
        if(resItem != null){
            Player.getPlayer().addInventory(resItem);
            System.out.println("You've obtain " + resItem.getNAME() +".");
            Player.getPlayer().remInventory(this);
        }
    }

    @Override
    public void use(Item item) {
    }

   
    
}
