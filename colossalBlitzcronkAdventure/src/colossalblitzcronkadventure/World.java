/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure;

import colossalblitzcronkadventure.map.DonjonMap;
import colossalblitzcronkadventure.map.Location;
import colossalblitzcronkadventure.map.MapID;
import colossalblitzcronkadventure.map.NovelMap;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathi
 */
public class World {
    private static final World WORLD = new World();
    private List<DonjonMap> donjonMaps;
    private List<NovelMap> NovelMaps;
    private Location currentLocation;
    
    private World(){
        
    }
    
    public static World get(){
        return World.WORLD;
    }
    
    public void initMapTest(){
        this.NovelMaps = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            this.NovelMaps.add(new NovelMap("Salle"+(i+1), MapID.FACETOVER, "Ceci est la Salle "+(1+i)));
        }
        for(NovelMap n : this.NovelMaps){
            n.addExits(this.NovelMaps.get(2));
        }
        this.currentLocation = this.NovelMaps.get(0);
    }
    
    public void goTo(String name){
        if(this.currentLocation.getEXITS().containsKey(name)){
            this.currentLocation = this.currentLocation.getEXITS().get(name);
        }
    }
    
    public void print(){
        this.currentLocation.print();
    }
}
