/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colossalblitzcronkadventure.items;

import colossalblitzcronkadventure.character.Player;

/**
 *
 * @author theodusehu
 */
public class Weapon extends Item{
    
    private boolean isEquiped = false;
    private final int STRENGTH;
    
    public Weapon(String name, String description ,int strength) {
        super(name, description);
        this.STRENGTH = strength;
    }
    
    @Override
    public void use(){
        if(this.isEquiped){
            this.isEquiped = false;
            Player.getPlayer().modifStrength(-STRENGTH);
            System.out.println("You've unequiped " + this.getNAME());
        }
        else{
            this.isEquiped = true;
            Player.getPlayer().modifStrength(STRENGTH);
            System.out.println("You've equipe " + this.getNAME());
        }
    }

    @Override
    public void use(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
