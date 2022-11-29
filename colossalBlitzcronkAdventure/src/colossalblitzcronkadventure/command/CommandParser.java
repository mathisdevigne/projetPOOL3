/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package colossalblitzcronkadventure.command;

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
    
    public boolean parse();

    public void go(List<String> command);

    public static boolean parseGo(List<String> command){
        return command.size() == 2;      
    }
    
    public static void help(List<String> command){
        if(command.size()== 1){
            System.out.println("Text aide");
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
