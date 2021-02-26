package GameplayPackage;

import WallPackage.Wall;

public class Mode {
	private static int MODE = 1;
	Mode() {
		Mode.MODE = 1;
	}

	public static int Get_mode(){
		return Mode.MODE;
	}
	
	public static void Set_Mode(int mode) {
		Mode.MODE = mode;
	}
	
	public static void Choose_Mode(){
		if(Mode.MODE==1) {
			Wall.No_Wall();
		}
		else if(Mode.MODE==2) {
			Wall.RecTang_Old_Fashion_Wall();
		}
	}
}
