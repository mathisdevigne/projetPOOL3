/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

/**
 *
 * @author theodusehu
 */
public class Player extends CombatableCharacter{
    private static final int DEF_INT = 0;
    private int intelligence;

    public Player(String NAME, int MAX_PV, int STRENGTH) {
        super(NAME, MAX_PV, STRENGTH);
        this.intelligence = DEF_INT;
    }
    

    @Override
    public String print() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
