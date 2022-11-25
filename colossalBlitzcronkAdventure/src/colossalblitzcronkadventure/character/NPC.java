/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author theodusehu
 */
public class NPC extends Person implements Talkable{
    
    private static final Map<Integer, String> DIALOGUES = new HashMap<>();
    static{
        try {
            Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "/src/colossalBlitzcronkAdventure/character/dialogues.txt"));
            while(sc.hasNext()){
                int Id = sc.nextInt();
                String sentence = "";
                String s = sc.next();
                while(!s.equals("@")){
                    sentence += s + " ";
                    s = sc.next();
                }
                DIALOGUES.put(Id, sentence);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NPC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public NPC(String NAME) {
        super(NAME);
    }

    @Override
    public void print() {
        System.out.println(this.getName());
    }

    @Override
    public void talkId(int id) {
        System.out.println(NPC.DIALOGUES.get(id));
    }
    
}
