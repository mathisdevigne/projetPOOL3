/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.map;

/**
 * Class that represent a Locked Exit, inherit of Exit
 * @author Louis Richard
 */
public class LockedExit extends Exit {
    private boolean isLock = true;
    private String message;
    
    /**
     * Constructor of the LockedExit class
     * Call the constructor of the super class Exit
     * @param origin the MapID of the origin
     * @param destination the MapID of the destination
     */
    public LockedExit(MapID origin, MapID destination, String message){
        super(origin,destination);
        this.message = message;
    }
    
    /**
     * Unlock the Exit 
     * Set the value of isLock to false
     */
    public void unLock(){
        this.isLock = false;
    }
    
    /**
     * Return the value of isLock
     * @return true if the Exit is locked
     */
    public boolean isLock(){
        return this.isLock;
    }
    
    /**
     * Return the destination of the Exit
     * Verify if the Exit is lock
     * if false call the super methode 
     * @return the MapID or null if the Exit is locked
     */
    @Override
    public MapID cross() {
        if(!this.isLock){
            return super.getDESTINATION();
        }
        System.out.println(this.message);
        return null;
    }
}
