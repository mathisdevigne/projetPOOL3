/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.character;

import colossalblitzcronkadventure.command.Lookable;
import java.util.List;

/**
 *
 * @author theodusehu
 */
public abstract class Person implements Lookable{
    private final String NAME;
    
    public Person(String NAME){
        this.NAME = NAME;
    }

    public abstract void print();
    
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
