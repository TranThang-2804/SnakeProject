package PanelPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import GameplayPackage.Mode;
import GameplayPackage.Panel;

public class SettingPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton Mode1 = new JButton();
	JButton Mode2 = new JButton();
	JButton Apply = new JButton();
	
	
	
	SettingPanel() {
		
		Apply.setText("Apply");
		Apply.setBounds(0, Panel.Height*2/3, Panel.Width/5, Panel.Height*1/5);
		Apply.addActionListener(this);
		Apply.setVisible(true);
		
		
		Mode1.setText("No wall");
		Mode1.setBounds(Panel.Width/5, Panel.Height*2/3, Panel.Width/5, Panel.Height*1/5);
		Mode1.addActionListener(this);
		Mode1.setVisible(true);
		
		
		Mode2.setText("Box mode");
		Mode2.setBounds(Panel.Width/5*3, Panel.Height*2/3, Panel.Width/5, Panel.Height*1/5);
		Mode2.addActionListener(this);
		Mode2.setVisible(true);
		
		
		if(Mode.Get_mode()==1) {
			Mode1.setEnabled(false);
		}
		else if(Mode.Get_mode()==2) {
			Mode2.setEnabled(false);
		}
		
		this.setPreferredSize(new Dimension(Panel.Width, Panel.Height));
		this.setBackground(Color.black);    
		this.setLayout(null);
		this.add(Apply);
		this.add(Mode1);
		this.add(Mode2);

		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Apply) {
			this.setVisible(false);
			GameFrame.settingpanel.setVisible(false);
			GameFrame.gameframe.remove(GameFrame.settingpanel);
			GameFrame.gameframe.add(GameFrame.intropanel);
			GameFrame.intropanel.setVisible(true);
		}
		if(e.getSource()==Mode1) {
			Mode.Set_Mode(1);
			Mode1.setEnabled(false);
			Mode2.setEnabled(true);
		}
		else if(e.getSource()==Mode2) {
			Mode2.setEnabled(false);
			Mode1.setEnabled(true);
			Mode.Set_Mode(2);
		}
		
	}

}
