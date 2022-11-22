/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.map;

import colossalblitzcronkadventure.character.NPC;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathi
 */
public class NovelMap extends Location {
    private List<NPC> characters;
    
    public NovelMap(String nom, MapID mapid, String description){
        super(nom, mapid, description);
        this.characters = new ArrayList<>();
    }
    
    @Override
    public void print(){
        super.print();
        if(!this.characters.isEmpty())
        {
            for(NPC npc : this.characters){
                System.out.print(npc);
            }
        }
    }
}
