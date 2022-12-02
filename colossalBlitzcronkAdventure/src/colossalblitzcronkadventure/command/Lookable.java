/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package colossalblitzcronkadventure.command;

import java.util.List;

/**
 *
 * @author mathi
 */
public interface Lookable {
    
    /**
     * Look every arguments if possible
     * @param command the list of command with arguments
     */
    public void look(List<String> command);
    /**
     * Look everything
     */
    public void look();
}
