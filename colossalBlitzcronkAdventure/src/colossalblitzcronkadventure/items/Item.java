/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.items;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author theodusehu
 */
public abstract class Item {
    
    private final String NAME;
    private final String DESCRIPTION;
    
    private Map<String, Item> interactions; 
    
    public Item(String name, String description){
        this.NAME = name;
        this.interactions = new HashMap<>();
        this.DESCRIPTION = description;
        
    }
    
    public void addInter(String fusingItem, Item fusedItem){
        this.interactions.put(fusingItem, fusedItem);
    }

    public String getNAME() {
        return this.NAME;
    }
    
    public String getDes(){
        return this.DESCRIPTION;
    }
    
    public Item getInter(String itemName){
        return interactions.get(itemName);
    }
    
    public boolean hasInter(String item){
        return interactions.containsKey(item);
    }
    
    public void printInter(){
        System.out.println("INTERACTIONS : ");
        for(Map.Entry<String, Item> test : this.interactions.entrySet()){
            System.out.println(this.getNAME() + " + " + test.getKey() + " -> " + test.getValue().getNAME());
        } }
    
    public abstract void use();
    public abstract void use(Item item);
 
}
