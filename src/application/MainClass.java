package application;

import java.awt.EventQueue;

public class MainClass {

	/**
	 * Launch the application.
	 * Create new controller using the engine
	 * The controller initialize the main frame and start the program
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Engine engine = new Engine();
					new Controller(engine);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
