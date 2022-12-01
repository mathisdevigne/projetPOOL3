/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package colossalblitzcronkadventure.command;

import colossalblitzcronkadventure.character.Player;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mathi
 */
public interface CommandParser {
    public static Scanner scan = new Scanner(System.in);

    /**
     * 
     * @param command
     * @return return true if the command is conform
     */
    public static boolean parseQuit(List<String> command){
        return command.size() == 1;
    }
    
    /**
     * Attack the unit fighting
     */
    public void attack();
    
    /**
     * Heal while fighting
     */
    public void heal();
    
    /**
     * Leaves a fight
     */
    public void leaves();

    
     /** 
     * @param command
     * @return return true if the command is conform
     */
    public static boolean parseFight(List<String> command, Player player){
        if(command.size() != 2){
            if(player.fightAgainst == null){
                return true;
            }
            else{
                System.out.println("Player is already fighting.");
            }
        }
        else{
            System.out.println("Wrong number of argument for FIGHT.");
        }
        return false;
    }
    
    /** 
     * @param player
     * @return return true if the player is fighting
     */        
    public static boolean parseIsFighting(Player player){
        if(player.fightAgainst != null){
            return true;
        }
        else{
            System.out.println("Player is not fighting.");
        }
        return false;
    }
    
    /**
     * Use the static scanner to parse a command
     * @return true if we quit the game, if not false
     */
    public boolean scanParse();

    /**
     * go to the location if possible
     * @param command 
     */
    public void go(List<String> command);
    
    /**
     * fight the unit specified
     * @param command 
     */
    public void fight(List<String> command);
    
    /** 
     * @param command
     * @return return true if the command is conform
     */
    public static boolean parseGo(List<String> command){
        return command.size() == 2;      
    }
    
    /**
     * Print help
     * @param command 
     */
    public static void help(List<String> command){
        if(command.size()== 1){
            System.out.println("HELP :\nGO <arg> : Move to the specified locaton.\nLOOK <arg1> <arg2>... : Look at specified arguments\nQUIT : Quit the game\nTAKE <arg> : Take the specified item and put it in the inventory.\nUSE <arg1> <arg2> : Use the first item specified with the second. The first item needs to be in your inventory.\nFIGHT <arg> : Get into a fight with the specified enemy.\nWhile in fight you can use the command :\nATTACK : To attack the enemy.\nHEAL : To heal yourself.\nLEAVES : To leave the fight.\n Good luck !\n");
        }
    }

    public void lookAt(List<String> command);

    
    public boolean quit(List<String> command);

    public void use(List<String> command);

    public void take(List<String> command);
    
    public static boolean parseTake(List<String> command){
        return command.size() == 2;      
    }
}
