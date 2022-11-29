/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.items;

/** Reprend a Miscelleneous Item
 *
 * @author theodusehu
 */
public class Miscellaneous extends Item{

    /** Constructor of object Miscellaneous
     * 
     * @param name Name of the Item
     * @param description Description of the Item
     */
    public Miscellaneous(String name, String description) {
        super(name, description);
    }

    @Override
    public void use() {
        System.out.println("Nothing happened.");
    }

    @Override
    public void use(Item item) {
    }

   
    
}
