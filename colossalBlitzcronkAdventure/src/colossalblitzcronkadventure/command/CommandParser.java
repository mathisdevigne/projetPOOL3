/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package colossalblitzcronkadventure.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mathi
 */
public interface CommandParser {
    public static Scanner scan = new Scanner(System.in);
    
    public void parse();

    public void go(List<String> command);

    public void help(List<String> command);

    public void look(List<String> command);

    public void quit(List<String> command);

    public void use(List<String> command);

    public void take(List<String> command);
}
