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

/**
 * 
 * PoliticsActionMenu.java menu for diplomatic actions.
 * Copyright (C) 2013 
 * Tyler Stacey, Mark Gauci, Ryan Martin, Mike Singleton
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
public class PoliticsActionMenu extends JFrame {

	private JButton jButton1 = new JButton();
	private JButton jButton2 = new JButton();
	private JButton jButton3 = new JButton();
	private JButton jButton4 = new JButton();
	private JButton jButton5 = new JButton();
	
	//Random number generator
	static Random politicsGen = new Random();
	
	//Holds random number
	private double random;
				
	//Value to be added to Happiness
	private double happiness;
		
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);

	public PoliticsActionMenu(String title) {

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

		//First Politics Action Button - Establish Embassy
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
		
		//Second Politics Action Button - Host State Dinner
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
		
		//Third Politics Action Button - Offer Foreign Aid
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
		
		//Fourth Politics Action Button - Spy on Other Countries
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
	
	// Perform First Politics Action
	public void jButton1_ActionPerformed(ActionEvent evt) { 
		//	Generate the random number needed out of 100
		random = politicsGen.nextInt(100);
		//	This action has a 50% chance of success
		if (random<=50.00){
			/*	If successful, happiness variable will be set to 15 * Diplomacy Focus value,
			 *	a message to the player will tell them how many happiness points they've
			 *	gained and decrement the players action points by 1.
			 */
			
			//happiness=politicsFocus*15;
			System.out.println(">> You have gained " + happiness + " happiness points.");
			//--actionPoints;
		}
		else
			/*	If unsuccessful, still decrement action points, tell the player that
			 *	they've gained no points, and decrement action points by 1.
			 */
			System.out.println("Action failed. No happiness gained");
			//--actionPoints;
	}
	
	// Perform Second Politics Action
	public void jButton2_ActionPerformed(ActionEvent evt) { 
		//	Generate the random number needed out of 100
		random = politicsGen.nextInt(100);
		//	This action has a 75% of success
		if (random <=75.00){
			/*	If successful, happiness variable will be set to 5 * Diplomacy Focus value,
			 *	a message to the player will tell them how many happiness points they've
			 *	gained and decrement the players action points by 1.
			 */
			
			//happiness=politicsFocus*5;
			System.out.println(">> You have gained " + happiness + " happiness points.");
			//--actionPoints;
		}
		else
			/*	If unsuccessful, still decrement action points, tell the player that
			 * 	they've gained no points, and decrement action points by 1.
			 */
			System.out.println("Action failed. No happiness gained");	
			//--actionPoints;
	}
	
	// Perform Third Politics Action
	public void jButton3_ActionPerformed(ActionEvent evt) { 
		//	Generate the random number needed out of 100
		random = politicsGen.nextInt(100);
		//This action has a 60% of success
		if (random <=60.00){
			/*	If successful, happiness variable will be set to 10 * Diplomacy Focus value,
			 *	a message to the player will tell them how many happiness points they've
			 *	gained and decrement the players action points by 1.
			 */
			
			//happiness=diplomacyFocus*10;
			System.out.println(">> You have gained " + happiness + " happiness points.");
			//--actionPoints;
		}
		else
			/*If unsuccessful, still decrement action points, tell the player that
			 * they've gained no points, and decrement action points by 1.
			 */
			System.out.println("Action failed. No happiness gained");
			//--actionPoints;
	}

	// Perform Fourth Politics Action
	public void jButton4_ActionPerformed(ActionEvent evt) { 
		//	Generate the random number needed out of 100
		random = politicsGen.nextInt(100);
		//This action has a 25% of success
		if (random<=25.00){
			/*	If successful, happiness variable will be set to 25 * Diplomacy Focus value,
			 *	a message to the player will tell them how many happiness points they've
			 *	gained and decrement the players action points by 1.
			 */
			
			//happiness=politicsFocus*25;
			System.out.println(">> You have gained " + happiness + " happiness points.");
			//--actionPoints;
		}
		else
			/*If unsuccessful, still decrement action points, tell the player that
			 * they've gained no points, and decrement action points by 1.
			 */
			System.out.println("Action failed. No happiness gained");
			//--actionPoints;
	}
	
	// Perform Main Menu Action
	public void jButton5_ActionPerformed(ActionEvent evt) { 
		//Go back to GovActionMenu
	}
	
	public void closeMenu() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	
}
