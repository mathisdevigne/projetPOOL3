/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

import colossalblitzcronkadventure.World;
import colossalblitzcronkadventure.items.Consumable;
import colossalblitzcronkadventure.items.Item;
import colossalblitzcronkadventure.items.Miscellaneous;
import colossalblitzcronkadventure.items.Weapon;
import colossalblitzcronkadventure.map.Location;
import colossalblitzcronkadventure.map.LockedExit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Represent the Player
 *
 * @author theodusehu
 */
public class Player extends FighterCharacter implements Talkable{
    private static final int DEF_INT = 0;
    private int intelligence;
    private final List<Item> INVENTORY = new ArrayList<>();
    public Enemy fightAgainst;
    private Item hand = null;    
    
    private static final Player BLITZCRONK = new Player("Blitzcronk", 20, 0);

    /** Constructor of object Player
     * @param NAME Name of the Player
     * @param MAX_PV Maximum number of PV
     * @param STRENGTH Strength (Attack) of the Player
    */
    private Player(String NAME, int MAX_PV, int STRENGTH) {
        super(NAME, MAX_PV, STRENGTH);
        this.fightAgainst = null;
        this.intelligence = DEF_INT;
    }

    /** Getter of object Player
     * 
     * @return The Player
     */
    public static Player getPlayer(){
        return Player.BLITZCRONK;
    }

    /** Getter of atttribute intelligence
     * @return Intelligence
    */
    public int getIntelligence() {
        return this.intelligence;
    }
    
    /** Upper of intelligence attribute
     * 
     * @param val Val to add to intelligence attribute
     */
    public void upIntelligence(int val){
        this.intelligence += val;
        if(this.intelligence%2 == 0){
            this.modifStrength(1);
        }
    }
    
    /** Getter of an Item from the INVENTORY
     *
     * @param name Name of the Item
     * @return Item
     */
    public Item getItem(String name){
        for(Item item : this.INVENTORY){
            if(item.getNAME().toUpperCase().equals(name)){
                return item;
            }
        }
        return null;
    }
    
    /** Remove an item from the INVENTORY by name
     *
     * @param name Name of the Item to remove
     */
    public void remItem(String name){
        for(Item item : this.INVENTORY){
            if(item.getNAME().equals(name)){
                INVENTORY.remove(item);
            }
        }
    }
    
    /** Add an Item to the INVENTORY
     *
     * @param item Item to add
     */
    public void addInventory(Item item){
        this.INVENTORY.add(item);
    }
    
    /** Remove an Item from INVENTORY
     *
     * @param item Item to remove
     */
    public void remInventory(Item item){
        this.INVENTORY.remove(item);
    }
    
    /** Add an Item to the hand of the Player
     *
     * @param item Item to Add
     */
    public void addHand(Item item){
        this.hand = item;
    }
    
    /** Remove an Item from the hand of the Player
     *
     */
    public void remHand(){
        this.hand = null;
    }

    @Override
    public void print() {
        System.out.println(this.getName() + ": " + this.getPv() + "/" + this.getMAX_PV() + " Int : " + this.intelligence + " Str : " + this.getStrength());
    }
    
    /** Print Items in the INVENTORY
     *
     */
    public void printInventory(){
        System.out.print("Inventory : ");
        int size = INVENTORY.size();
        int i = 1;
        for(Item item : INVENTORY){
            if(i < size){
                System.out.print(item.getNAME() + ", ");
                i++;
            }
            else{
                System.out.print(item.getNAME() + ".");
            }
            
        }
        System.out.println();
    }

    /** Global use command
     * 
     * @param name Name of the Item to use
     */
    public void use(String name) {
        Item item = this.getItem(name);
        if(item != null){
            if(this.hand == null){
                item.use();
                if(item instanceof Weapon){
                    this.addHand(item);
                }
                if(item instanceof Consumable){
                    remInventory(item);
                }
            }
            else{
                if(hand == item){
                    item.use();
                    if(item instanceof Weapon){
                        this.remHand();
                    }
                    if(item instanceof Consumable){
                        remInventory(item);
                    }
                }
                else{
                    if(item instanceof Miscellaneous){
                        item.use();
                    }
                    if(item instanceof Weapon){
                         System.out.println("You can't equip the weapon, first desequip the one you have.");
                    }
                    if(item instanceof Consumable){
                        item.use();
                        remInventory(item);
                    } 
                }
            }
            
        }
    }
    
    /** Use command to fuse objects
     * 
     * @param obj1 First object, base for fusion
     * @param obj2 Second object, use to know if fusion is possible
     */
    public void use(String obj1, String obj2){
        Item item1 = this.getItem(obj1);
        Item item2 = this.getItem(obj2);
        List<Person> listP = World.get().getCurrentLocation().getPERSONS();
        Optional<Person> pers = listP.stream().filter(p -> p.getName().equalsIgnoreCase(obj2)).findAny();
        if(item1 == null || (item2 == null && pers.isEmpty())){
            System.out.println("You don't have those objects.");
        }
        else{
            if(item1.hasInterItem(obj2)){
                Item fusedItem = item1.getInterItem(obj2);
                remInventory(item1);
                remInventory(item2);
                addInventory(fusedItem);
            }
            else if(pers.isPresent() && item1.hasInterPers(pers.get())){
                NPC pe = (NPC) pers.get();
                remInventory(item1);
                pe.changeTalk();
                if(pe.getName().equals("Dr.Mybak")){
                    pe.talk();
                    World.get().setEnd();
                }else{
                    this.upIntelligence(2);
                        for(Location l : World.get().getLOCATIONS()){
                            if(l.isExit(item1.getInterPers(pe).name()) && l.getExit(item1.getInterPers(pe)) instanceof LockedExit){
                                ((LockedExit)l.getExit(item1.getInterPers(pe))).unLock();
                            }
                        }  
                }
                
            }
        }
        
    }
   
    @Override
    public void talk() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
