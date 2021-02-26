package PanelPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import ApplePackage.Apple;
import BackGroundPackage.GameBackground;
import GameplayPackage.gamemodule;
import GameplayPackage.Panel;
import ScorePackage.Score;
import ScorePackage.Score_Label;
import SnakePackage.Snake;
import WallPackage.Wall;

public class GamePanel extends JLayeredPane implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Timer timer;
	Graphics2D g2D;
	
	Score_Label scorelabel = new Score_Label();
	
	
	GamePanel () {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(Panel.Width, Panel.Height));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.add(scorelabel, 11);
	}


	public void Game_init() {
		gamemodule.startgame();
	}
	
	
	public void paint(Graphics g) {
		g2D = (Graphics2D) g;
		GameBackground.PaintBackGround(g2D);
		super.paint(g2D);
		Wall.WallPaint(g2D);
		Apple.ApplePaint(g2D);
		Snake.snakeskin.paintSnake(g2D);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Snake.Snake_move();
		repaint();
		scorelabel.setText("Score "+Score.Get_Score());
	}
}	
