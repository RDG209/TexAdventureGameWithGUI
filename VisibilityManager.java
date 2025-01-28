package textAdventureGame;

public class VisibilityManager {
	
	UI ui;
	
	public VisibilityManager(UI userInterface) {
		
		ui = userInterface;
	}
	
	public void showTitleScreen() {
		
		// show title screen
		ui.titlePanel.setVisible(true);
		ui.startPanel.setVisible(true);
		
		//hide rest of the game
		ui.mainTextPanel.setVisible(false);
		ui.choicePanel.setVisible(false);
		ui.playerPanel.setVisible(false);
		
	}
	
	public void titleToTown() {
		ui.titlePanel.setVisible(false);
		ui.startPanel.setVisible(false);
		
		//show rest of the game
		ui.mainTextPanel.setVisible(true);
		ui.choicePanel.setVisible(true);
		ui.playerPanel.setVisible(true);
	}
	
}
