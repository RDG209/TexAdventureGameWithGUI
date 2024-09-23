package textAdventureGame;

import Weapons.*;

public class Story {
	
	GameDriver game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
	
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

}


/** public void townGate() {
position = "townGate";
mainTextArea.setText("Welcome brave and wise Hero! \nAre you ready to set off on  your adventure? \nOr perhaps you wish to go to the market? \nOr even recieve a blessing?");

choice1.setText("Set off on adventure!");
choice2.setText("Best to see the market");
choice3.setText("I must prayge");

}

public void seeMarket() {

position = "seeMarket";
mainTextArea.setText("You walk to the bustling market seeing stalls line the square.\nA stout man call out, \n'Hey there fella! You wanting this 30lb sword?'");


choice1.setText("Sure I'll trade you my current weapon for it!");
choice2.setText("Hm, what about there magic book?");
choice3.setText("Nah I gotta go adventuring...");

}
public void buySword() {
position = "buySword";
mainTextArea.setText("The stout man nods, taking your weapon and handing you\nthe 30lbs greatsword.");

playerWeapon = "30lbs Sword";
weaponName.setText(playerWeapon);

choice1.setText("Surely this won't be too heavy");
choice2.setText("Atleast I feel safe now?");
choice3.setText("Beautiful blade for a beautiful adventurer!");
}
public void buyBook() {
position = "buySword";
mainTextArea.setText("The stout man nods, taking your weapon and handing you\nthe magic spellbook.");

playerWeapon = "Spellbook";
weaponName.setText(playerWeapon);

choice1.setText("I shall be the grandest wizard of our time!");
choice2.setText("Atleast I feel safe now?");
choice3.setText("Wait I know magic right?");
}
public void settingOff() { // converging branch for post start

position = "settingOff";
mainTextArea.setText("With weapon in hand you now set off from the town.\nYou travel in search of the mystical jewel of Steve.\nIt is time to depart!");

choice1.setText("Huzzah Adventure!");
choice2.setText("Onto finding that jewel!");
choice3.setText("Yippee I feel so good!");

}
public void prayge() {

position = "prayge";
mainTextArea.setText("You fall to your knees in reverence.\nHow long shall you prayge?");

choice1.setText("I must prayge all day before I embark.");
choice2.setText("Only an hour of prayer is enough.");
choice3.setText("Just doing a quick check in before going.");

}
public void blessing() {
int hpBump = rand.nextInt(20)+1;
position = "blessing";
mainTextArea.setText("You have been blessed!\nYou have recieved +" + hpBump +" HP!");

playerHP += hpBump;
hpLabelNum.setText("" + playerHP);

choice1.setText("Onwards then");
choice2.setText("My prayers have been answered");
choice3.setText("Just another day");
} */