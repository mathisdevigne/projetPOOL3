/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package colossalblitzcronkadventure.map;

/**
 *
 * @author mathi
 */
public enum MapID {
    DUMP("Dump"),
    FACTORY("Factory"),
    SEWER("Sewer"),
    DEPTH("Depth"),
    ENTRESOL("Entresol"),
    FACETOVER("Facetover");
    
    
    public String name;
    
    private MapID(String name){
        this.name = name;
    }
}