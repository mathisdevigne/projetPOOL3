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
    FACETOVER("Facetover"),
    OFFICE("Office"),
    UNDERCITY("UnderCity");
    
    
    public String name;
    
    private MapID(String name){
        this.name = name;
    }
    
    public static boolean contains(String test) {
        for (MapID id : MapID.values()) {
            if (id.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}