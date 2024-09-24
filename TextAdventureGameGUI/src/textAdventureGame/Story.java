package textAdventureGame;

import java.util.Random;

import Monsters.*;
import Weapons.*;

public class Story {
	
	GameDriver game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
	Random rand = new Random();
	
	SuperMonster monster;
	SuperWeapon weapon;
	
	public Story(GameDriver g, UI userInterface, VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm = vManager;
		
	}
	
	public void defaultSetup() {
		
		player.playerHP = 10;
		ui.hpLabelNum.setText("" +player.playerHP);
		
		player.currentWeapon = new Weapon_Knife();
		ui.weaponName.setText(player.currentWeapon.name);
		
		
	}
	public void selectPosition(String nextPos) {
		switch(nextPos) {
		case "townGate": townGate(); break;
		case "seeMarket": seeMarket(); break;
		case "buyBook": buyBook(); break;
		case "buySword": buySword(); break;
		case "settingOff": settingOff(); break;
		case "prayge": prayge(); break;
		case "blessing": blessing(); break;
		case "tallHill": tallHill(); break;
		case "north": north(); break;
		case "encounterForest": encounterForest(); break;
		case "fight": fight(); break;
		case "playerAttack": playerAttack(); break;
		case "monsterAttack": monsterAttack(); break;
		}
	}
	public void townGate() {
		
		ui.mainTextArea.setText("Welcome brave and wise Hero! \nAre you ready to set off on your adventure? \nOr perhaps you wish to go to the market? \nOr even recieve a blessing?");

		ui.choice1.setText("Set off on adventure!");
		ui.choice2.setText("Best to see the market");
		ui.choice3.setText("I must prayge");
		
		game.nextPos1 = "settingOff";
		game.nextPos2 = "seeMarket";
		game.nextPos3 = "prayge";
		
	}
	
	public void seeMarket() {

		ui.mainTextArea.setText("You walk to the bustling market seeing stalls line the square.\nA stout man call out, \n'Hey there fella! You wanting this 30lb sword?'");


		ui.choice1.setText("Sure I'll trade you my current weapon for it!");
		ui.choice2.setText("Hm, what about there magic book?");
		ui.choice3.setText("Nah I gotta go adventuring...");
		
		game.nextPos1 = "buySword";
		game.nextPos2 = "buyBook";
		game.nextPos3 = "settingOff";
		

		}
	public void buySword() {
		
		weapon = new Weapon_BigSword();
		
		ui.mainTextArea.setText("The stout man nods, taking your weapon and handing you\nthe 30lbs greatsword.");

		player.currentWeapon = weapon;
		ui.weaponName.setText(player.currentWeapon.name);

		ui.choice1.setText("Surely this won't be too heavy");
		ui.choice2.setText("Atleast I feel safe now?");
		ui.choice3.setText("Beautiful blade for a beautiful adventurer!");
		
		game.nextPos1 = "settingOff";
		game.nextPos2 = "settingOff";
		game.nextPos3 = "settingOff";
		
	}
	public void buyBook() {
		
		weapon = new Weapon_SpellBook();
		
		ui.mainTextArea.setText("The stout man nods, taking your weapon and handing you\nthe magic spellbook.");

		player.currentWeapon = weapon;
		ui.weaponName.setText(player.currentWeapon.name);

		ui.choice1.setText("I shall be the grandest wizard of our time!");
		ui.choice2.setText("Atleast I feel safe now?");
		ui.choice3.setText("Wait I know magic right?");
		
		game.nextPos1 = "settingOff";
		game.nextPos2 = "settingOff";
		game.nextPos3 = "settingOff";
		
	}
	public void prayge() {

		ui.mainTextArea.setText("You fall to your knees in reverence.\nHow long shall you prayge?");

		ui.choice1.setText("I must prayge all day before I embark.");
		ui.choice2.setText("Only an hour of prayer is enough.");
		ui.choice3.setText("Just doing a quick check in before going.");
		
		game.nextPos1 = "blessing";
		game.nextPos2 = "blessing";
		game.nextPos3 = "blessing";

	}
	public void blessing() {
		int hpBump = rand.nextInt(20)+1;
		
		ui.mainTextArea.setText("You have been blessed!\nYou have recieved +" + hpBump +" HP!");

		player.playerHP += hpBump;
		ui.hpLabelNum.setText("" + player.playerHP);

		ui.choice1.setText("Onwards then");
		ui.choice2.setText("My prayers have been answered");
		ui.choice3.setText("Lets now pop into the market");
		
		game.nextPos1 = "settingOff";
		game.nextPos2 = "settingOff";
		game.nextPos3 = "seeMarket";
	}

	
	public void settingOff() { // converging branch for post start

		
		ui.mainTextArea.setText("With weapon in hand you now set off from the town.\nYou travel in search of the mystical jewel of Steve.\nIt is time to depart!");

		ui.choice1.setText("Huzzah Adventure!");
		ui.choice2.setText("Onto finding that jewel!");
		ui.choice3.setText("Yippee I feel so good!");
		
		game.nextPos1 = "tallHill";
		game.nextPos2 = "tallHill";
		game.nextPos3 = "tallHill";

	}
	public void tallHill() { // convergence point/retreat point for early explore

		
		ui.mainTextArea.setText("You arrive to a tall hill overlooking the region.\nWhich way calls out to you?\nWhich way shall reveal fame and fortune?");

		ui.choice1.setText("Away from the city is fine, North");
		ui.choice2.setText("Hm, I'm betting East is the right way!");
		ui.choice3.setText("West the best!");
		
		game.nextPos1 = "north";
		game.nextPos2 = "east";
		game.nextPos3 = "west";

	}
	public void north() { 

		
		ui.mainTextArea.setText("You walk further North!\nBut to your dismay it's entirely covered in forests \nand impossible to get a sense of direction.");

		ui.choice1.setText("They call me El Survivor. ONWARDS!");
		ui.choice2.setText("Darn I swear I've seen that tree...");
		ui.choice3.setText("Change of plans, *runs in random direction*");
		
		game.nextPos1 = "encounterForest";
		game.nextPos2 = "tallHill";
		game.nextPos3 = "encounterForest";

	}
	public void encounterForest () {
		monster = new Monster_Goblin();
		
		ui.mainTextArea.setText("You stop suddenly as a rock flies past your head.\nDarting out of the bushes you see a goblin \nstanding ready wiht a crude shortsword!");

		ui.choice1.setText("Time to be a hero!");
		ui.choice2.setText("Take it cautiously...");
		ui.choice3.setText("Hm, *runs away*");
		
		game.nextPos1 = "fight";
		game.nextPos2 = "fight";
		game.nextPos3 = "tallHill";
		
	}
	public void fight() {
		
		ui.mainTextArea.setText(monster.name + " HP: " + monster.hp + "\n\nYou steel your nerves and prepare for battle!\nWhat's the move?");

		ui.choice1.setText("Attack Head on!");
		ui.choice2.setText("Lets riposte its next attack...");
		ui.choice3.setText("Hm, *runs away*");
		
		game.nextPos1 = "playerAttack";
		game.nextPos2 = "playerAttack";
		game.nextPos3 = "tallHill";
	}
	public void playerAttack() {
		int playerDamage = rand.nextInt(player.currentWeapon.damage)+1;
		
		monster.hp -= playerDamage;
		
		ui.mainTextArea.setText("You have attacked the " + monster.name + " for " + playerDamage + "HP!\n\n" + monster.name + " HP: " + monster.hp);

		ui.choice1.setText(">");
		ui.choice2.setText(">");
		ui.choice3.setText(">");
		
		if (monster.hp > 0) {
			game.nextPos1 = "monsterAttack";
			game.nextPos2 = "monsterAttack";
			game.nextPos3 = "monsterAttack";
		} else {
			game.nextPos1 = "winFight";
			game.nextPos2 = "winFight";
			game.nextPos3 = "winFight";
		}
		
	}
	public void monsterAttack() {
		
		int monsterDamage = monster.attack;
		
		player.playerHP -= monsterDamage;
		ui.hpLabelNum.setText("" + player.playerHP);
		
		ui.mainTextArea.setText("The " + monster.name + " has hit you for " + monsterDamage + "HP!\n\n"  + monster.name + " HP: " + monster.hp);

		ui.choice1.setText(">");
		ui.choice2.setText(">");
		ui.choice3.setText(">");
		
		if (player.playerHP > 0) {
			game.nextPos1 = "playerAttack";
			game.nextPos2 = "playerAttack";
			game.nextPos3 = "playerAttack";
		} else {
			game.nextPos1 = "lose";
			game.nextPos2 = "lose";
			game.nextPos3 = "lose";
		}
		
	}
	
	
	
}


/** 

 */