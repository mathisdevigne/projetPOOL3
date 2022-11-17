/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

/**
 *
 * @author theodusehu
 */
public abstract class CombatableCharacter extends Character {
    private final int MAX_PV;
    private int pv;
    private final int STRENGTH;

    public CombatableCharacter(String NAME, int MAX_PV, int STRENGTH) {
        super(NAME);
        this.MAX_PV = MAX_PV;
        this.pv = this.MAX_PV;
        this.STRENGTH = STRENGTH;
    }
    
}
