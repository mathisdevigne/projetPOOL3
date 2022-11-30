/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure;


import colossalblitzcronkadventure.character.Person;
import colossalblitzcronkadventure.character.Player;
import colossalblitzcronkadventure.command.CommandParser;
import colossalblitzcronkadventure.items.Item;

import colossalblitzcronkadventure.map.Exit;

import colossalblitzcronkadventure.map.Location;
import colossalblitzcronkadventure.map.MapID;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Arrays;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mathi
 */
public class World implements CommandParser{
    private static final World WORLD = new World();
    private final List<Location> LOCATIONS;
    private Location currentLocation;
    
    private World(){
        this.LOCATIONS = new ArrayList<>();
        
    }
    
    public static World get(){
        return World.WORLD;
    }
    
    public void initMapTest() throws FileNotFoundException{        
        File file = new File(System.getProperty("user.dir") + "/src/colossalBlitzcronkAdventure/map/map.txt");
        Scanner input = new Scanner(file);
        while(input.hasNext()){
            MapID id = MapID.valueOf(input.next());
            String desc = "";
            String s = input.next();
            while(!s.equals("@")){
                desc += s + " ";
                s = input.next();
            }
            Location l = new Location(id, desc);
            String exit = input.next();
            while(!exit.equals("@")){
                l.addExits(new Exit(l.getID(), MapID.valueOf(exit)));
                exit = input.next();
            }
            this.LOCATIONS.add(l);
        }
        input.close();
        
        this.currentLocation = this.LOCATIONS.get(0);
    }
    
    public Location getLocation(MapID id){
        for(Location l : this.LOCATIONS){
            if(l.getID() == id){
                return l;
            }
        }
        return null;
    }
    
    public void goTo(MapID name){
        if(this.currentLocation.isExit(name)){
            MapID l = this.currentLocation.getExit(name);
            if(l != null){
                this.currentLocation = this.getLocation(l);
            }
        }
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
            Location goTo = null; //currentLocation.getExit(command.get(1));
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
        if(command.size() == 2){
            Player.getPlayer().use(command.get(1));
        }
        else{
            Player.getPlayer().use(command.get(1), command.get(2));
        }
        
    }

    @Override
    public void take(List<String> command) {
        for(String s : command.subList(0, command.size())){
            Item item = this.currentLocation.take(s);
            if(item != null){
                Player.getPlayer().addInventory(item);
            }
        }
    }
}
