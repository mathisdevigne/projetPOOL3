/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.items;

import java.util.HashMap;
import java.util.Map;

/** Represent an Item
 *
 * @author theodusehu
 */
public abstract class Item {
    
    private final String NAME;
    private final String DESCRIPTION;
    
    private Map<String, Item> interactions; 
    
    /** Constructor of object Item
     *
     * @param name Name of the Item
     * @param description Description of the Item
     */
    public Item(String name, String description){
        this.NAME = name;
        this.interactions = new HashMap<>();
        this.DESCRIPTION = description;
        
    }
    
    /** Add an Interaction between two object in this Item
     *
     * @param fusingItem Item to fuse with this Item to obtain the fusion Item
     * @param fusedItem Item obtain after the fusion
     */
    public void addInter(String fusingItem, Item fusedItem){
        this.interactions.put(fusingItem, fusedItem);
    }

    /** Getter of the name of the Item
     *
     * @return NAME
     */
    public String getNAME() {
        return this.NAME;
    }
    
    /** Getter of the description of the Item
     *
     * @return DESCRIPTION
     */
    public String getDes(){
        return this.DESCRIPTION;
    }
    
    /** Getter of the Interaction of this Item
     *
     * @param itemName Name of the Item's wanted interaction
     * @return Item obtain after the fusion
     */
    public Item getInter(String itemName){
        return interactions.get(itemName);
    }
    
    /** Boolean to know if the Item has an Interaction
     *
     * @param item Item to fuse with this Item
     * @return Boolean : True if there is an Interaction, or false is there isn't
     */
    public boolean hasInter(String item){
        return interactions.containsKey(item);
    }
    
    /** Print Interactions of each Items
     *
     */
    public void printInter(){
        System.out.println("INTERACTIONS : ");
        for(Map.Entry<String, Item> test : this.interactions.entrySet()){
            System.out.println(this.getNAME() + " + " + test.getKey() + " -> " + test.getValue().getNAME());
        } }
    
    /** Method to use an Item
     *
     */
    public abstract void use();

    /** Method to fuse two Items
     *
     * @param item Item to fuse with this Item
     */
    public abstract void use(Item item);
 
}
