/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure;

/**
 *
 * @author mathi
 */
public class World {
    private static final World WORLD = new World();
    
    private World(){
        
    }
    
    public static World get(){
        return World.WORLD;
    }
}
