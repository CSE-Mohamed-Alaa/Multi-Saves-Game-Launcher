package application.gui;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * 
 * @deprecated not used anymore as the program now becomes invisible while the game is running.  
 */
@Deprecated
public class GameRunningView extends JPanel {
	
	private static final long serialVersionUID = 8272757377773673030L;

	/**
	 * Create the panel.
	 */
	public GameRunningView() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel gameStartingLabel = new JLabel("<html>The Game is Running, Have Fun !!</html>");
		gameStartingLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		gameStartingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(gameStartingLabel);
		
	}

}
