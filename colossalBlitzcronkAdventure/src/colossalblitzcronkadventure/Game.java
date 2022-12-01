/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure;

import colossalblitzcronkadventure.character.Player;

/**
 *
 * @author mathi
 */
public class Game {
    private final World WORLD;
    
    public Game(){
        this.WORLD = World.get();
    }
    
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
