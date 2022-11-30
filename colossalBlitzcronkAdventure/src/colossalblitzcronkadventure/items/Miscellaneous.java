/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.items;

import colossalblitzcronkadventure.character.Player;
import java.util.List;

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
     * @param resName Name of the Item get by using this Item
     */
    public Miscellaneous(String name, String description, String resName) {
        super(name, description);
        List<Item> itemList = initItems.getList();
        for(Item item : itemList){
            if(item.getNAME().equals(resName))
                this.resItem = item;
        }
    }

    @Override
    public void use() {
        Player.getPlayer().addInventory(new Miscellaneous(resItem.getNAME(), resItem.getDes(), null));
        System.out.println("You've obtain " + resItem.getNAME() +".");
    }

    @Override
    public void use(Item item) {
    }

   
    
}
