/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

/**
 *
 * @author theodusehu
 */
public class Player extends Character{
    private static final Player BLITZCRONK = new Player("Blitzcronk");
    private static final int DEF_INT = 0;
    private int intelligence;
    
    private Player(String NAME) {
        super(NAME);
        this.intelligence = DEF_INT;
    }

    public static Player getPlayer() {
        return BLITZCRONK;
    }
    
}
