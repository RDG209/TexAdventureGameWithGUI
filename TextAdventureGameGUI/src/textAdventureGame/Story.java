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
	
	boolean map = false;
	
	public Story(GameDriver g, UI userInterface, VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm = vManager;
		
	}
	
	public void defaultSetup() {
		
		player.playerHP = 20;
		ui.hpLabelNum.setText("" +player.playerHP);
		
		player.currentWeapon = new Weapon_Knife();
		ui.weaponName.setText(player.currentWeapon.name);
		
		
	}
	public void selectPosition(String nextPos) {
		switch(nextPos) {
		case "townGate": townGate(); break;
		case "prayge": prayge(); break;
		case "blessing": blessing(); break;
		case "seeMarket": seeMarket(); break;
		case "buyBook": buyBook(); break;
		case "buySword": buySword(); break;
		case "settingOff": settingOff(); break;
		case "tallHill": tallHill(); break;
		case "encounterForest": encounterForest(); break;
		case "encounterBandit": encounterBandit(); break;
		case "encounterSalamander": encounterSalamander(); break;
		case "fight": fight(); break;
		case "fightSalamander": fightSalamander(); break;
		case "playerAttack": playerAttack(); break;
		case "playerAttackDesert": playerAttackDesert(); break;
		case "monsterAttack": monsterAttack(); break;
		case "monsterAttackDesert": monsterAttackDesert(); break;
		case "winForest": winForest(); break;
		case "lose": lose(); break;
		case "east": east(); break;
		case "north": north(); break;
		case "west": west(); break;
		case "winDesert": winDesert(); break;
		case "pickUpRunicSword": pickUpRunicSword(); break;
		case "mapRoad": mapRoad(); break;
		case "mountainPass": mountainPass(); break;
		case "dumbLose": dumbLose(); break;
		
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
		
		ui.mainTextArea.setText("You stop suddenly as a rock flies past your head.\nDarting out of the bushes you see a goblin \nstanding ready with a crude shortsword!");

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
			game.nextPos1 = "winForest";
			game.nextPos2 = "winForest";
			game.nextPos3 = "winForest";
		}
		
	}
	public void monsterAttack() {
		
		int monsterDamage = rand.nextInt(monster.attack);
		
		player.playerHP -= monsterDamage;
		ui.hpLabelNum.setText("" + player.playerHP);
		
		ui.mainTextArea.setText("The " + monster.name + " has hit you for " + monsterDamage + "HP!\n\n"  + monster.name + " HP: " + monster.hp);
		
		if (player.playerHP > 0) {
			ui.choice1.setText("Bonk");
			ui.choice2.setText("Center Mass!");
			ui.choice3.setText("Go Low!");
			
			game.nextPos1 = "playerAttack";
			game.nextPos2 = "playerAttack";
			game.nextPos3 = "playerAttack";
		} else {
			ui.choice1.setText("The light...");
			ui.choice2.setText("The blood...");
			ui.choice3.setText("But...");
			
			game.nextPos1 = "lose";
			game.nextPos2 = "lose";
			game.nextPos3 = "lose";
		}
		
	}
	public void winForest() {
		int hpPotion = rand.nextInt(20)+1;
		
		player.playerHP += hpPotion;
		
		ui.mainTextArea.setText("You beat the " + monster.name + "!\nThe " + monster.name + " dropped a healing potion and map leading to the Jewel!\nYou heal +" + hpPotion + "HP!");

		ui.choice1.setText("Now I'm ready to follow the map!");
		ui.choice2.setText("It's time to find that jewel!");
		ui.choice3.setText("Maybe I should explore just a bit more...");
		
		map = true;
		
		game.nextPos1 = "mapRoad";
		game.nextPos2 = "mapRoad";
		game.nextPos3 = "tallHill";
	}
	public void lose() {
		ui.mainTextArea.setText("You have fallen...\nAnother adventurer lays defeated...");

		ui.choice1.setText("DEAD");
		ui.choice2.setText("DEAD");
		ui.choice3.setText("DEAD");
	}
	public void east() {
		
		ui.mainTextArea.setText("You walk further East!\nThis path opens to some calm hills, but there seems to be a figure up ahead...");

		ui.choice1.setText("I think they're friendly :)");
		ui.choice2.setText("Ah well I must go that way");
		ui.choice3.setText("I'll find another way...");
		
		game.nextPos1 = "encounterBandit";
		game.nextPos2 = "encounterBandit";
		game.nextPos3 = "tallHill";
	}
	public void encounterBandit() {
		monster = new Monster_Bandit();
		
		ui.mainTextArea.setText("The peace is cut short when a bandit appears on the road!\nBandit, 'Hey buddy, you're gonna have to hand over that weapon of yours if you wanna live...'");

		ui.choice1.setText("Hm, *runs away*");
		ui.choice2.setText("But what if maybe, no?");
		ui.choice3.setText("Have at thee brigand!");
		
		game.nextPos1 = "tallHill";
		game.nextPos2 = "fight";
		game.nextPos3 = "fight";
	}
	public void west() {
		ui.mainTextArea.setText("You walk further West!\nThis path eventually leads to some rocky desert where the sun rages above.\n");

		ui.choice1.setText("It's way too hot here...");
		ui.choice2.setText("If I walk anymore I'll die...");
		ui.choice3.setText("Just a bit more, this WILL pay off!");
		
		game.nextPos1 = "tallHill";
		game.nextPos2 = "tallHill";
		game.nextPos3 = "encounterSalamander";
	}
	public void encounterSalamander() {
		monster = new Monster_Salamander();
		
		ui.mainTextArea.setText("Suddenly a giant man-eating salamander bursts out of the ground!\nBehind it you see a shiny object.");

		ui.choice1.setText("Hm, *runs away*");
		ui.choice2.setText("I will advance!");
		ui.choice3.setText("It's over for you lizard!");
		
		game.nextPos1 = "tallHill";
		game.nextPos2 = "fight";
		game.nextPos3 = "fight";
	}
	public void fightSalamander() {
		
		ui.mainTextArea.setText(monster.name + " HP: " + monster.hp + "\n\nYou steel your nerves and prepare for battle!\nWhat's the move?");

		ui.choice1.setText("Attack Head on!");
		ui.choice2.setText("Lets riposte its next attack...");
		ui.choice3.setText("Hm, *runs away*");
		
		game.nextPos1 = "playerAttack";
		game.nextPos2 = "playerAttack";
		game.nextPos3 = "tallHill";
	}
	public void playerAttackDesert() {
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
			game.nextPos1 = "winDesert";
			game.nextPos2 = "winDesert";
			game.nextPos3 = "winDesert";
		}
		
	}
	public void monsterAttackDesert() {
		
		int monsterDamage = rand.nextInt(monster.attack);
		
		player.playerHP -= monsterDamage;
		ui.hpLabelNum.setText("" + player.playerHP);
		
		ui.mainTextArea.setText("The " + monster.name + " has hit you for " + monsterDamage + "HP!\n\n"  + monster.name + " HP: " + monster.hp);
		
		if (player.playerHP > 0) {
			ui.choice1.setText("Bonk");
			ui.choice2.setText("Center Mass!");
			ui.choice3.setText("Go Low!");
			
			game.nextPos1 = "playerAttackDesert";
			game.nextPos2 = "playerAttackDesert";
			game.nextPos3 = "playerAttackDesert";
		} else {
			ui.choice1.setText("The light...");
			ui.choice2.setText("The blood...");
			ui.choice3.setText("But...");
			
			game.nextPos1 = "lose";
			game.nextPos2 = "lose";
			game.nextPos3 = "lose";
		}
		
	}
	public void winDesert() {
		int hpPotion = rand.nextInt(40)+1;
		
		player.playerHP += hpPotion;
		
		ui.mainTextArea.setText("You beat the " + monster.name + "!\nThe " + monster.name + " dropped a healing potion and map leading to the Jewel!\nYou heal +" + hpPotion + "HP!\n\nAdditionally you notice a runic blade on the ground...");

		ui.choice1.setText("Now I'm ready to follow the map!");
		ui.choice2.setText("I'll need that blade before we keep moving!");
		ui.choice3.setText("Maybe I should explore just a bit more...");
		
		map = true;
		
		
		game.nextPos1 = "mapRoad";
		game.nextPos2 = "mapRoad";
		game.nextPos3 = "tallHill";
	}
	public void pickUpRunicSword() {
		ui.mainTextArea.setText("You pick up the runic sword,\nIt feels strong and now you feel ready to continue onwards.");

		ui.choice1.setText("Huzzah");
		ui.choice2.setText("Onwards to the Jewel!");
		ui.choice3.setText("We will Win!");
		
		weapon = new Weapon_RunicSword();
		
		player.currentWeapon = weapon;
		ui.weaponName.setText(player.currentWeapon.name);
		
		game.nextPos1 = "mapRoad";
		game.nextPos2 = "mapRoad";
		game.nextPos3 = "mapRoad";
	}
	public void mapRoad() {
		ui.mainTextArea.setText("You set off on the road as detailed in the map,\nYou come upon a large ravine and look around for guidance...");

		ui.choice1.setText("I think I can go around...");
		ui.choice2.setText("Hm, those tree vines look pretty swingable");
		ui.choice3.setText("Is that a rope bridge?");
		
		game.nextPos1 = "mountainPass";
		game.nextPos2 = "dumbLose";
		game.nextPos3 = "ropeBridge"; // NOT MADE
	}
	public void mountainPass() {
		ui.mainTextArea.setText("You manage to find a narrow mountain pass,\nbut the narrow walk way on the side of the cliff looks scary...");

		ui.choice1.setText("I'll just run fast enough to not be scared!");
		ui.choice2.setText("Nice and easy...");
		ui.choice3.setText("There should be another way right?");
		
		game.nextPos1 = "dumbLose"; 
		game.nextPos2 = "otherSideRavine"; // NOT MADE
		game.nextPos3 = "mapRoad"; 
	}
	public void dumbLose() {
		ui.mainTextArea.setText("While brave to some, your actions were simply dumb...\nYou plummet to your death...");

		ui.choice1.setText("NOOOOOO");
		ui.choice2.setText("AHHHHHHHHH");
		ui.choice3.setText("Darn");
		
		game.nextPos1 = "lose"; 
		game.nextPos2 = "lose"; 
		game.nextPos3 = "lose"; 
	}
	
	
}


/** 

 */