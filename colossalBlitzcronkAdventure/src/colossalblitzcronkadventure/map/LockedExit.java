/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.map;

/**
 *
 * @author Louis Richard
 */
public class LockedExit extends Exit {
    private boolean isLock = true;
    
    public LockedExit(MapID o, MapID d){
        super(o,d);
    }
    
    public void unLock(){
        this.isLock = false;
    }
    
    @Override
    public MapID getDESTINATION() {
        if(!this.isLock){
            return super.getDESTINATION();
        }
        return null;
    }
}
