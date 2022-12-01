/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

import colossalblitzcronkadventure.command.Lookable;
import java.util.List;

/** Represent a Person, is inherited by FighterCharacter and NPC
 *
 * @author theodusehu
 */
public abstract class Person implements Lookable{
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
    
    @Override
    public void look(){
        this.print();
    }
    
    @Override
    public void look(List<String> command){
        this.look();
    }    
    
}
