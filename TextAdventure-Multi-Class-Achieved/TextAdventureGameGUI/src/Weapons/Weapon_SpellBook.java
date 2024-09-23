package Weapons;


public class Weapon_SpellBook extends SuperWeapon {
	
	public Weapon_SpellBook() {
		
		name = "Spellbook";
		damage = rand.nextInt(8)+2; // 2-10 damage
	}
}

