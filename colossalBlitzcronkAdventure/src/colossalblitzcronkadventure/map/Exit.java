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
    private final MapID ORIGIN;
    private final MapID DESTINATION;

    public Exit(MapID o, MapID d){
        this.DESTINATION = d;
        this.ORIGIN = o;
    }
    
    public MapID getDESTINATION() {
        return this.DESTINATION;
    }
    
    public boolean isOrigin(MapID id){
        return this.ORIGIN == id;
    }
    
    public MapID getORIGIN(){
        return this.ORIGIN;
    }
}
