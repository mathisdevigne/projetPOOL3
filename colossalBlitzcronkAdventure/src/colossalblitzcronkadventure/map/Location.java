/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.map;

import colossalblitzcronkadventure.character.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mathi
 */
public class  Location {
    private final String NOM;
    private final String DESCRIPTION;
    private final MapID ID;
    private final Map<String, Location> EXITS;
    private List<Person> characters;

    
    
    public Location(String nom, MapID mapid, String description){
        this.NOM = nom;
        this.DESCRIPTION = description;
        this.EXITS = new HashMap<>();
        this.ID = mapid;
        this.characters = new ArrayList<>();

    }
    
    public void addExits(Location newExit){
        if(newExit != this){
            this.EXITS.put(newExit.getNOM(), newExit);
        }
    }

    public String getNOM() {
        return NOM;
    }
    
    public void print(){
        System.out.println(this.DESCRIPTION);
        
        System.out.println("Exits :");
        for(String name : this.EXITS.keySet()){
            System.out.print(" - " + name);
        }
        if(!this.characters.isEmpty())
        {
            for(Person npc : this.characters){
                System.out.print(npc);
            }
        }
    }

    public Map<String, Location> getEXITS() {
        return EXITS;
    }
    
    @Override
    public boolean equals(Object o){
        boolean verif = true;
        Location l = (Location)o;
        if(!this.NOM.equals(l.getNOM()) || this.ID != l.getID() || !this.DESCRIPTION.equalsIgnoreCase(l.getDESCRIPTION())){
            verif = false;
        }
        return verif; 
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public MapID getID() {
        return ID;
    }
}
