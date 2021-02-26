package PanelPackage;


import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import SnakePackage.Snake;

public class GameFrame extends JFrame implements KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static SettingPanel settingpanel;
	public static IntroPanel intropanel;
	public static GamePanel gamepanel;
	public static GameFrame gameframe;
	public static GameOverPanel gameoverpanel;
	public static Image gameicon;
	
	GameFrame() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static void GameFrame_init(){
		GameFrame.settingpanel = new SettingPanel();
		GameFrame.intropanel= new IntroPanel();
		GameFrame.gamepanel = new GamePanel();
		GameFrame.gameframe = new GameFrame();
		GameFrame.gameoverpanel = new GameOverPanel();
		gameicon = new ImageIcon(GameFrame.class.getResource("/imgs/Snakegameicon.png")).getImage();
		GameFrame.gameframe.setIconImage(gameicon);
		GameFrame.gameframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GameFrame.gameframe.setResizable(false);
		GameFrame.gameframe.add(GameFrame.intropanel);
		GameFrame.intropanel.setVisible(true);
		GameFrame.gameframe.pack();
		GameFrame.gameframe.setVisible(true);
		GameFrame.gameframe.setFocusable(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==37&&Snake.SnakeX.get(0)==Snake.SnakeX.get(1)) {
			//Go Left
			Snake.MoveDirect='L';
		}
		else if(e.getKeyCode()==38&&Snake.SnakeY.get(0)==Snake.SnakeY.get(1)){
			//Go Up
			Snake.MoveDirect='U';
		}
		else if(e.getKeyCode()==39&&Snake.SnakeX.get(0)==Snake.SnakeX.get(1)){
			//Go Right
			Snake.MoveDirect='R';
		}
		else if(e.getKeyCode()==40&&Snake.SnakeY.get(0)==Snake.SnakeY.get(1)){
			//Go Down
			Snake.MoveDirect='D';
		}			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
