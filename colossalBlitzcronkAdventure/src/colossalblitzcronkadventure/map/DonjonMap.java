/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.map;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathi
 */
public class DonjonMap extends Map {
    private List<Character> characters;
    
    public DonjonMap(String nom, MapID mapid, String description){
        super(nom, mapid, description);
        this.characters = new ArrayList<>();
    }
}
