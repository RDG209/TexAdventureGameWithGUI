package textAdventureGame;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameDriver {
	
	Scanner keyboard = new Scanner(System.in);
	
	int playerHP;
	String playerName;
	String playerWeapon;
	int choice;
	int monsterHP;
	
	boolean questItem;
	String questItemName, position;
	Random rand = new Random();
	
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 44);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 24);
	
	ChoiceHandler choiceHandler = new ChoiceHandler();
	UI ui = new UI();
	
	VisibilityManager vm = new VisibilityManager(ui);
	Story story = new Story(this, ui, vm);
	
	String nextPos1, nextPos2, nextPos3;
	

	public static void main(String[] args) {
		
		new GameDriver();
		
	}
	
	public GameDriver() {
		
		ui.createUI(choiceHandler);
		story.defaultSetup();
		vm.showTitleScreen();
		
		
	}
	
	// CONTROLLER FOR GAME
	public class ChoiceHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			
			switch (yourChoice) { 
			case "start": vm.titleToTown(); story.townGate(); break;
			case "c1": story.selectPosition(nextPos1); break;
			case "c2": story.selectPosition(nextPos2); break;
			case "c3": story.selectPosition(nextPos3); break;
			}
			
		}
	}
}
		
	

