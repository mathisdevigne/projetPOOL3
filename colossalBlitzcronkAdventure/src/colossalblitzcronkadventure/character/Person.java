/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

/**
 *
 * @author theodusehu
 */
public abstract class Person {
    private final String NAME;
    
    public Person(String NAME){
        this.NAME = NAME;
    }

    public abstract void print();
    
    public String getName(){
        return this.NAME;
    }
    
    

}
