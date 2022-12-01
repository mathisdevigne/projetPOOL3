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

    public static boolean parseQuit(List<String> command){
        return command.size() == 1;
    }
    
    public void attack();
    
    public void heal();
    
    public void leaves();

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
    public static boolean parseIsFighting(Player player){
        if(player.fightAgainst != null){
            return true;
        }
        else{
            System.out.println("Player is not fighting.");
        }
        return false;
    }
    
    public boolean scanParse();

    public void go(List<String> command);

    public void fight(List<String> command);

    public static boolean parseGo(List<String> command){
        return command.size() == 2;      
    }
    
    public static void help(List<String> command){
        if(command.size()== 1){
            System.out.println("HELP :\nGO <arg> : Move to the specified locaton.\nLOOK <arg1> <arg2>... : Look at specified arguments\nQUIT : Quit the game\nTAKE <arg> : Take the specified item and put it in the inventory.\nUSE <arg1> : Use the specified item. The item need to be in your inventory.\nUSE <arg1> <arg2> : Use the first item specified with the second. Items needs to be in your inventory.\nFIGHT <arg> : Get into a fight with the specified enemy.\nWhile in fight you can use the command :\nATTACK : To attack the enemy.\nHEAL : To heal yourself.\nLEAVES : To leave the fight.\n Good luck !\n");
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
