/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

import java.util.ArrayList;
import java.util.List;

/** Represent an NPC
 *
 * @author theodusehu
 */
public class NPC extends Person implements Talkable{
    private final List<String> TALKS;
    private String actualTalk;
    
    
    /** Constructor of object NPC
     * @param NAME Name of NPC
     * @param t1
     * @param t2
     */
    public NPC(String NAME, String t1, String t2) {
        super(NAME);
        this.TALKS = new ArrayList<>();
        this.TALKS.add(t1);
        this.TALKS.add(t2);
        this.actualTalk = t1;
    }

    /** Print the name of NPC
     */
    @Override
    public void print() {
        System.out.println(this.getName());
    }
    
    /**
     * Talk when look
     */
    @Override
    public void look(){
        this.talk();
    }
    
    @Override
    public void talk(){
        System.out.println(this.actualTalk);
    }
    
    /**
     * Used to change the active dialogue of this NPC
     */
    public void changeTalk(){
        int next = this.TALKS.indexOf(this.actualTalk)+1;
        if(next < this.TALKS.size()){
            this.actualTalk = this.TALKS.get(1);
        }
    }
    
}
