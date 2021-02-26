package GameplayPackage;

import javax.swing.Timer;

import ApplePackage.Apple;
import PanelPackage.GameFrame;
import PanelPackage.GamePanel;
import SnakePackage.Snake;

public class gamemodule {

	gamemodule() {
		// TODO Auto-generated constructor stub
	}
	
	public static void GameOver() {
		GamePanel.timer.stop();
		Snake.SnakeNull();
		Apple.Apple_Null();
		GameFrame.gamepanel.setVisible(false);
		GameFrame.gameframe.remove(GameFrame.gamepanel);
		GameFrame.gameframe.add(GameFrame.gameoverpanel);
		GameFrame.gameoverpanel.setVisible(true);
		GameFrame.intropanel.UpdatePanel();
	}
	

	public static void startgame() {
		Mode.Choose_Mode();
		GamePanel.timer = new Timer(Panel.DELAY, GameFrame.gamepanel);
		GameFrame.gameframe.addKeyListener(GameFrame.gameframe);
		Snake.Choose_Skin(1);
		Snake.Snake_init();
		Apple.SetApple();
		GamePanel.timer.start();
	}
}
