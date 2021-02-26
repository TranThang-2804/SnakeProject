package PanelPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameplayPackage.Panel;

public class GameOverPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton return_menu = new JButton();
	JLabel gameover_label = new JLabel();
	
	GameOverPanel() {
		gameover_label.setBounds(Panel.Width/6, Panel.Height*1/5, Panel.Width*2/3, Panel.Height/4);
		gameover_label.setForeground(Color.red);
		gameover_label.setFont(new Font("Courier", Font.BOLD, 70));
		gameover_label.setText("GAME OVER");
		
		return_menu.addActionListener(this);
		return_menu.setBounds(Panel.Width/3, Panel.Height*2/3, Panel.Width/3, Panel.Height/4);
		return_menu.setText("Return Menu");
		
		this.setPreferredSize(new Dimension(Panel.Width, Panel.Height));
		this.setBackground(Color.black);     
		this.setLayout(null);
		this.add(gameover_label);
		this.add(return_menu);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==return_menu) {
			GameFrame.gameoverpanel.setVisible(false);
			GameFrame.gameframe.remove(GameFrame.gameoverpanel);
			GameFrame.gameframe.add(GameFrame.intropanel);
			GameFrame.intropanel.setVisible(true);
		}
		
	}

}
