package WallPackage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import GameplayPackage.Panel;


public class Wall {
	public static ArrayList<Integer> WallX = new ArrayList<>();
	public static ArrayList<Integer> WallY = new ArrayList<>();
	public static int WallNumber = 0;
	public static Image bush = new ImageIcon(Wall.class.getResource("/imgs/bush.png")).getImage();;
	
	Wall() {
		// TODO Auto-generated constructor stub
	}
	
	public static void RecTang_Old_Fashion_Wall() {
		WallNumber=(Panel.Width/Panel.Unit_Size)*(Panel.Height/Panel.Unit_Size)-4;
		for(int i=0; i<Wall.WallNumber; i++) {
			if(i<Panel.Width/Panel.Unit_Size) {
				Wall.WallX.add(i);
				Wall.WallY.add(0);
			}
			else if(Panel.Width/Panel.Unit_Size<=i&&i<Panel.Height/Panel.Unit_Size+Panel.Width/Panel.Unit_Size) {
				Wall.WallX.add(Panel.Width/Panel.Unit_Size-1);
				Wall.WallY.add(i-Panel.Width/Panel.Unit_Size);
			}
			else if(Panel.Height/Panel.Unit_Size+Panel.Width/Panel.Unit_Size<=i&&i<2*Panel.Width/Panel.Unit_Size+Panel.Height/Panel.Unit_Size) {
				Wall.WallX.add(i-Panel.Width/Panel.Unit_Size-Panel.Height/Panel.Unit_Size);
				Wall.WallY.add(Panel.Height/Panel.Unit_Size-1);
			}
			else {
				Wall.WallX.add(0);
				Wall.WallY.add(i-2*Panel.Width/Panel.Unit_Size-Panel.Height/Panel.Unit_Size);
			}
		}
	}
	
	public static void No_Wall() {
		Wall.WallX.clear();
		Wall.WallY.clear();
		Wall.WallNumber = 0;
	}
	
	public static void WallPaint(Graphics2D g2D) {
		g2D.setPaint(Color.cyan);
		for(int i=0;i<Wall.WallNumber;i++) {
			g2D.drawImage(bush, Wall.WallX.get(i)*Panel.Unit_Size, Wall.WallY.get(i)*Panel.Unit_Size, Panel.Unit_Size, Panel.Unit_Size, null);
			//g2D.fillRect(Wall.WallX.get(i)*Panel.Unit_Size, Wall.WallY.get(i)*Panel.Unit_Size, Panel.Unit_Size, Panel.Unit_Size);
		}
	}
}
