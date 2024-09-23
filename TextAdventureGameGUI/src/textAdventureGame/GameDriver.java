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
	String questItemName;
	Random rand = new Random();
	
	JFrame window;
	Container con;
	JPanel titlePanel, startPanel, mainTextPanel, choicePanel, playerPanel;
	JLabel titleLabel, hpLabel, hpLabelNum, weaponLabel, weaponName;
	
	JButton startButton, choice1, choice2, choice3;
	
	JTextArea mainTextArea;
	
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 44);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
	
	titleScreenHandler tsHandler = new titleScreenHandler();

	public static void main(String[] args) {
		
		new GameDriver();
		
	}
	
	public GameDriver() {
		
		int winW = 800;
		int winH = 600;
		
		// CREATE WINDOW
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
		
		//TITLE PAGE
		titlePanel = new JPanel();
		titlePanel.setBounds(100, 100, 600, 150); //Start 100, end 700
		titlePanel.setBackground(Color.black);
		
		// Title label aka words
		titleLabel = new JLabel("ADVENTURE FOR THE " + questItemName);
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(titleFont);
		
		// start button area
		startPanel = new JPanel();
		startPanel.setBounds(300, 400, 200, 100);
		startPanel.setBackground(Color.black);
		
		// start button function
		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		
		// add it to container
		titlePanel.add(titleLabel);
		startPanel.add(startButton);
		con.add(titlePanel);
		con.add(startPanel);
		
		window.setVisible(true);
		
	}
	
	public void createGameScreen() {
		
		titlePanel.setVisible(false);
		startPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.decode("#3F3F3F"));
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("Welcome brave and wise " + playerName + ". Are you ready to set off on  your adventure?  Or perhaps you wish to go to the market? Or even recieve a blessing?");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.decode("#3F3F3F"));
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choicePanel = new JPanel();
		choicePanel.setBounds(200, 350, 400, 150);
		choicePanel.setBackground(Color.red);
		choicePanel.setLayout(new GridLayout(3,1));
		con.add(choicePanel);
		
		choice1 = new JButton("Set off on adventure!");
		choice1.setBackground(Color.decode("#000033"));
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choicePanel.add(choice1);
		
		choice2 = new JButton("Best to see the market");
		choice2.setBackground(Color.decode("#000033"));
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choicePanel.add(choice2);
		
		choice3 = new JButton("I must prayge");
		choice3.setBackground(Color.decode("#000033"));
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choicePanel.add(choice3);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.decode("#2D0068"));
		playerPanel.setLayout(new GridLayout(1,4)); // seperates things on status bar
		con.add(playerPanel);
		
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		
		hpLabelNum = new JLabel();
		hpLabelNum.setFont(normalFont);
		hpLabelNum.setForeground(Color.white);
		playerPanel.add(hpLabelNum);
		
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		
		weaponName = new JLabel();
		weaponName.setFont(normalFont);
		weaponName.setForeground(Color.white);
		playerPanel.add(weaponName);
		
		playerSetUp();
		
	}
	
	// CONTROLLER FOR TITLE SCREEN
	public class titleScreenHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			createGameScreen();
		}
	}
	
	public void playerSetUp() {
		
		  
		playerHP = 15;
		playerWeapon = ("Knife");
		weaponName.setText(playerWeapon);
		hpLabelNum.setText("" + playerHP);
		
		
		
	}

}
