package ScorePackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;





public class Score {
	private static int score = 0;
	private static int HighScore = 0;
	private static String path = new String(Score.class.getResource("/imgs/HighScore.txt").toExternalForm().toString().substring(5));
	private static File file = new File(path);
	private static FileReader filereader;
	private static FileWriter filewriter;
	
	Score() {
		// TODO Auto-generated constructor stub
	}
	
	public static void Add_score() {
		Score.score++;
		if(Score.score>Score.HighScore) {
			Score.HighScore = Score.score;
			Score.WriteFile();
		}
	}
	
	public static int Get_Score() {
		return Score.score;
	}
	
	public static int Get_HighScore() {
		ReadFile();
		return Score.HighScore;
	}
	
	public static void ReadFile() {
		try {
			filereader = new FileReader(Score.file);
			int data = 0;
			try {
				data = filereader.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Score.HighScore = data;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void WriteFile() {
		try {
			filewriter = new FileWriter(Score.file);
			filewriter.write(Score.score);
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
