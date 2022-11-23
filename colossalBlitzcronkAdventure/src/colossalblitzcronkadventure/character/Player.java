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
    
    private static final Player BLITZCRONK = new Player("Blitzcrong", 20, 10);

    private Player(String NAME, int MAX_PV, int STRENGTH) {
        super(NAME, MAX_PV, STRENGTH);
        this.intelligence = DEF_INT;
    }

    public static Player getPlayer(){
        return Player.BLITZCRONK;
    }
    
    public void upIntelligence(int val){
        this.intelligence =+ val;
    }

    @Override
    public void print() {
        System.out.println(this.getName() + ": " + this.getPv() + "/" + this.getMAX_PV() + " Int : " + this.intelligence + " Str : " + this.getSTRENGTH());
    }

}
