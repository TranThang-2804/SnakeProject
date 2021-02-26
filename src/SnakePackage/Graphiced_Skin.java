package SnakePackage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import GameplayPackage.Panel;

public class Graphiced_Skin extends Snake_Skin{
	private Image snake_headR = new ImageIcon(Graphiced_Skin.class.getResource("/imgs/SnakeheadR.png")).getImage();
	private Image snake_headL = new ImageIcon(Graphiced_Skin.class.getResource("/imgs/SnakeheadL.png")).getImage();
	private Image snake_headU = new ImageIcon(Graphiced_Skin.class.getResource("/imgs/SnakeheadU.png")).getImage();
	private Image snake_headD = new ImageIcon(Graphiced_Skin.class.getResource("/imgs/SnakeheadD.png")).getImage();
	
	public Graphiced_Skin() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paintSnake(Graphics2D g2D) {
		g2D.setPaint(Color.yellow);
		if(Snake.MoveDirect=='U') {
			g2D.drawImage(snake_headU, Snake.SnakeX.get(0)*Panel.Unit_Size, Snake.SnakeY.get(0)*Panel.Unit_Size, Panel.Unit_Size, Panel.Unit_Size, null);
		}
		else if(Snake.MoveDirect=='R') {
			g2D.drawImage(snake_headR, Snake.SnakeX.get(0)*Panel.Unit_Size, Snake.SnakeY.get(0)*Panel.Unit_Size, Panel.Unit_Size, Panel.Unit_Size, null);
		}
		else if(Snake.MoveDirect=='L') {
			g2D.drawImage(snake_headL, Snake.SnakeX.get(0)*Panel.Unit_Size, Snake.SnakeY.get(0)*Panel.Unit_Size, Panel.Unit_Size, Panel.Unit_Size, null);
		}
		else if(Snake.MoveDirect=='D') {
			g2D.drawImage(snake_headD, Snake.SnakeX.get(0)*Panel.Unit_Size, Snake.SnakeY.get(0)*Panel.Unit_Size, Panel.Unit_Size, Panel.Unit_Size, null);
		}
		for(int i=1;i<Snake.Bodycount;i++) {
			g2D.fillRect(Snake.SnakeX.get(i)*Panel.Unit_Size+Panel.Gap, Snake.SnakeY.get(i)*Panel.Unit_Size+Panel.Gap, Panel.Unit_Size-Panel.Gap, Panel.Unit_Size-Panel.Gap);
		}
	}
}

