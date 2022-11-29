/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure;

import colossalblitzcronkadventure.character.Person;
import colossalblitzcronkadventure.character.Player;
import colossalblitzcronkadventure.command.CommandParser;
import colossalblitzcronkadventure.map.Location;
import colossalblitzcronkadventure.map.MapID;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mathi
 */
public class World implements CommandParser{
    private static final World WORLD = new World();
    private List<Location> locations;
    private Location currentLocation;
    
    private World(){
        this.locations = new ArrayList<>();
    }
    
    public static World get(){
        return World.WORLD;
    }
    
    public void initMapTest(){
        for(int i = 0; i < 5; i++){
            this.locations.add(new Location(MapID.FACETOVER, "Ceci est la Salle "+(1+i)));
        }
        for(Location n : this.locations){
            n.addExits(this.locations.get(2));
        }
        
        this.currentLocation = this.locations.get(0);
    }
    
    
    public void print(){
        this.currentLocation.print();
    }
    
    @Override
    public boolean parse(){
        for(String command : new ArrayList<>(Arrays.asList(scan.nextLine().replaceAll("^ +| +$|( )+", "$1").toUpperCase().split(";")))){
            System.out.println("Commande : " +command +";");
            List<String> commandSplit = new ArrayList<>(Arrays.asList(command.split(" ")));
            if(" ".equals(commandSplit.get(0))){
                commandSplit.remove(0);
            }
            
            switch (commandSplit.get(0)) {
                case "GO":
                    this.go(commandSplit);
                    break;
                case "HELP":
                    CommandParser.help(commandSplit);
                    break;
                case "LOOK":
                    this.lookAt(commandSplit);
                    break;
                case "QUIT":
                    return this.quit(commandSplit);
                case "TAKE":
                    this.take(commandSplit);

                    break;
                case "USE":
                    this.use(commandSplit);
                    break;
                default:
                    System.out.println("Command " + commandSplit.get(0) + " not in the command list, type HELP if you need.");
                    break;
            }
        }
        return false;
        
    }       
        
        
    
    @Override
    public void go(List<String> command) {
        if(CommandParser.parseGo(command)){
            Location goTo = currentLocation.getExit(command.get(1));
            if (goTo != null){
                this.currentLocation = goTo;
            }
            else{
                System.out.println("Wrong name for the exit");                  
            }
        }
        else{
            System.out.println("Wrong number of arguments for go");           
        }
    }

    

    @Override
    public void lookAt(List<String> command) {
        this.currentLocation.look();
    }

    @Override
    public boolean quit(List<String> command) {
        if(CommandParser.parseQuit(command)){
            return true;
        }
        else{
            System.out.println("Wrong number of arguments for quit");
            return false;
        }
    }

    @Override
    public void use(List<String> command) {
        Player.getPlayer().use(command.get(1));
    }

    @Override
    public void take(List<String> command) {
        Person item = this.currentLocation.take(command.get(1));
        if(item != null){
            //Player.getPlayer().addItem(item);
        }
    }
}
