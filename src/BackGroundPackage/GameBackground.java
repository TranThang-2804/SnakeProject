package BackGroundPackage;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import GameplayPackage.Panel;

public class GameBackground {
	public static Image background;
	GameBackground() {
		// TODO Auto-generated constructor stub
	}
	
	public static void PaintBackGround(Graphics2D g2D) {
		background = new ImageIcon(GameBackground.class.getResource("/imgs/defaultbackground.jpg")).getImage();
		g2D.drawImage(background, 0, 0, Panel.Width, Panel.Height, 0, 0, background.getWidth(null)/50*Panel.Width/Panel.Unit_Size, background.getHeight(null)/50*Panel.Height/Panel.Unit_Size, null);
	}
}
