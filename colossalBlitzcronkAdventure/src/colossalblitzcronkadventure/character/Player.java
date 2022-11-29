/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

import colossalblitzcronkadventure.items.Item;
import colossalblitzcronkadventure.items.Miscellaneous;
import colossalblitzcronkadventure.items.Weapon;
import colossalblitzcronkadventure.items.initItems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Represent the Player
 *
 * @author theodusehu
 */
public class Player extends FighterCharacter implements Talkable{
    private static final int DEF_INT = 0;
    private int intelligence;
    private List<Item> inventory = new ArrayList<>();
    private Item hand = null;    
    
    private static final Player BLITZCRONK = new Player("Blitzcrong", 20, 10);

    /** Constructor of object Player
     * @param NAME Name of the Player
     * @param MAX_PV Maximum number of PV
     * @param STRENGTH Strength (Attack) of the Player
    */
    private Player(String NAME, int MAX_PV, int STRENGTH) {
        super(NAME, MAX_PV, STRENGTH);
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
        this.intelligence =+ val;
    }
    
    public Item getItem(String name){
        for(Item item : this.inventory){
            if(item.getNAME().equals(name)){
                return item;
            }
        }
        return null;
    }
    
    public void remItem(String name){
        for(Item item : this.inventory){
            if(item.getNAME().equals(name)){
                inventory.remove(item);
            }
        }
    }
    
    public void addInventory(Item item){
        this.inventory.add(item);
    }
    
    public void remInventory(Item item){
        this.inventory.remove(item);
    }
    
    public void addHand(Item item){
        this.hand = item;
    }
    
    public void remHand(){
        this.hand = null;
    }

    @Override
    public void print() {
        System.out.println(this.getName() + ": " + this.getPv() + "/" + this.getMAX_PV() + " Int : " + this.intelligence + " Str : " + this.getStrength());
    }
    
    public void printInventory(){
        System.out.print("Inventory : ");
        int size = inventory.size();
        int i = 1;
        for(Item item : inventory){
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
     * @param name 
     */
    public void use(String name) {
        Item item = this.getItem(name);
        if(item != null){
            if(this.hand == null){
                item.use();
                if(item instanceof Weapon){
                    this.addHand(item);
                }
            }
            else{
                item.use();
                if(item instanceof Weapon){
                    this.remHand();
                }
            }
            
        }
    }
    
    /** Use command to fuse objects
     * 
     * @param obj1
     * @param obj2 
     */
    public void use(String obj1, String obj2){
        Item item1 = this.getItem(obj1);
        Item item2 = this.getItem(obj2);
        List<Item> list = initItems.getList();
        if(item1 == null || item2 == null){
            System.out.println("You don't have those objects.");
        }
        else{
            if(item1.hasInter(obj2)){
                System.out.print("Interaction possible, would you like to fuse ? (y/n) : ");
                Scanner sc = new Scanner(System.in);
                String res = sc.next();
                if("y".equals(res)){
                    Item fusedItem = item1.getInter(obj2);
                    remInventory(item1);
                    remInventory(item2);
                    addInventory(fusedItem);
                }
                sc.close();
            }
        }
        
    }

    @Override
    public void talkId(int id) {
        System.out.println(Player.DIALOGUES.get(id));
    }
}
