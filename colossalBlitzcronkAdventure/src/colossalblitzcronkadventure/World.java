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
    private List<Location> locations;
    private Location currentLocation;
    
    private World(){
        this.locations = new ArrayList<>();
        
    }
    
    public static World get(){
        return World.WORLD;
    }
    
    public void initMapTest() throws FileNotFoundException{
        File f = new File(System.getProperty("user.dir") + "/src/colossalBlitzcronkAdventure/map/map.txt");        
        Scanner input = new Scanner(f);
        Map<MapID, List<MapID>> exits = new HashMap<>();
        while(input.hasNext()){
            MapID id = MapID.valueOf(input.next());
            String desc = "";
            String s = input.next();
            while(!s.equals("@")){
                desc += s + " ";
                s = input.next();
            }
            Location l = new Location(id, desc);
            exits.put(id, new ArrayList<>());
            String exit = input.next();
            while(!exit.equals("@")){
                exits.get(id).add(MapID.valueOf(exit));
                exit = input.next();
            }
            this.locations.add(l);
        }
        input.close();
        for(Location n : this.locations){
            for(MapID id : exits.get(n.getID())){
                n.addExits(new Exit(n, this.getLocation(id)));
            }
        }
        
        
        /*for(int i = 0; i < 5; i++){
            this.locations.add(new Location(MapID.values()[i], "Ceci est la Salle "+(1+i)));
        }
        for(Location n : this.locations){
            n.addExits(new Exit(n, this.locations.get(2)));
        }*/
        
        this.currentLocation = this.locations.get(0);
    }
    
    public Location getLocation(MapID id){
        for(Location l : this.locations){
            if(l.getID() == id){
                return l;
            }
        }
        return null;
    }
    
    public void goTo(MapID name){
        if(this.currentLocation.isExit(name)){
            this.currentLocation = this.currentLocation.getExit(name);
        }
    }
    
    public void print(){
        this.currentLocation.print();
    }
}
