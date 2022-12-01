/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure;

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
            this.WORLD.print();
        }
    }
}
