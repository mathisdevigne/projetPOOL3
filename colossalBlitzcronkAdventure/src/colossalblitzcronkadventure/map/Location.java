/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.map;

import colossalblitzcronkadventure.character.Person;
import colossalblitzcronkadventure.command.Lookable;
import colossalblitzcronkadventure.items.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Class that represent a Location
 * @author mathi
 */
public class Location implements Lookable{
    private final String DESCRIPTION;
    private final MapID ID;
    private final Map<MapID, Exit> EXITS;
    private final List<Person> PERSONS;
    private final List<Item> ITEMS;
    private boolean firstVisit;
    private boolean firstSearch;
    
    /**
     * Constructor of the Location class
     * @param mapid the id of the location
     * @param description the description of the location
     */
    public Location(MapID mapid, String description){
        this.DESCRIPTION = description;
        this.EXITS = new HashMap<>();
        this.ID = mapid;
        this.PERSONS = new ArrayList<>();
        this.ITEMS = new ArrayList<>();
        this.firstVisit = true;
        this.firstSearch = true;
    }
    
    /**
     * Add an Exit to the the list of Exit in the Location
     * @param newExit the new exit to add int the list
     */
    public void addExits(Exit newExit){
        if(newExit.isOrigin(this.ID)){
            this.EXITS.put(newExit.getDESTINATION(), newExit);
        }
    }
    
    /**
     * Add an LockedExit to the the list of Exit in the Location
     * @param newExit the new exit to add int the list
     */
    public void addExits(LockedExit newExit){
        if(newExit != null){
            if(newExit.isOrigin(this.ID)){
                this.EXITS.put(newExit.getDESTINATION(), newExit);
            }
        }
    }
    
    /**
     * Add a Person to the list of Person in the Location 
     * @param person the new person to add in the list
     */
    public void addPerson(Person person){
        if(person != null){
            this.PERSONS.add(person);
        }
    }
    
    public void suppPerson(Person person){
        /*for(Person p : this.PERSONS){
            if(person.getName().equals(p.getName())){
                 this.PERSONS.remove(person);
            } 
        }*/
        this.PERSONS.remove(person);
    }
    
    /**
     * Add a Item to the list of Item in the Location 
     * @param item the new item to add in the list
     */
    public void addItem(Item item){
        this.ITEMS.add(item);
    }

    /**
     * Return the ID of the Location
     * @return a MapID of the MapID enum
     */
    public MapID getID() {
        return ID;
    }

    /**
     * Return the name associated to the ID of the Location
     * @return a String of the MapID enum
     */
    public String getName() {
        return ID.name;
    }
    
    /**
     * Return the description of the Location
     * @return a String that is the description
     */
    public String getDESCRIPTION() {
        return DESCRIPTION;
    }
            
    /**
     * Return the Exit associated to the MapID given
     * @param id the id of the destination 
     * @return the MapID of the destination
     */
    public MapID getExitID(MapID id){
        return this.EXITS.get(id).cross();
    }
    
    public Exit getExit(MapID id){
        return this.EXITS.get(id);
    }

    /**
     * Return the list of Person of the Location
     * @return a list of Person
     */
    public List<Person> getPERSONS() {
        return PERSONS;
    }
        
    /**
     * Print the inforamtions of the Location
     */
    public void print(){
        System.out.println(this.ID);
        if(this.firstVisit){
            System.out.println(this.DESCRIPTION);
            this.firstVisit = false;
        }
        
        System.out.println("Exits :");
        for(MapID map : this.EXITS.keySet()){
            System.out.println(" - " + map.name);
        }
        if(!this.PERSONS.isEmpty())
        {
            for(Person npc : this.PERSONS){
                npc.print();
            }
        }
        
        if(!this.ITEMS.isEmpty() && !this.firstSearch){
            this.printITEMS();
        }
    }

    /**
     * Verify if the parameter given is an Exit
     * @param id the id of the destination
     * @return true if this is an exit
     */
    public boolean isExit(String id){
        if(MapID.contains(id)){
            return this.EXITS.containsKey(MapID.valueOf(id));
        }
        return false;
    }
    
    public void printITEMS(){
        System.out.println("Items :");
        for(Item i : this.ITEMS){
            System.out.println(" - " + i.getNAME());
        }
    }
    
    @Override
    public void look() {
        System.out.println(this.getDESCRIPTION());
        if(!this.ITEMS.isEmpty())
        {
            this.firstSearch = false;
            System.out.println("You find some items !");
        }
        else{
            System.out.println("There is nothing more to see");
        }
    }

    @Override
    public void look(List<String> command) {
        for(String s : command.subList(1, command.size())){
            this.PERSONS.stream().filter(p -> p.getName().toUpperCase().equals(s)).forEach(p -> p.look());
            this.ITEMS.stream().filter(p -> p.getNAME().toUpperCase().equals(s)).forEach(p -> p.look());
        }
    }
    public Item take(String s) {
        Optional<Item> item = this.ITEMS.stream()/*.filter(i -> Takeable.class.isAssignableFrom(i.getClass()))*/.filter(i -> i.getNAME().toUpperCase().equals(s)).findAny();
        if(item.isPresent()){
           this.ITEMS.remove(item.get());
        }
        return item.isPresent() ? item.get(): null;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    /**
     * Verify if an object is equal to the Location
     * @param obj the Object to test
     * @return true if this is the same object
     */
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
    
}
