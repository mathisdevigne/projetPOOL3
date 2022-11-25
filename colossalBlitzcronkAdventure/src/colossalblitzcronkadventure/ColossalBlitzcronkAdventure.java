/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colossalblitzcronkadventure;

import colossalblitzcronkadventure.character.Enemy;
import colossalblitzcronkadventure.character.NPC;
import colossalblitzcronkadventure.character.Player;


/**
 *
 * @author mathi
 */
public class ColossalBlitzcronkAdventure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player blitz = Player.getPlayer();
        Enemy boop = new Enemy("Boop", 10, 10);
        NPC blip = new NPC("Blip");
        
        blitz.print();
        boop.print();
        blip.print();
        
        blitz.takeDamage(21);
        boop.takeDamage(20);
        
        blitz.print();
        boop.print();
        
        blip.talkId(1);
        blitz.talkId(0);
    }
    
}
