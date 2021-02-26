package PanelPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GameplayPackage.Panel;
import ScorePackage.HighScore_Label;

public class IntroPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel Welcome = new JLabel();
	JLabel Author = new JLabel();
	JButton Play = new JButton();
	JButton Mode = new JButton();
	HighScore_Label highscorelabel = new HighScore_Label(); 

	IntroPanel() {
		Welcome.setText("Welcome to the Game");
		Welcome.setForeground(Color.red);
		Welcome.setFont(new Font("Courier", Font.BOLD, 35));
		Welcome.setBounds(Panel.Width/8, Panel.Height/8, Panel.Width*3/4, Panel.Height/8);
		Welcome.setHorizontalAlignment(SwingConstants.CENTER);
		Welcome.setVisible(true);
		
		Play.setText("Play");
		Play.setBounds(Panel.Width/5, Panel.Height*2/3, Panel.Width/5, Panel.Height*1/5);
		Play.addActionListener(this);
		
		
		Mode.setText("Mode");
		Mode.setBounds(Panel.Width/5*3, Panel.Height*2/3, Panel.Width/5, Panel.Height*1/5);
		Mode.addActionListener(this);
		
		
		Author.setText("Author: Tran Thang");
		Author.setForeground(Color.white);
		Author.setFont(new Font("Arial", Font.BOLD, 12));
		Author.setBounds(Panel.Width/8, Panel.Height/8*3, Panel.Width*3/4, Panel.Height/8);
		Author.setHorizontalAlignment(SwingConstants.CENTER);
		Author.setVisible(true);
		
		this.setPreferredSize(new Dimension(Panel.Width, Panel.Height));
		this.setBackground(Color.black);     
		this.setLayout(null);
		this.add(Author);
		this.add(Welcome);
		this.add(highscorelabel);
		this.add(Mode);
		this.add(Play);
		UpdatePanel();
		
	}
	
	public void UpdatePanel() {
		this.highscorelabel.Print_Score();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Play) {
			GameFrame.intropanel.setVisible(false);
			GameFrame.gameframe.remove(GameFrame.intropanel);
			GameFrame.gameframe.add(GameFrame.gamepanel);
			GameFrame.gamepanel.Game_init();
			GameFrame.gamepanel.setVisible(true);
			GameFrame.gamepanel.setFocusable(true);
		}
		else if(e.getSource()==Mode) {
			GameFrame.intropanel.setVisible(false);
			GameFrame.gameframe.remove(GameFrame.intropanel);
			GameFrame.gameframe.add(GameFrame.settingpanel);
			GameFrame.settingpanel.setVisible(true);
		}
	}
}
