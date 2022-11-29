/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colossalblitzcronkadventure;

import colossalblitzcronkadventure.character.Enemy;
import colossalblitzcronkadventure.character.NPC;
import colossalblitzcronkadventure.character.Player;
import colossalblitzcronkadventure.items.Item;
import colossalblitzcronkadventure.items.Weapon;
import colossalblitzcronkadventure.items.initItems;
import java.io.FileNotFoundException;
import java.util.List;


/**
 *
 * @author mathi
 */
public class ColossalBlitzcronkAdventure {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        Player blitz = Player.getPlayer();
        Enemy boop = new Enemy("Boop", 10, 10);
        NPC blip = new NPC("Blip");
        initItems.creaItem();
        
        List<Item> list = initItems.getList();
        /*for(Item item : list){
            item.printInter();
        }*/
        
        Player.getPlayer().addInventory(list.get(1));
        Player.getPlayer().addInventory(list.get(3));
        
        Player.getPlayer().printInventory();
        Player.getPlayer().use("Stick", "String");
        Player.getPlayer().printInventory();

        
        /*blitz.print();
        boop.print();
        blip.print();
        
        blitz.takeDamage(21);
        boop.takeDamage(20);
        
        blitz.print();
        //boop.print();
        
        blitz.use("Excaliburne");
        
        blitz.print();
        
        blitz.use("Excaliburne");
        
        blitz.print();
        
        //Weapon ex = new Weapon("Stick", 0);
        
        //ex.printInter();
        
        //blitz.addInventory(item);
        
        
        //Game g = new Game();
        //g.play(); */
    }
    
}
