package com.proj.game;

import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class FiechLand extends JFrame implements WindowListener{
	private static int DEFAULT_FPS = 40;

	private FiechLandPanel flp;

	public FiechLand(long period) {
		super("FiechLand");

		Container c = getContentPane(); // default BorderLayout used
		flp = new FiechLandPanel(this, period);
		c.add(flp, "Center");

		addWindowListener(this);
		pack();
		setResizable(false);
		setVisible(true);
	} //End of FiechLand constructor
	
	// ----------------- window listener methods -------------

		public void windowActivated(WindowEvent e) {
			flp.resumeGame();
		}

		public void windowDeactivated(WindowEvent e) {
			flp.pauseGame();
		}

		public void windowDeiconified(WindowEvent e) {
			flp.resumeGame();
		}

		public void windowIconified(WindowEvent e) {
			flp.pauseGame();
		}

		public void windowClosing(WindowEvent e) {
			flp.stopGame();
		}

		public void windowClosed(WindowEvent e) {
		}

		public void windowOpened(WindowEvent e) {
		}

	public static void main(String args[]) {
		long period = (long) 1000.0 / DEFAULT_FPS;
		// System.out.println("fps: " + DEFAULT_FPS + "; period: " + period +
		// " ms");
		new FiechLand(period * 1000000L); // ms --> nanosecs
	}
}
