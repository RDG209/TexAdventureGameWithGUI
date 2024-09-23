package textAdventureGame;
import java.awt.*;
import javax.swing.*;

import textAdventureGame.GameDriver.ChoiceHandler;

public class UI {
	
	JFrame window;
	JPanel titlePanel, startPanel, mainTextPanel, choicePanel, playerPanel;
	JLabel titleLabel, hpLabel, hpLabelNum, weaponLabel, weaponName;
	
	JButton startButton, choice1, choice2, choice3;
	
	JTextArea mainTextArea;
	
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 44);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 24);
	
	public void createUI(ChoiceHandler choiceHandler) {
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		
		//TITLE PAGE
		titlePanel = new JPanel();
		titlePanel.setBounds(100, 100, 600, 150); //Start 100, end 700
		titlePanel.setBackground(Color.black);
		
		// Title label aka words
		titleLabel = new JLabel("ADVENTURE TIME");
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
		startButton.setFocusPainted(false);
		startButton.addActionListener(choiceHandler);
		startButton.setActionCommand("start");
		
		// add it to container
		titlePanel.add(titleLabel);
		startPanel.add(startButton);
		window.add(titlePanel);
		window.add(startPanel);
		
		window.setVisible(true);
		
		// GAME SCREEN
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.decode("#3F3F3F"));
		window.add(mainTextPanel);
		
		mainTextArea = new JTextArea("Fake this is faek");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.decode("#3F3F3F"));
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		
		choicePanel = new JPanel();
		choicePanel.setBounds(100, 350, 600, 150);
		choicePanel.setBackground(Color.red);
		choicePanel.setLayout(new GridLayout(3,1));
		window.add(choicePanel);
		
		choice1 = new JButton("default button");
		choice1.setBackground(Color.decode("#000033"));
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choicePanel.add(choice1);
		
		choice2 = new JButton("default button");
		choice2.setBackground(Color.decode("#000033"));
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choicePanel.add(choice2);
		
		choice3 = new JButton("default button");
		choice3.setBackground(Color.decode("#000033"));
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choicePanel.add(choice3);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.decode("#2D0068"));
		playerPanel.setLayout(new GridLayout(1,4)); // seperates things on status bar
		window.add(playerPanel);
		
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
				
				
	}
	

}
