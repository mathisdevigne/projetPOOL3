/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.items;

import colossalblitzcronkadventure.character.Person;
import colossalblitzcronkadventure.command.Lookable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Represent an Item
 *
 * @author theodusehu
 */
public abstract class Item implements Lookable {
    
    private final String NAME;
    private final String DESCRIPTION;
    
    private Map<String, Item> interactions; 
    private List<Person> interactionsNpc; 
    
    /** Constructor of object Item
     *
     * @param name Name of the Item
     * @param description Description of the Item
     */
    public Item(String name, String description){
        this.NAME = name;
        this.interactions = new HashMap<>();
        this.interactionsNpc = new ArrayList<>();
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
    public Item getInterItem(String itemName){
        return interactions.get(itemName);
    }
    
    /** Boolean to know if the Item has an Interaction
     *
     * @param pers Person to fuse with this Item
     * @return Boolean : True if there is an Interaction, or false is there isn't
     */
    public boolean hasInterPers(Person pers){
        return interactionsNpc.contains(pers);
    }
    
    /** Boolean to know if the Item has an Interaction
     *
     * @param item Item to fuse with this Item
     * @return Boolean : True if there is an Interaction, or false is there isn't
     */
    public boolean hasInterItem(String item){
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
    
    /**
     * Look every arguments if possible
     * @param command 
     */
    public void look(List<String> command){
        this.look();
    }
    /**
     * Look everything
     */
    public void look(){
        System.out.println(this.DESCRIPTION);
    }
 
}
