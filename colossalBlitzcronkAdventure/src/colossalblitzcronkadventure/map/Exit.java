/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.map;

/**
 *
 * @author Louis Richard
 */
public class Exit {
    private Location origin;
    private Location destination;

    public Location getDestination() {
        return destination;
    }
    
    public Exit(Location o, Location d){
        this.destination = d;
        this.origin = o;
    }
    
    public boolean isOrigin(Location l){
        return this.origin == l;
    }
    
    public MapID getOriginID(){
        return this.origin.getID();
    }
    
    public MapID getDestinationID(){
        return this.destination.getID();
    }
}
