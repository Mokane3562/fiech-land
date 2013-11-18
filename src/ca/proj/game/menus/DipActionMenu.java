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
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import ca.proj.game.Game;

public class DipActionMenu extends JFrame {

	private JButton jButton1 = new JButton();
	private JButton jButton2 = new JButton();
	private JButton jButton3 = new JButton();
	private JButton jButton4 = new JButton();
	private JButton jButton5 = new JButton();
	
	//Random number generator
	static Random diplomacyGen = new Random();
	
	//Holds random number
	private double r;
				
	//Value to be added to Happiness
	private double h;
		
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);

	public DipActionMenu(String title) {

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

		//First Diplomatic Action Button
		jButton1.setBounds(168, 80, 305, 57);
		jButton1.setText("Establish Embassy");
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
		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
		
		//Second Diplomatic Action Button
		jButton2.setBounds(168, 80, 305, 57);
		jButton2.setText("Host State Dinner");
		jButton2.setMargin(new Insets(2, 2, 2, 2));
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		jButton2.setBackground(Color.WHITE);
		jButton2.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(jButton2);
		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
		
		//Third Diplomatic Action Button
		jButton3.setBounds(168, 80, 305, 57);
		jButton3.setText("Offer Foreign Aid");
		jButton3.setMargin(new Insets(2, 2, 2, 2));
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		jButton3.setBackground(Color.WHITE);
		jButton3.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(jButton3);
		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
		
		//Fourth Diplomatic Action Button
		jButton4.setBounds(168, 80, 305, 57);
		jButton4.setText("Spy on Other Countries");
		jButton4.setMargin(new Insets(2, 2, 2, 2));
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		jButton4.setBackground(Color.WHITE);
		jButton4.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(jButton4);
		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
		
		//Main Menu Button
		jButton5.setBounds(168, 80, 305, 57);
		jButton5.setText("Back to the Main Menu");
		jButton5.setMargin(new Insets(2, 2, 2, 2));
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		jButton5.setBackground(Color.WHITE);
		jButton5.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(jButton5);
		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
	}
	
	// First Diplomatic Action
	public void jButton1_ActionPerformed(ActionEvent evt) { 
		r = diplomacyGen.nextInt(100);
		if (r<=50.00){
			//h=resourceFocus*15;
			System.out.println("You have gained" + h + "happiness points.");
		}
		else
			System.out.println("Action failed. No happiness gained");	
	}
	
	// Second Diplomatic Action
	public void jButton2_ActionPerformed(ActionEvent evt) { 
		r = diplomacyGen.nextInt(100);
		if (r<=75.00){
			//h=resourceFocus*5;
			System.out.println("You have gained" + h + "happiness points.");
		}
		else
			System.out.println("Action failed. No happiness gained");		
	}
	
	// Third Diplomatic Action
	public void jButton3_ActionPerformed(ActionEvent evt) { 
		r = diplomacyGen.nextInt(100);
		if (r<=60.00){
			//h=resourceFocus*10;
			System.out.println("You have gained" + h + "happiness points.");
		}
		else
			System.out.println("Action failed. No happiness gained");		
	}

	// Fourth Diplomatic Action
	public void jButton4_ActionPerformed(ActionEvent evt) { 
		r = diplomacyGen.nextInt(100);
		if (r<=25.00){
			//h=resourceFocus*25;
			System.out.println("You have gained" + h + "happiness points.");
		}
		else
			System.out.println("Action failed. No happiness gained");		
	}
	
	// Main Menu Action
	public void jButton5_ActionPerformed(ActionEvent evt) { 
		//Go back to GovActionMenu
	}
	
	public void closeMenu() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	
}
