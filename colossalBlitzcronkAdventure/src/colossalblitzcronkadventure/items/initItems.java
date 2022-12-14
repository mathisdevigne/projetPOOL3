/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.items;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Use to initialize all the Items
 *
 * @author theodusehu
 */
public class initItems {
    
    private static List<Item> itemList = new ArrayList<>();
    
    /** Getter of the itemList
     * 
     * @return itemList
     */
    public static List<Item> getList(){
        return itemList;
    }
    
    /** Function to create all the Item from the listOfItems.txt file
     * 
     * @throws FileNotFoundException 
     */
    public static void creaItem() throws FileNotFoundException{
        try (Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "/src/colossalBlitzcronkAdventure/items/listOfItems.txt"))) {
            while(sc.hasNext()){
                
                
            }
            
            printItem();
            initInteractions();
        }
    }
    
    /** Function to initialize all the Items Interactions
     * 
     * @throws FileNotFoundException 
     */
    private static void initInteractions() throws FileNotFoundException{
        Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "/src/colossalBlitzcronkAdventure/items/listOfItems.txt"));
        
        while(sc.hasNext()){
            
            sc.next();
            String itemName = sc.next();
            sc.findInLine("@");
            String s = sc.next();
            while(!s.equals("@")){
                Item fItem = null;
                String fusingItem = s;
                s = sc.next();
                String fusedItem = s;
                s = sc.next();
                
                for(Item items : itemList){
                    if(items.getNAME().equals(fusedItem)){
                        fItem = items;
                    }
                }

                for(Item items : itemList){
                    if(items.getNAME().equals(itemName)){
                        items.addInter(fusingItem, fItem);
                    }
                }
            }
            
        }
        
        sc.close();
    }
    
    /** Print of an Item
     * 
     */
    public static void printItem(){
        for(Item item : itemList){
            System.out.println(item.getNAME() + " : " + item.getDes() + " ");
        }
    }
      
}