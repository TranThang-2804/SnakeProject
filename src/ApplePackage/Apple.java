package ApplePackage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import GameplayPackage.Panel;
import WallPackage.Wall;
import SnakePackage.Snake;

public class Apple {
	public static int AppleX = -1;
	public static int AppleY = -1;
	public static Random Rand = new Random();
	public static Image apple;
	
	Apple() {
		// TODO Auto-generated constructor stub
	}
	
	public static void SetApple() {
		AppleX=Rand.nextInt(Panel.Width/Panel.Unit_Size);
		AppleY=Rand.nextInt(Panel.Height/Panel.Unit_Size);
		for(int i=0; i<Snake.Bodycount; i++) {
			if(AppleX==Snake.SnakeX.get(i)&&AppleY==Snake.SnakeY.get(i)) {
				SetApple();
			}
		}
		for(int i=0; i<Wall.WallNumber; i++) {
			if(AppleX==Wall.WallX.get(i)&&AppleY==Wall.WallY.get(i)) {
				SetApple();
			}
		}
	}
	
	public static void Apple_Null() {
		AppleX=-1;
		AppleY=-1;
	}
	
	
	public static void ApplePaint(Graphics2D g2D) {
		apple = new ImageIcon(Apple.class.getResource("/imgs/defaultapple1.png")).getImage();
		g2D.setPaint(Color.red);
		if(Apple.AppleX!=-1) {
			g2D.drawImage(apple, Apple.AppleX*Panel.Unit_Size+Panel.Gap, Apple.AppleY*Panel.Unit_Size+Panel.Gap, Panel.Unit_Size-Panel.Gap, Panel.Unit_Size-Panel.Gap, null);
			//g2D.fillOval(Apple.AppleX*Panel.Unit_Size+Panel.Gap, Apple.AppleY*Panel.Unit_Size+Panel.Gap, Panel.Unit_Size-Panel.Gap, Panel.Unit_Size-Panel.Gap);
		}
	}
}
