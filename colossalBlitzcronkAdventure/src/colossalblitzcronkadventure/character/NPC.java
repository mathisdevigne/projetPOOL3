/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

/** Represent an NPC
 *
 * @author theodusehu
 */
public class NPC extends Person implements Talkable{
    
    /** Constructor of object NPC
     * @param NAME Name of NPC
     */
    public NPC(String NAME) {
        super(NAME);
    }

    /** Print the name of NPC
     */
    @Override
    public void print() {
        System.out.println(this.getName());
    }

    /** Get the dialogues int the map from the ID
     * @param id ID of the dialogue in the map
     */
    @Override
    public void talkId(int id) {
        System.out.println(NPC.DIALOGUES.get(id));
    }
    
}
