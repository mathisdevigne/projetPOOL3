/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

/**
 *
 * @author theodusehu
 */
public class Enemy extends CombatableCharacter{

    public Enemy(String NAME, int MAX_PV, int STRENGTH) {
        super(NAME, MAX_PV, STRENGTH);
    }

    @Override
    public void print() {
        System.out.println(this.getName() + ": " + this.getPv() + "/" + this.getMAX_PV());
    }
    
}
