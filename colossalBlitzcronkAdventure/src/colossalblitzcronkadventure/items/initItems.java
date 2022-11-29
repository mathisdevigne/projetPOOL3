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

/**
 *
 * @author theodusehu
 */
public class initItems {
    
    private static List<Item> itemList = new ArrayList<>();
    
    public static List<Item> getList(){
        return itemList;
    }
    
    public static void creaItem() throws FileNotFoundException{
        try (Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "/src/colossalBlitzcronkAdventure/items/listOfItems.txt"))) {
            while(sc.hasNext()){
                String type = sc.next();
                String itemName = sc.next();
                int str = 0;
                if("W".equals(type)){
                    str = sc.nextInt();
                }
                String description = "";
                String s = sc.next();
                while(!s.equals("@")){
                    description += s + " ";
                    s = sc.next();
                }
                switch(type){
                    case "W" : initItems.itemList.add(new Weapon(itemName, description ,str)); break;
                    case "M" : initItems.itemList.add(new Miscellaneous(itemName, description)); break;
                    case "C" : initItems.itemList.add(new Consumable(itemName, description)); break;
                }
                sc.nextLine();
                
            }
            
            printItem();
            initInteractions();
        }
    }
    
    private static void initInteractions() throws FileNotFoundException{
        Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "/src/colossalBlitzcronkAdventure/items/listOfItems.txt"));
        
        while(sc.hasNext()){
            
            String s = sc.next();
            String itemName = sc.next();
            while(!s.equals("@")){
                s = sc.next();
            }
            s = sc.next();
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
    
    public static void printItem(){
        for(Item item : itemList){
            System.out.println(item.getNAME() + " : " + item.getDes() + " ");
        }
    }
      
}
    

/*
        Item fItem = null;
        String fusingItem;
        String fusedItem;
        String s = sc.next(); //Type
        while(sc.hasNext()){
            String itemName = sc.next(); //ItemName
            while(!s.equals("@")){
                s = sc.next();
            }
            s = sc.next(); //1er string entre les @ ou l'@ de fin
            
            while(!s.equals("@")){
                fusingItem = s;
                s = sc.next();
                fusedItem = s;
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
        */