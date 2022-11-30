/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.items;

import colossalblitzcronkadventure.character.Player;

/** Represent a Consumable Item
 *
 * @author theodusehu
 */
public class Consumable extends Item {
    
    private final String TYPE;
    private final int VALUE;
    
    /** Constructor of object Consumable
     * 
     * @param name Name of the Item
     * @param description Description of the Item
     * @param type Type of the Item
     * @param value Value of the Item
     */
    public Consumable(String name, String description, String type, int value) {
        super(name, description);
        this.TYPE = type;
        this.VALUE = value;
    }

    @Override
    public void use() {
        switch(this.TYPE){
            case "H" : Player.getPlayer().modifHealth(VALUE); break;
        }
    }

    @Override
    public void use(Item item) {
    }

   
    
}
