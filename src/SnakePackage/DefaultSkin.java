package SnakePackage;

import java.awt.Color;
import java.awt.Graphics2D;

import GameplayPackage.Panel;

public class DefaultSkin extends Snake_Skin{

	public DefaultSkin() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paintSnake(Graphics2D g2D) {
		g2D.setPaint(Color.green);
		for(int i=0;i<Snake.Bodycount;i++) {
			g2D.fillRect(Snake.SnakeX.get(i)*Panel.Unit_Size+Panel.Gap, Snake.SnakeY.get(i)*Panel.Unit_Size+Panel.Gap, Panel.Unit_Size-Panel.Gap, Panel.Unit_Size-Panel.Gap);
		}
	}
}
