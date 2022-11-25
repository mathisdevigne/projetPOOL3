/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

/** Represent the Player
 *
 * @author theodusehu
 */
public class Player extends FighterCharacter implements Talkable{
    private static final int DEF_INT = 0;
    private int intelligence;
    
    private static final Player BLITZCRONK = new Player("Blitzcrong", 20, 10);

    /** Constructor of object Player
     * @param NAME Name of the Player
     * @param MAX_PV Maximum number of PV
     * @param STRENGTH Strength (Attack) of the Player
    */
    private Player(String NAME, int MAX_PV, int STRENGTH) {
        super(NAME, MAX_PV, STRENGTH);
        this.intelligence = DEF_INT;
    }

    /** Getter of object Player
     * 
     * @return The Player
     */
    public static Player getPlayer(){
        return Player.BLITZCRONK;
    }
    
    /** Upper of intelligence attribute
     * 
     * @param val Val to add to intelligence attribute
     */
    public void upIntelligence(int val){
        this.intelligence =+ val;
    }

    @Override
    public void print() {
        System.out.println(this.getName() + ": " + this.getPv() + "/" + this.getMAX_PV() + " Int : " + this.intelligence + " Str : " + this.getSTRENGTH());
    }

    @Override
    public void talkId(int id) {
        System.out.println(Player.DIALOGUES.get(id));
    }
}
