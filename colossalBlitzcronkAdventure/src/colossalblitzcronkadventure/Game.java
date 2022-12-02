/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure;

import colossalblitzcronkadventure.character.Player;

/** Class to play the Game
 *
 * @author mathi
 */
public class Game {
    private final World WORLD;
    
    /**
     * Get the world
     */
    public Game(){
        this.WORLD = World.get();
    }
    
    /**
     * Play one round
     */
    public void play(){
        this.WORLD.print();
        while(!this.WORLD.scanParse()){
            if(Player.getPlayer().fightAgainst != null){
                this.fight();
            }
            if(this.WORLD.isEnd()){
                break;
            }
            this.WORLD.print();
        }
        this.finish();
    }
    
    /**
     * Begin a fight
     */
    private void fight(){
        while(Player.getPlayer().fightAgainst != null && !this.WORLD.scanParse()){
            if(Player.getPlayer().fightAgainst != null){
                this.WORLD.printFight(Player.getPlayer());
            }
        }
    }
    
    private void finish(){
        
    }
}
