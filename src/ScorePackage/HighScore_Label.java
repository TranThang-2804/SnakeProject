package ScorePackage;

import java.awt.Color;

import javax.swing.JLabel;

import GameplayPackage.Panel;

public class HighScore_Label extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HighScore_Label() {
		this.setForeground(Color.red);
		this.setHorizontalAlignment(CENTER);
		this.setBounds(Panel.Width/2-Panel.Width/10, Panel.Height*3/10, 2*Panel.Width/10, Panel.Height/15);
		this.setVisible(true);
	}
	
	public void Print_Score () {
		this.setText("HIGH SCORE: "+Score.Get_HighScore());
	}
}
