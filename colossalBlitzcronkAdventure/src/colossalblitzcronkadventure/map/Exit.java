/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.map;

/**
 * Class that represent en exit
 * @author Louis Richard
 */
public class Exit {
    private final MapID ORIGIN;
    private final MapID DESTINATION;

    /**
     * Constructor of the class Exit
     * @param origin the MapID of the origin
     * @param destination the MapID of the destination
     */
    public Exit(MapID origin, MapID destination){
        this.DESTINATION = destination;
        this.ORIGIN = origin;
    }
    
    /**
     * Return the destination of the Exit
     * @return the MapID of the destination
     */
    public MapID getDESTINATION() {
        return this.DESTINATION;
    }
           
    /**
     * Return the origin of the Exit
     * @return the MapID of the origin
     */
    public MapID getORIGIN(){
        return this.ORIGIN;
    }
    
    /**
     * Verify if a MapID is the origin
     * @param id a MapID to verify
     * @return true if the MapID is the one of the origin
     */
    public boolean isOrigin(MapID id){
        return this.ORIGIN == id;
    }
    
    public MapID cross(){
        return this.getDESTINATION();
    }
}
