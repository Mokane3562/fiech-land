package ca.proj.game.menus;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import ca.proj.game.Game;

@SuppressWarnings("serial")
public class TerritoryMenu extends JFrame {
	private JButton jButton1 = new JButton();
	private JButton jButton2 = new JButton();
	private JButton jButton3 = new JButton();
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);
	private boolean running = Game.isRunning();
	public TerritoryMenu(String title) {

		super(title);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 650;
		int frameHeight = 500;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);

		jButton1.setBounds(168, 80, 305, 57);
		jButton1.setText("Start in Africa");
		jButton1.setMargin(new Insets(2, 2, 2, 2));
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		jButton1.setBackground(Color.WHITE);
		jButton1.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(jButton1);
		
		jButton2.setBounds(168, 168, 305, 57);
	    jButton2.setText("Start in Fiech Land");
	    jButton2.setMargin(new Insets(2, 2, 2, 2));
	    jButton2.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	        jButton2_ActionPerformed(evt);
	      }
	    });
	    jButton2.setBackground(Color.WHITE);
	    jButton2.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN, Color.BLACK));
	    cp.add(jButton2);
	    
	    jButton3.setBounds(168, 256, 305, 57);
	    jButton3.setText("Return to Main Menu");
	    jButton3.setMargin(new Insets(2, 2, 2, 2));
	    jButton3.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent evt) { 
	    	  new Menu("Menu");
	    	  closeMenu();
	      }
	    });
	    jButton3.setBackground(Color.WHITE);
	    jButton3.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN, Color.BLACK));
	    cp.add(jButton3);
	    
		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
	}

	public void jButton1_ActionPerformed(ActionEvent evt) { // ENTER LEVEL
		if (running == false) {
			Game g = new Game("/levels/africa.png");
			g.start();
			closeMenu();
		} else {
			JOptionPane.showMessageDialog(this,
				    "Please restart the application to start a new game!",
				    "Already Running!",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void jButton2_ActionPerformed(ActionEvent evt) { // ENTER LEVEL
		if (running == false) {
			Game g = new Game("/levels/fiech.png");
			g.start();
			closeMenu();
		} else {
			JOptionPane.showMessageDialog(this,
				    "Please restart the application to start a new game!",
				    "Already Running!",
				    JOptionPane.WARNING_MESSAGE);
		}
	}

	public void closeMenu() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	public static void main(String[] args) {
		new Menu("Menu");
	}

}

