/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.command;

import static colossalblitzcronkadventure.command.CommandParser.scan;
import colossalblitzcronkadventure.item.Item;
import colossalblitzcronkadventure.map.MapID;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mathi
 */
public abstract class CommandMap implements CommandParser {
    public List<MapID> possibleLocations;
    public List<Item> items;

    public CommandMap(List<MapID> possibleLocations, List<Item> items) {
        this.possibleLocations = possibleLocations;
        this.items = items;
    }
    
    
    
    @Override
    public void parse(){
        List<String> command = new ArrayList<>(Arrays.asList(scan.next().split(" ")));
        switch (command.get(0)) {
            case "GO":
                this.go(command);
                break;
            case "HELP":
                this.help(command);
                break;
            case "LOOK":
                this.look(command);
                
                break;
            case "QUIT":
                this.quit(command);
                
                break;
            case "TAKE":
                this.take(command);
                
                break;
            case "USE":
                this.use(command);
                
                break;
            default:
                break;
        }
    }

    public MapID parseGo(List<String> command){
        if(command.size() != 2){
            System.out.println("Wrong number of arguments for go");
            return null;
        }
        else return possibleLocations.stream().filter(m -> m.name.equals(command.get(1))).findAny().orElseGet(() -> {
            System.out.println("No location named like that");
            return null;
        });
    }
        
       
        
        
    
    @Override
    public void go(List<String> command) {
        MapID goTo = parseGo(command);
        if (goTo == null) return; 
    }

    @Override
    public void help(List<String> command) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void look(List<String> command) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void quit(List<String> command) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void use(List<String> command) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void take(List<String> command) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
