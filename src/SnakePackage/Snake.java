package SnakePackage;

import java.util.ArrayList;

import ApplePackage.Apple;
import GameplayPackage.Panel;
import GameplayPackage.gamemodule;
import WallPackage.Wall;
import ScorePackage.Score;


public class Snake {
	public static ArrayList<Integer> SnakeX = new ArrayList<>();
	public static ArrayList<Integer> SnakeY = new ArrayList<>();
	public static ArrayList<Character> Direction = new ArrayList<>();
	public static int Bodycount = 0;
	public static char MoveDirect ='R';
	public static Snake_Skin snakeskin;
	
	Snake() {
	}
	
	public static void Snake_init() {
		Snake.SnakeX.add(6);
		Snake.SnakeX.add(5);
		Snake.SnakeX.add(4);
		Snake.SnakeY.add(4);
		Snake.SnakeY.add(4);
		Snake.SnakeY.add(4);
		Snake.Direction.add('R');
		Snake.Direction.add('R');
		Snake.Direction.add('R');
		Snake.Bodycount=3;
		Snake.MoveDirect ='R';
	}
	
	public static void SnakeNull() {
		Snake.SnakeX.clear();
		Snake.SnakeY.clear();
	}
	
	public static void Snake_move() {
		Check_Collision();
		CheckEat();
		for(int i=Bodycount-1; i>0; i--) {
			Snake.SnakeX.set(i, Snake.SnakeX.get(i-1));
			Snake.SnakeY.set(i, Snake.SnakeY.get(i-1));
		}
		Snake_Move_Direct();
		Snake_Move_Loop();
	}
	 
	
	/*public static void Snake_Move_Direct_component() {
		
		for(int i=Bodycount-2; i>1; i--) {
			if(Snake.SnakeX.get(i-1)==Snake.SnakeX.get(i+1)) {
				Snake.Direction.set(i, 'V');         // 'V' means Vertical
			}
			else if(Snake.SnakeY.get(i-1)==Snake.SnakeY.get(i+1)) {
				Snake.Direction.set(i, 'H');    
			}
			else if((Snake.SnakeX.get(i-1)!=Snake.SnakeX.get(i+1))&&Snake.SnakeY.get(i-1)!=Snake.SnakeY.get(i+1)) {
				if(Snake.SnakeX.get(i)==Snake.SnakeX.get(i-1))
			}
		}
	}*/
	
	
	public static void Snake_Move_Loop() {
		if(Snake.SnakeX.get(0)*Panel.Unit_Size==Panel.Width) {
			Snake.SnakeX.set(0, 0);
		}
		else if(Snake.SnakeX.get(0)<0) {
			Snake.SnakeX.set(0, (Panel.Width/Panel.Unit_Size)-1);
		}
		else if(Snake.SnakeY.get(0)*Panel.Unit_Size==Panel.Height) {
			Snake.SnakeY.set(0, 0);
		}
		else if(Snake.SnakeY.get(0)<0) {
			Snake.SnakeY.set(0, (Panel.Height/Panel.Unit_Size)-1);
		}
	}
	
	public static void Snake_Move_Direct() {
		if(Snake.MoveDirect=='R') {
			Snake.SnakeX.set(0, Snake.SnakeX.get(0)+1);
			Snake.Direction.set(0, 'R');
		}
		else if(Snake.MoveDirect=='U') {
			Snake.SnakeY.set(0, Snake.SnakeY.get(0)-1);
			Snake.Direction.set(0, 'U');
		}
		else if(Snake.MoveDirect=='D') {
			Snake.SnakeY.set(0, Snake.SnakeY.get(0)+1);
			Snake.Direction.set(0, 'D');
		}
		else if(Snake.MoveDirect=='L') {
			Snake.SnakeX.set(0, Snake.SnakeX.get(0)-1);
			Snake.Direction.set(0, 'L');
		}
	}
	
	public static void Grow() {
		int Snakex = 0;
		int Snakey = 0;
		
		if(Snake.SnakeX.get(Snake.Bodycount-1)==Snake.SnakeX.get(Snake.Bodycount-2)) {
			if(MoveDirect=='U') {
				Snakey=Snake.SnakeY.get(Snake.Bodycount-1)-1;
				Snakex=Snake.SnakeX.get(Snake.Bodycount-1);
			}
			else if(Snake.MoveDirect=='D') {
				Snakey=Snake.SnakeY.get(Snake.Bodycount-1)+1;
				Snakex=Snake.SnakeX.get(Snake.Bodycount-1);
			}
		}
		else if(Snake.SnakeY.get(Snake.Bodycount-1)==Snake.SnakeY.get(Snake.Bodycount-2)) {
			if(Snake.MoveDirect=='R') {
				Snakex=Snake.SnakeX.get(Snake.Bodycount-1)-1;
				Snakey=Snake.SnakeY.get(Snake.Bodycount-1); 
			}
			else if(Snake.MoveDirect=='L') {
				Snakex=Snake.SnakeX.get(Snake.Bodycount-1)+1;
				Snakey=Snake.SnakeY.get(Snake.Bodycount-1);
			}
		}
		Snake.SnakeX.add(Snakex);
		Snake.SnakeY.add(Snakey);
		Snake.Bodycount++;
		Score.Add_score();
	} 
	
	
	public static void CheckEat() {
		if(Snake.SnakeX.get(0)==Apple.AppleX&&Snake.SnakeY.get(0)==Apple.AppleY) {
			Apple.SetApple();
			Grow();
		}
	}
	
	
	public static void Check_Collision() {
		for(int i=1; i<Snake.Bodycount; i++) {
			if(Snake.SnakeX.get(0)==Snake.SnakeX.get(i)&&Snake.SnakeY.get(0)==Snake.SnakeY.get(i)) {
				gamemodule.GameOver();
			}
		}
		for(int i=0; i<Wall.WallNumber; i++) {
			if (Snake.SnakeX.get(0)==Wall.WallX.get(i)&&Snake.SnakeY.get(0)==Wall.WallY.get(i)) {
				gamemodule.GameOver();
			}
		}
	}
	
	public static void Choose_Skin(int skin) {
		switch (skin) {
			case 1: 
				snakeskin = new Graphiced_Skin();
		}
	}
}
