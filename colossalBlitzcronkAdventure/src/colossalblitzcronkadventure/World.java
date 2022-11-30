/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure;


import colossalblitzcronkadventure.character.Enemy;
import colossalblitzcronkadventure.character.NPC;
import colossalblitzcronkadventure.character.Person;
import colossalblitzcronkadventure.character.Player;
import colossalblitzcronkadventure.command.CommandParser;
import colossalblitzcronkadventure.items.Consumable;
import colossalblitzcronkadventure.items.Item;
import colossalblitzcronkadventure.items.Miscellaneous;
import colossalblitzcronkadventure.items.Weapon;
import colossalblitzcronkadventure.items.initItems;

import colossalblitzcronkadventure.map.Exit;

import colossalblitzcronkadventure.map.Location;
import colossalblitzcronkadventure.map.MapID;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Arrays;


import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        this.init();
    }
    
    public static World get(){
        return World.WORLD;
    }
    
    private void init(){
        File file = new File(System.getProperty("user.dir") + "/src/colossalBlitzcronkAdventure/init.txt");
        Scanner input;
        List<Item> items = new ArrayList<>();
        List<Person> persons = new ArrayList<>();
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        String ftype = input.next();
        while(input.hasNext() && ftype.equals("I")){
            String type = input.next();
            String itemName = input.next();
            int str = 0;
            int val = 0;
            String consType = "";
            String resName = "";
            if("W".equals(type)){
                str = input.nextInt();
            }
            if("C".equals(type)){
                consType = input.next();
                val = input.nextInt();
            }
            if("M".equals(type)){
                resName = input.next();
            }
            String description = "";
            String s = input.next();
            while(!s.equals("@")){
                description += s + " ";
                s = input.next();
            }
            switch(type){
                case "W" : items.add(new Weapon(itemName, description ,str)); break;
                case "M" : items.add(new Miscellaneous(itemName, description,resName)); break;
                case "C" : items.add(new Consumable(itemName, description, consType, val)); break;
            }
            input.nextLine();
            ftype = input.next();
        }
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        ftype = input.next();
        while(input.hasNext() && ftype.equals("I")){
            input.next();
            String itemName = input.next();
            input.findInLine("@");
            String s = input.next();
            while(!s.equals("@")){
                Item fItem = null;
                String fusingItem = s;
                s = input.next();
                String fusedItem = s;
                s = input.next();
                
                for(Item item : items){
                    if(item.getNAME().equals(fusedItem)){
                        fItem = item;
                    }
                }
                for(Item item : items){
                    if(item.getNAME().equals(itemName)){
                        item.addInter(fusingItem, fItem);
                    }
                }
            }
            ftype = input.next();
        }
        while(input.hasNext() && ftype.equals("P")){
            String type = input.next();
            String name = input.next();
            if(type.equals("E")){
                int pv = input.nextInt();
                int str = input.nextInt();
                persons.add(new Enemy(name, pv, str));
                input.nextLine();
            }
            else{
                String[] all = input.nextLine().replace("\\n", "\n").split("@");
                persons.add(new NPC(name, all[0], all[1]));
            }
        }
        persons.get(0).print();
        
        
        input.close();
        for(Item item : items){
            System.out.println(item.getNAME() + " : " + item.getDes() + " ");
            item.printInter();
        }
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
