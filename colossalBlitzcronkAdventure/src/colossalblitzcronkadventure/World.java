/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure;

import colossalblitzcronkadventure.map.Exit;
import colossalblitzcronkadventure.map.Location;
import colossalblitzcronkadventure.map.MapID;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mathi
 */
public class World {
    private static final World WORLD = new World();
    private final List<Location> LOCATIONS;
    private Location currentLocation;
    
    private World(){
        this.LOCATIONS = new ArrayList<>();
        
    }
    
    public static World get(){
        return World.WORLD;
    }
    
    public void initMapTest() throws FileNotFoundException{        
        File file = new File(System.getProperty("user.dir") + "/src/colossalBlitzcronkAdventure/map/map.txt");
        Scanner input = new Scanner(file);
        while(input.hasNext()){
            MapID id = MapID.valueOf(input.next());
            String desc = "";
            String s = input.next();
            while(!s.equals("@")){
                desc += s + " ";
                s = input.next();
            }
            Location l = new Location(id, desc);
            String exit = input.next();
            while(!exit.equals("@")){
                l.addExits(new Exit(l.getID(), MapID.valueOf(exit)));
                exit = input.next();
            }
            this.LOCATIONS.add(l);
        }
        input.close();
        
        this.currentLocation = this.LOCATIONS.get(0);
    }
    
    public Location getLocation(MapID id){
        for(Location l : this.LOCATIONS){
            if(l.getID() == id){
                return l;
            }
        }
        return null;
    }
    
    public void goTo(MapID name){
        if(this.currentLocation.isExit(name)){
            MapID l = this.currentLocation.getExit(name);
            if(l != null){
                this.currentLocation = this.getLocation(l);
            }
        }
    }
    
    public void print(){
        this.currentLocation.print();
    }
}
