package application;

import application.gui.GameSavedView;
import application.gui.SaveSlotsView;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.IOException;


public class Controller {

	private Engine engine;
	private JFrame mainFrame;

	/**
	 * Create the application.
	 */
	public Controller(Engine engine) {
		this.engine = engine;
		initializeMainFrame();
		initializePanels();
		mainFrame.setVisible(true);
	}

	private void initializeMainFrame() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 700, 500);
		mainFrame.setMinimumSize(new Dimension(470, 450)); 
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new CardLayout(80, 40));	
	}
	
	private void initializePanels() {
		mainFrame.getContentPane().add(new SaveSlotsView(this));
		mainFrame.getContentPane().add(new GameSavedView());	
	}
	
	public void startGame(int slotNum) {
		try {
			mainFrame.setVisible(false);
			engine.play(slotNum);
			mainFrame.setVisible(true);
			finishPlaying();
		} catch (IOException | InterruptedException e) {
			JOptionPane.showMessageDialog(mainFrame, "The Program didn't work properly, Please try to save manually.", "Critical Error!!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(-1);
		}

	}


	private void finishPlaying() {
		((CardLayout) mainFrame.getContentPane().getLayout()).next(mainFrame.getContentPane());
		((GameSavedView) mainFrame.getContentPane().getComponent(1)).exitAfter(10);
	}

}
