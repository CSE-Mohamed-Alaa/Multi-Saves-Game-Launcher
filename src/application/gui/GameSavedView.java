package application.gui;

import javax.swing.JPanel;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class GameSavedView extends JPanel {
	private static final long serialVersionUID = 1615630153656894111L;
	
	private JLabel gameSavedLabel;
	private int remainingSeconds;

	/**
	 * Create the panel.
	 */
	public GameSavedView() {
		setLayout(new GridLayout(1, 0, 0, 0));

		gameSavedLabel = new JLabel("<html>The Game has been saved successfully</html>");
		gameSavedLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		gameSavedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(gameSavedLabel);
	}

	public void exitAfter(int seconds) {
		remainingSeconds = seconds;
		TimerTask countDown = new TimerTask() {
			public void run() {
				gameSavedLabel.setText(
						"<html>The Game has been saved successfully, <br/>Program will exit automatically after "
								+ remainingSeconds-- + ".</html>");
			}
		};
		TimerTask exitApp = new TimerTask() {
			public void run() {
				System.exit(0);
			}
		};

		long currentTime = System.currentTimeMillis();
		new Timer().schedule(countDown, 0, 1000);
		new Timer().schedule(exitApp, new Date(currentTime + seconds * 1000));

	}

}
