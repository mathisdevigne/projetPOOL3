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
import java.util.Objects;

/**
 *
 * @author mathi
 */
public class  Location {
    private final String DESCRIPTION;
    private final MapID ID;
    private final Map<MapID, Exit> EXITS;
    private List<Person> persons;

    
    
    public Location(MapID mapid, String description){
        this.DESCRIPTION = description;
        this.EXITS = new HashMap<>();
        this.ID = mapid;
        this.persons = new ArrayList<>();

    }
    
    public void addExits(Exit newExit){
        if(newExit.isOrigin(this)){
            this.EXITS.put(newExit.getDestinationID(), newExit);
        }
    }
    
    public void addPerson(Person p){
        this.persons.add(p);
    }

    public MapID getID() {
        return ID;
    }

    public String getNom() {
        return ID.name;
    }
    
    public void print(){
        System.out.println(this.ID + "\n" +this.DESCRIPTION);
        
        System.out.println("Exits :");
        for(MapID map : this.EXITS.keySet()){
            System.out.println(" - " + map.name);
        }
        if(!this.persons.isEmpty())
        {
            for(Person npc : this.persons){
                System.out.print(npc);
            }
        }
    }

    public boolean isExit(MapID s){
        return this.EXITS.containsKey(s);
    }
    
    public Location getExit(MapID s){
        return this.EXITS.get(s).getDestination();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        return this.ID == other.ID;
    } 

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }
}
