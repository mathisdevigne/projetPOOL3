/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

/** Represent a FighterCharacter, is  inherited by Player and Ennemy
 *
 * @author theodusehu
 */
public abstract class FighterCharacter extends Person {
    private final int MAX_PV;
    private int pv;
    private final int STRENGTH;

    /** Constructor of object FighterCharacter
     * 
     * @param NAME Name
     * @param MAX_PV Maximum number of PV
     * @param STRENGTH Strength (Attack)
     */
    public FighterCharacter(String NAME, int MAX_PV, int STRENGTH) {
        super(NAME);
        this.MAX_PV = MAX_PV;
        this.pv = this.MAX_PV;
        this.STRENGTH = STRENGTH;
    }

    /** Getter of Maximum number of PV
     * 
     * @return MAX_PV
     */
    public int getMAX_PV() {
        return MAX_PV;
    }

    /** Getter of actual number of PV
     * 
     * @return pv
     */
    public int getPv() {
        return pv;
    }

    /** Getter of the Strength
     * 
     * @return STRENGTH
     */
    public int getSTRENGTH() {
        return STRENGTH;
    }
    
    /** Can reduce PV by given value
     * 
     * @param damage Val to substract to pv
     */
    public void takeDamage(int damage){
        if(this.pv > 0){
            this.pv -= damage;
        }
        
        if(this.pv < 0){
            this.pv = 0;
        }
    }
}
