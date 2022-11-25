/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

/**
 *
 * @author theodusehu
 */
public class Enemy extends FighterCharacter{

    /** Constructor of object Ennemy
     * 
     * @param NAME Name of the Ennemy
     * @param MAX_PV Maximum number of PV
     * @param STRENGTH Strength (Attack) of the Ennemy
     */
    public Enemy(String NAME, int MAX_PV, int STRENGTH) {
        super(NAME, MAX_PV, STRENGTH);
    }

    @Override
    public void print() {
        System.out.println(this.getName() + ": " + this.getPv() + "/" + this.getMAX_PV());
    }
    
}
