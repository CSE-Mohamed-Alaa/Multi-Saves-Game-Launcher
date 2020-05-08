package application.gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import application.Controller;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.GridLayout;


public class SaveSlotsView extends JPanel {

	private static final long serialVersionUID = -8018795047723341628L;
	
	private Controller controller;

	/**
	 * Create the panel.
	 */
	public SaveSlotsView(Controller controller) {
		this.controller = controller;
		buildComponents();
	}

	private void buildComponents() {
		setLayout(new BorderLayout(40, 40));
		
		JLabel chooseLabel = new JLabel("Choose a save slot");
		chooseLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		chooseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(chooseLabel, BorderLayout.NORTH);		
		
		JPanel savesPanel = new JPanel();
		add(savesPanel, BorderLayout.CENTER);
		savesPanel.setLayout(new GridLayout(0, 1, 20, 20));
		
		
		JButton slot1Btn = new JButton("Save 1");
		slot1Btn.addActionListener(e -> controller.startGame(1));		
		slot1Btn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		slot1Btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		savesPanel.add(slot1Btn);
		
		JButton slot2Btn = new JButton("Save 2");
		slot2Btn.addActionListener(e -> controller.startGame(2));
		slot2Btn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		slot2Btn.setAlignmentX(0.5f);
		savesPanel.add(slot2Btn);
		
		JButton slot3Btn = new JButton("Save 3");
		slot3Btn.addActionListener(e -> controller.startGame(3));
		slot3Btn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		slot3Btn.setAlignmentX(0.5f);
		savesPanel.add(slot3Btn);
	}
	
}