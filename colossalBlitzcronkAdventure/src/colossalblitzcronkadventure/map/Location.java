/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.map;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathi
 */
public abstract class  Location {
    private final String NOM;
    private final String DESCRIPTION;
    private final MapID ID;
    private final List<Location> EXITS;
    
    
    public Location(String nom, MapID mapid, String description){
        this.NOM = nom;
        this.DESCRIPTION = description;
        this.EXITS = new ArrayList<>();
        this.ID = mapid;
    }
    
    public void addExits(Location newExit){
        this.EXITS.add(newExit);
    }
    
}
