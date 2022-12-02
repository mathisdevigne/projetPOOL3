/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

import colossalblitzcronkadventure.map.MapID;
import java.util.ArrayList;
import java.util.List;

/** Represent and Enemy
 *
 * @author theodusehu
 */
public class Enemy extends FighterCharacter implements Talkable{

    private final MapID LOCKEDLOCATION;
    private final List<String> TALKS;
    private String actualTalk;
    
    /** Constructor of object Ennemy
     * 
     * @param NAME Name of the Ennemy
     * @param MAX_PV Maximum number of PV
     * @param STRENGTH Strength (Attack) of the Ennemy
     * @param ID ID of the Location that is unlock when defeated 
     * @param startBattle The dialogue when the fight begin
     * @param endBattle The dialogue of the end of fight
     */
    public Enemy(String NAME, int MAX_PV, int STRENGTH, MapID ID, String startBattle, String endBattle) {
        super(NAME, MAX_PV, STRENGTH);
        this.LOCKEDLOCATION = ID;
        this.TALKS = new ArrayList<>();
        this.TALKS.add(startBattle);
        this.TALKS.add(endBattle);
        this.actualTalk = startBattle;
    }
    /** 
     * Return the MapID of the Location that is locked by it
     * @return a MapID
     */
    public MapID getLOCKEDLOCATION() {
        return this.LOCKEDLOCATION;
    }
    
    @Override
    public void print() {
        System.out.println(this.getName() + ": " + this.getPv() + "/" + this.getMAX_PV());
    }
    
    /**
     * Used to change the active dialogue of this Enemy
     */
    public void changeTalk(){
        int next = this.TALKS.indexOf(this.actualTalk)+1;
        if(next < this.TALKS.size()){
            this.actualTalk = this.TALKS.get(1);
        }
    }

    @Override
    public void talk() {
        System.out.println(this.actualTalk);
    }
}
