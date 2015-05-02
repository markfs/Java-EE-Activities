/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity2;

/**
 *
 * @author Mark Saren
 */
public class Activity2 {
    
    public static void main(String[] args) {
        /* Initialization of Heroes */
        Hero[] heroes = new Hero[5];
        heroes[0] = new Hero("Rylai", "Intelligence");
        heroes[0].addSkill("Frost Nova");
        heroes[0].addSkill("Frostbite");
        heroes[0].addSkill("Freezing Field");

        heroes[1] = new Hero("Lina", "Intelligence");
        heroes[1].addSkill("Dragon Slave");
        heroes[1].addSkill("Sun Strike Array");
        heroes[1].addSkill("Laguna Blade");

        heroes[2] = new Hero("Earthshaker", "Strength");
        heroes[2].addSkill("Fissure");
        heroes[2].addSkill("Enchant Totem");
        heroes[2].addSkill("Echo Slam");

        heroes[3] = new Hero("Huskar", "Strength");
        heroes[3].addSkill("Inner Vitality");
        heroes[3].addSkill("Burning Spears");
        heroes[3].addSkill("Jumping Madness");

        heroes[4] = new Hero("Mortred", "Agility");
        heroes[4].addSkill("Stiffling Dagger");
        heroes[4].addSkill("Blink");
        heroes[4].addSkill("Never Miss Critical Hits");
        /* End of Initialization */
        
        /* Actions Phase */
        heroes[0].choose();
        heroes[0].attack();
        heroes[0].attack("Freezing Field");
        heroes[0].attack();
        
        heroes[2].choose();
        heroes[2].block();
        heroes[2].attack("Invalid skill");
        heroes[2].attack("Echo Slam");
        
    }
}



