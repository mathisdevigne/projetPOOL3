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
import colossalblitzcronkadventure.map.Exit;
import colossalblitzcronkadventure.map.Location;
import colossalblitzcronkadventure.map.LockedExit;
import colossalblitzcronkadventure.map.MapID;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Represent the World we play in
 *
 * @author mathi
 */
public class World implements CommandParser{
    private static final World WORLD = new World();
    private final List<Location> LOCATIONS;
    private Location currentLocation;
    private boolean end;
    
    /**
     * Constructor of the World class
     */
    private World(){
        this.LOCATIONS = new ArrayList<>();
        this.init();
        this.currentLocation = this.LOCATIONS.get(0);
        this.end = false;
    }
    
    /**
     * Getter of the singleton WORLD
     * @return the singleton WORLD
     */
    public static World get(){
        return World.WORLD;
    }
    
    /**
     * Init the world, with location, items and persons.
     */
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
        
        //Parse Persons :
        while(input.hasNext() && ftype.equals("P")){
            String type = input.next();
            String name = input.next();
            if(type.equals("E")){
                int pv = input.nextInt();
                int str = input.nextInt();
                String lock = input.next();
                String[] all = input.nextLine().replace("\\n", "\n").split("@");
                if(lock.equals("NULL")){
                    persons.add(new Enemy(name, pv, str, null, all[0], all[1]));
                }
                else{
                    persons.add(new Enemy(name, pv, str, MapID.valueOf(lock), all[0], all[1]));
                }
            }
            else if(type.equals("N")){
                String[] all = input.nextLine().replace("\\n", "\n").split("@");
                persons.add(new NPC(name, all[0], all[1]));
            }
            ftype = input.next();
        }
        //Parse Item :
        while(input.hasNext() && ftype.equals("I")){
            String type = input.next();
            String itemName = input.next();
            int str = 0;
            int val = 0;
            String consType = "";
            String resName = "";
            Item resItem = null;
            if("W".equals(type)){
                str = input.nextInt();
            }
            if("C".equals(type)){
                consType = input.next();
                val = input.nextInt();
            }
            if("M".equals(type)){
                resName = input.next();
                for(Item item : items){
                    if(item.getNAME().equals(resName)){
                        resItem = item;
                    }
                }
            }
            String description = "";
            String s = input.next();
            while(!s.equals("@")){
                description += s + " ";
                s = input.next();
            }
            switch(type){
                case "W" : items.add(new Weapon(itemName, description ,str)); break;
                case "M" : items.add(new Miscellaneous(itemName, description, resItem)); break;
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
        do{
            input.nextLine();
            ftype = input.next();
        }
        while(!ftype.equals("I"));
        //ReParse Item for interaction :
        while(input.hasNext() && ftype.equals("I")){
            input.next();
            String itemName = input.next();
            input.findInLine("@");
            String s = input.next();
            while(!s.equals("@")){ //Interaction item
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
            s = input.next();
            while(!s.equals("@")){ //Interaction person
                String name = s;
                MapID id;
                s = input.next();
                if(s.equals("NULL")){
                    id = null;
                }
                else{
                    id = MapID.valueOf(s);
                }
                Optional<Person> pers = persons.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findAny();
                if(pers.isPresent()){
                    for(Item item : items){
                        if(item.getNAME().equals(itemName)){
                            item.addPInterPers(pers.get(), id);
                        }
                    }
                }
                s = input.next();
            }
            ftype = input.next();
        }
        
        //Parse Location :
        while(input.hasNext() && ftype.equals("L")){
            MapID id = MapID.valueOf(input.next());
            input.next();
            String[] line = input.nextLine().split("@");  
            line[0] = line[0].strip();
            line[1] = line[1].strip();
            line[2] = line[2].strip();
            line[3] = line[3].strip();
            
            String desc = line[1];
            Location l = new Location(id, desc);
            boolean nextlocked = false;
            String dest = "";
            int j = 0;
            for(String ex : line[0].split(" & ")){ //Exits 
                if(ex.equals("LOCKED")){
                    nextlocked = true;
                    j = 2;
                }
                else if(nextlocked){
                    j--;
                    if(j == 1){
                        dest = ex;
                    }else{
                        l.addExits(new LockedExit(id,MapID.valueOf(dest), ex));
                        nextlocked = false;
                    }
                }
                else{
                    l.addExits(new Exit(id,MapID.valueOf(ex)));
                }
            }
            for(String pers : line[2].split(" ")){ //Persons
                persons.stream().filter(p->p.getName().toUpperCase().equals(pers)).forEach(p -> l.addPerson(p));
            }
            for(String it : line[3].split(" ")){ //Items
                items.stream().filter(i->i.getNAME().toUpperCase().equals(it)).forEach(i -> l.addItem(i));
            }
 
            this.LOCATIONS.add(l);
        
            ftype = input.next();
        }
        input.close();
    }

    /**
     * Verify if the game is ending
     * @return true if yes, false if not
     */
    public boolean isEnd() {
        return this.end;
    }
    
    /**
     * End the game
     */
    public void setEnd(){
        this.end = true;
    }
    
    /**
     * Print the game
     */
    public void print(){
        System.out.println("================================================================");
        System.out.print("\t\t");
        Player.getPlayer().print();
        System.out.println("================================================================");
        System.out.println();
        this.currentLocation.print();
    }
    
    /**
     * Scan the command
     * @return this.end, true if yes, false if not
     */
    @Override
    public boolean scanParse(){
        System.out.print("> ");
        for(String command : new ArrayList<>(Arrays.asList(scan.nextLine().replaceAll("^ +| +$|( )+", "$1").toUpperCase().split(";")))){
            System.out.println("Commande : " +command +";");
            List<String> commandSplit = new ArrayList<>(Arrays.asList(command.split(" ")));
            if(" ".equals(commandSplit.get(0))){
                commandSplit.remove(0);
            }
            parse(commandSplit);
        }
        return this.end;
        
    }       
        
        
    /**
     * Parse command and call methods
     * @param commandSplit a list with the command and arguments
     */
    public void parse(List<String> commandSplit){
        switch (commandSplit.get(0)) {
                case "GO":
                    this.go(commandSplit);
                    break;
                case "FIGHT":
                    this.fight(commandSplit);
                    break;
                case "ATTACK":
                    this.attack();
                    break;
                case "HEAL":
                    this.heal();
                    break;
                case "LEAVE":
                    this.leave();
                    break;
                case "HELP":
                    CommandParser.help(commandSplit);
                    break;
                case "LOOK":
                    this.lookAt(commandSplit);
                    break;
                case "QUIT":
                    this.quit(commandSplit);
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

    /**
     * Getter of the list of Locations of the World
     * @return All the locations the world knows
     */
    public List<Location> getLOCATIONS() {
        return this.LOCATIONS;
    }
     
    /**
     * Getter of the currentLocation of the World
     * @return current location
     */
    public Location getCurrentLocation(){
        return this.currentLocation;
    }
    
    /**
     * Return a location with it's id name
     * @param id MapID in a string
     * @return the location if found, null if not
     */
    public Location getLocation(String id){
        if(this.currentLocation.isExit(id)){
            for(Location l : this.LOCATIONS){
                if(id.equals(l.getID().toString())){
                    return l;
                }
            }
        }
        return null;
    }
    
    /**
     * Move our current location to another
     * @param command list of string who make a command
     */
    @Override
    public void go(List<String> command) {
        if(CommandParser.parseGo(command)){
            if(this.currentLocation.isExit(command.get(1))){
                MapID goTo = this.currentLocation.getExitID(MapID.valueOf(command.get(1)));
                if (goTo != null){
                    this.currentLocation = this.getLocation(command.get(1));
                }
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
        if(command.size() == 2){
            if(command.get(1).equals(Player.getPlayer().getName().toUpperCase())){
                Player.getPlayer().printInventory();
            }
            else{
                this.currentLocation.look(command); 
            } 
        }
        else{
            this.currentLocation.look();
        }
    }

    /**
     * Quit the game
     * @param command list of string that make a command
     */
    @Override
    public void quit(List<String> command) {
        if(CommandParser.parseQuit(command)){
            this.setEnd();
        }
        else{
            System.out.println("Wrong number of arguments for quit");
        }
    }

    /**
     * Use object
     * @param command list of string that make a command
     */
    @Override
    public void use(List<String> command) {
        if(command.size() == 2){
            Player.getPlayer().use(command.get(1));
        }
        else{
            Player.getPlayer().use(command.get(1), command.get(2));
        }
        
    }

    /**
     * Take items and put in player's inventory
     * @param command list of string that make a command
     */
    @Override
    public void take(List<String> command) {
        for(String s : command.subList(1, command.size())){
            Item item = this.currentLocation.take(s);
            if(item != null){
                System.out.println("You have picked up " + s);
                Player.getPlayer().addInventory(item);
            }
            else{
                System.out.println("There is nothing like this here");
            }
        }
    }
    
    /**
     * Print the player's fight
     * @param p the player
     */
    public void printFight(Player p){
        System.out.println("================================================================");
        System.out.print("\t\t");
        p.print();
        System.out.println("================================================================");
        System.out.println();
        p.fightAgainst.print();
        System.out.println("While fighting, you can uses thoses commands :\n - ATTACK\n - HEAL\n - LEAVE");
    }

    /**
     * Fight someone
     * @param command list of string that make a command
     */
    @Override
    public void fight(List<String> command) {
        Player currPlayer = Player.getPlayer();
        if(CommandParser.parseFight(command, currPlayer)){
            String enemyName = command.get(1);
            Optional<Person> optp = currentLocation.getPERSONS().stream().filter((Person p) -> (p.getClass() == Enemy.class) && (p.getName().toUpperCase().equals(enemyName))).findAny();
            if(optp.isPresent()){
                currPlayer.fightAgainst = (Enemy)optp.get();
                currPlayer.fightAgainst.talk();
                printFight(currPlayer);
            }
        }
    }

    /**
     * Heal the player if possible (while in fight)
     */
    @Override
    public void heal() {
        Player p = Player.getPlayer();
        if(CommandParser.parseIsFighting(p)){
            Item i = p.getItem("HEALTHPOTION");
            if(i != null){
                i.use();
                p.remInventory(i);
            }
            else{
                System.out.println("You don't have HealthPotion");
            }
                
        }
    }

    /**
     * Leave a fight (while in fight)
     */
    @Override
    public void leave() {
        Player p = Player.getPlayer();
        if(CommandParser.parseIsFighting(p)){
            p.fightAgainst = null;
        }
    }

    /**
     * Attack the person we are fighting, (while in fight)
     */
    @Override
    public void attack() {
        Player p = Player.getPlayer();
        if(CommandParser.parseIsFighting(p)){
            p.fightAgainst.takeDamage(p.getStrength());
            if(p.fightAgainst.getPv() < 1){
                System.out.println("You defeated " + p.fightAgainst.getName());
                if(p.fightAgainst.getLOCKEDLOCATION() != null){
                    for(Location l : this.LOCATIONS){
                        if(l.isExit(p.fightAgainst.getLOCKEDLOCATION().name()) && l.getExit(p.fightAgainst.getLOCKEDLOCATION()) instanceof LockedExit){
                            ((LockedExit)l.getExit(p.fightAgainst.getLOCKEDLOCATION())).unLock();
                        }
                    }   
                } 
                p.fightAgainst.changeTalk();
                p.fightAgainst.talk();
                this.currentLocation.suppPerson(p.fightAgainst);
                if(p.fightAgainst.getName().equals("Dr.Voktor")){
                    this.end = true;
                }
                p.fightAgainst = null;
            }else{
                Player.getPlayer().takeDamage(Player.getPlayer().fightAgainst.getStrength());
                System.out.println(Player.getPlayer().fightAgainst.getName() +" attacked, -"+Player.getPlayer().fightAgainst.getStrength()+"HP");
            }
        }
    }
}
