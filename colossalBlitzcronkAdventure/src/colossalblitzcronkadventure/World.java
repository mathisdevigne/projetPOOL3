/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure;

import colossalblitzcronkadventure.map.Location;
import colossalblitzcronkadventure.map.MapID;
import java.util.ArrayList;
import java.util.List;

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
    
    public void initMapTest(){
        for(int i = 0; i < 5; i++){
            this.locations.add(new Location(MapID.FACETOVER, "Ceci est la Salle "+(1+i)));
        }
        for(Location n : this.locations){
            n.addExits(this.locations.get(2));
        }
        
        this.currentLocation = this.locations.get(0);
    }
    
    public void goTo(String name){
    }
    
    public void print(){
        this.currentLocation.print();
    }
}
