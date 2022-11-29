/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure;

import colossalblitzcronkadventure.map.MapID;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author mathi
 */
public class Game {
    private World world;
    
    public Game(){
        this.world = World.get();
    }
    
    public void play() throws FileNotFoundException{
        this.world.initMapTest();
        Scanner input = new Scanner(System.in);
        String i;
        while(true){
            this.world.print();
            System.out.println("Where would you like to go ?");
            i = input.next();
            this.world.goTo(MapID.valueOf(i.toUpperCase()));    
        }
        //input.close();
    }
}
