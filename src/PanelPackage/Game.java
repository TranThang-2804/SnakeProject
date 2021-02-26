package PanelPackage;

import ScorePackage.Score;

public class Game {

	public Game() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new GameFrame();
		Score.ReadFile();
		GameFrame.GameFrame_init();
	}

}
