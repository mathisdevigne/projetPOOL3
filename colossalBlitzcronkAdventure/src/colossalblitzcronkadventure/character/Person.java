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

/** Represent a Person, is inherited by FighterCharacter and NPC
 *
 * @author theodusehu
 */
public abstract class Person {
    private final String NAME;
    
    /** Constructor of object Person
     * 
     * @param NAME Name of the Person
     */
    public Person(String NAME){
        this.NAME = NAME;
    }

    /** Method to print the informations about the Person
     */
    public abstract void print();
    
    /** Getter of the Name of this Person
     * 
     * @return String NAME
     */
    public String getName(){
        return this.NAME;
    }
    
    /** Map of the different dialogues from the file dialogues.txt
     * 
     */
    static final Map<Integer, String> DIALOGUES = new HashMap<>();
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

}
