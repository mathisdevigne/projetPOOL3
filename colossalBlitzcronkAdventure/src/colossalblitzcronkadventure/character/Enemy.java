/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

import colossalblitzcronkadventure.map.MapID;

/** Represent and Enemy
 *
 * @author theodusehu
 */
public class Enemy extends FighterCharacter{

    private final MapID lockedLocation;
    
    /** Constructor of object Ennemy
     * 
     * @param NAME Name of the Ennemy
     * @param MAX_PV Maximum number of PV
     * @param STRENGTH Strength (Attack) of the Ennemy
     * @param ID ID of the Location that is unlock when defeated 
     */
    public Enemy(String NAME, int MAX_PV, int STRENGTH, MapID ID) {
        super(NAME, MAX_PV, STRENGTH);
        this.lockedLocation = ID;
    }
    /** 
     * Return the MapID of the Location that is locked by it
     * @return a MapID
     */
    public MapID getLockedLocation() {
        return lockedLocation;
    }

    @Override
    public void print() {
        System.out.println(this.getName() + ": " + this.getPv() + "/" + this.getMAX_PV());
    }
    
}
