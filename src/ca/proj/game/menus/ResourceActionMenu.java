package ca.proj.game.menus;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import ca.proj.game.Game;
import ca.proj.game.entities.Player;

/**
 * 
 * ResourceActionMenu.java 
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
public class ResourceActionMenu extends JFrame {

	private JButton lookForOil = new JButton();
	private JButton harvestRenewableResources = new JButton();
	private JButton harvestNonRenewableResources = new JButton();
	private JButton lookForGold = new JButton();
	private JButton mainMenu = new JButton();
	
	//Random number generator
	static Random resourceGen = new Random();
	
	//Holds random number
	private double random;
		
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);

	/**
	 * Creates a new resource action menu frame.
	 * 
	 * @param title the title of the frame
	 */
	public ResourceActionMenu(String title) {

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
		BoxLayout boxLayout = new BoxLayout(cp, BoxLayout.Y_AXIS);
		cp.setLayout(boxLayout);
		
		Dimension buttonSize = new Dimension(305, 40);
		Dimension minSize = new Dimension(0, 5);
		Dimension prefSize = new Dimension(0, 5);
		Dimension maxSize = new Dimension(0, 5);

		//First Resource Action Button - Look for Oil
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		lookForOil.setMinimumSize(buttonSize);
		lookForOil.setPreferredSize(buttonSize);
		lookForOil.setMaximumSize(buttonSize);
		lookForOil.setAlignmentX(Component.CENTER_ALIGNMENT);
		lookForOil.setText("Look for Oil");
		lookForOil.setMargin(new Insets(2, 2, 2, 2));
		lookForOil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				lookForOil_ActionPerformed(evt);
			}
		});
		lookForOil.setBackground(Color.WHITE);
		lookForOil.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(lookForOil);
				
		//Second Resource Action Button - Harvest Renewable Resources
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		harvestRenewableResources.setMinimumSize(buttonSize);
		harvestRenewableResources.setPreferredSize(buttonSize);
		harvestRenewableResources.setMaximumSize(buttonSize);
		harvestRenewableResources.setAlignmentX(Component.CENTER_ALIGNMENT);
		harvestRenewableResources.setText("Harvest Renewable Resources");
		harvestRenewableResources.setMargin(new Insets(2, 2, 2, 2));
		harvestRenewableResources.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				harvestRenewableResources_ActionPerformed(evt);
			}
		});
		harvestRenewableResources.setBackground(Color.WHITE);
		harvestRenewableResources.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(harvestRenewableResources);
				
		//Third Resource Action Button - Harvest Non-Renewable Resources
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		harvestNonRenewableResources.setMinimumSize(buttonSize);
		harvestNonRenewableResources.setPreferredSize(buttonSize);
		harvestNonRenewableResources.setMaximumSize(buttonSize);
		harvestNonRenewableResources.setAlignmentX(Component.CENTER_ALIGNMENT);
		harvestNonRenewableResources.setText("Harvest Non-Renewable Resources");
		harvestNonRenewableResources.setMargin(new Insets(2, 2, 2, 2));
		harvestNonRenewableResources.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				harvestNonRenewableResources_ActionPerformed(evt);
			}
		});
		harvestNonRenewableResources.setBackground(Color.WHITE);
		harvestNonRenewableResources.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(harvestNonRenewableResources);
				
		//Fourth Resource Action Button - Look for Gold
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		lookForGold.setMinimumSize(buttonSize);
		lookForGold.setPreferredSize(buttonSize);
		lookForGold.setMaximumSize(buttonSize);
		lookForGold.setAlignmentX(Component.CENTER_ALIGNMENT);
		lookForGold.setText("Look for Gold");
		lookForGold.setMargin(new Insets(2, 2, 2, 2));
		lookForGold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				lookForGold_ActionPerformed(evt);
			}
		});
		lookForGold.setBackground(Color.WHITE);
		lookForGold.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(lookForGold);
				
		//Main Menu Button
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		mainMenu.setMinimumSize(buttonSize);
		mainMenu.setPreferredSize(buttonSize);
		mainMenu.setMaximumSize(buttonSize);
		mainMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainMenu.setText("Back to the Main Menu");
		mainMenu.setMargin(new Insets(2, 2, 2, 2));
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mainMenu_ActionPerformed(evt);
			}
		});
		mainMenu.setBackground(Color.WHITE);
		mainMenu.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(mainMenu);
		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
	}

	// Perform First Resource Action
	public void lookForOil_ActionPerformed(ActionEvent evt) { 
		performResourceAction(15, 0.50);
	}
		
	// Second Resource Action
	public void harvestRenewableResources_ActionPerformed(ActionEvent evt) { 
		performResourceAction(5, 0.75);
		
	}
		
	// Third Resource Action
	public void harvestNonRenewableResources_ActionPerformed(ActionEvent evt) { 
		performResourceAction(10, 0.60);
			
	}

	// Fourth Resource Action
	public void lookForGold_ActionPerformed(ActionEvent evt) { 
		performResourceAction(25, 0.25);
			
	}
		
	// Main Menu Action
	public void mainMenu_ActionPerformed(ActionEvent evt) { 
		//Close Resource Menu
		closeMenu();
	}
	
	public void performResourceAction(int mult, double percentChance){
		//Generate the random percentage needed out of 100
		random = resourceGen.nextDouble();
		if (Player.getActionPoints() > 0) {
			//	This action has a chance of success
			if (random <= percentChance) {
				/*	If successful, happiness variable will be set to mult * Resource Focus value,
				 *	a message to the player will tell them how many happiness points they've
				 *	gained and decrement the players action points by 1.
				 */
				Player.setHappiness(Player.getHappiness() + Player.getResources() * mult);
				System.out.println(">> You have " + Player.getHappiness() + " happiness points.");
			} else {
				/*	If unsuccessful, still decrement action points, tell the player that
				 *	they've gained no points, and decrement action points by 1.
				 */
				System.out.println("Action failed. No happiness gained");
			}
		}
		else System.out.println("You don't have enough action points");
		Player.setActionPoints(Player.getActionPoints()-1);
	}

	/**
	 * Closes the menu.
	 */
	public void closeMenu() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	
}
