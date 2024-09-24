package Monsters;

public class Monster_Goblin extends SuperMonster {
	
	public Monster_Goblin() {
		
		name = "Goblin";
		hp = 20;
		attack = rand.nextInt(4)+1; // 1-5 damage
		
	}

}
