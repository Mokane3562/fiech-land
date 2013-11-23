package ca.proj.game.menus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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

	private JButton establishEmbassy = new JButton();
	private JButton hostStateDinner = new JButton();
	private JButton offerForeignAid = new JButton();
	private JButton spyOnOtherCountries = new JButton();
	//private JButton holdElection = new JButton();
	private JButton mainMenu = new JButton();
	
	//Random number generator
	static Random politicsGen = new Random();
	
	//Holds random number
	private double random;
		
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);

	/**
	 * Creates a new politics action menu frame.
	 * 
	 * @param title the title of the frame
	 */
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
		BoxLayout boxLayout = new BoxLayout(cp, BoxLayout.Y_AXIS);
		cp.setLayout(boxLayout);
		
		Dimension buttonSize = new Dimension(305, 40);
		Dimension minSize = new Dimension(0, 5);
		Dimension prefSize = new Dimension(0, 5);
		Dimension maxSize = new Dimension(0, 5);

		//First Politics Action Button - Establish Embassy
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		establishEmbassy.setMinimumSize(buttonSize);
		establishEmbassy.setPreferredSize(buttonSize);
		establishEmbassy.setMaximumSize(buttonSize);
		establishEmbassy.setAlignmentX(Component.CENTER_ALIGNMENT);
		establishEmbassy.setText("Establish Embassy");
		establishEmbassy.setMargin(new Insets(2, 2, 2, 2));
		establishEmbassy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				performPoliticsAction(15, 0.50);
			}
		});
		establishEmbassy.setBackground(Color.WHITE);
		establishEmbassy.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(establishEmbassy);
				
		//Second Politics Action Button - Host State Dinner
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		hostStateDinner.setMinimumSize(buttonSize);
		hostStateDinner.setPreferredSize(buttonSize);
		hostStateDinner.setMaximumSize(buttonSize);
		hostStateDinner.setAlignmentX(Component.CENTER_ALIGNMENT);
		hostStateDinner.setText("Host State Dinner");
		hostStateDinner.setMargin(new Insets(2, 2, 2, 2));
		hostStateDinner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				performPoliticsAction(5, 0.75);
			}
		});
		hostStateDinner.setBackground(Color.WHITE);
		hostStateDinner.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(hostStateDinner);
				
		//Third Politics Action Button - Offer Foreign Aid
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		offerForeignAid.setMinimumSize(buttonSize);
		offerForeignAid.setPreferredSize(buttonSize);
		offerForeignAid.setMaximumSize(buttonSize);
		offerForeignAid.setAlignmentX(Component.CENTER_ALIGNMENT);
		offerForeignAid.setText("Offer Foreign Aid");
		offerForeignAid.setMargin(new Insets(2, 2, 2, 2));
		offerForeignAid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				performPoliticsAction(10, 0.60);
			}
		});
		offerForeignAid.setBackground(Color.WHITE);
		offerForeignAid.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(offerForeignAid);
				
		//Fourth Politics Action Button - Spy on Other Countries
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		spyOnOtherCountries.setMinimumSize(buttonSize);
		spyOnOtherCountries.setPreferredSize(buttonSize);
		spyOnOtherCountries.setMaximumSize(buttonSize);
		spyOnOtherCountries.setAlignmentX(Component.CENTER_ALIGNMENT);
		spyOnOtherCountries.setText("Spy on Other Countries");
		spyOnOtherCountries.setMargin(new Insets(2, 2, 2, 2));
		spyOnOtherCountries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				performPoliticsAction(25, 0.25);
			}
		});
		spyOnOtherCountries.setBackground(Color.WHITE);
		spyOnOtherCountries.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(spyOnOtherCountries);
		
		
		
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
		
		for (Component j : cp.getComponents() ){
			if (j instanceof JButton){
				j.setFont(new Font("Sans", Font.BOLD, 14));
			}
			
		}
		cp.setBackground(new Color(0x3399FF));
		setVisible(true);
	}
	
	// Perform Fifth Politics Action
		/*public void hostElection_ActionPerformed(ActionEvent evt) { 
			//	Generate the random number needed out of 100
			random = politicsGen.nextInt(100);
			//This action has a 25% of success
			if (Game.player.getLevelSupport()>50){
				/*	If successful, happiness variable will be set to 25 * Diplomacy Focus value,
				 *	a message to the Game.player will tell them how many happiness points they've
				 *	gained and decrement the Game.players action points by 1.
				 */
		/*		
				System.out.println(">> You have gained " + happiness + " happiness points.");
				Game.player.setActionPoints(Game.player.getActionPoints()-1);
			}
			else
				/*If unsuccessful, still decrement action points, tell the Game.player that
				 * they've gained no points, and decrement action points by 1.
				 */
		/*		System.out.println("Action failed. No happiness gained");
				Game.player.setActionPoints(Game.player.getActionPoints()-1);
		}
		*/
	
	// Perform Main Menu Action
	public void mainMenu_ActionPerformed(ActionEvent evt) { 
		//Close Politics Menu
		closeMenu();
	}
	
	/**
	 * Performs a political action with a specific chance of success. Happiness gained is equal to the specified score multiplier multiplied by the Game.players politics attribute. Costs one action point.
	 * 
	 * @param mult the multiplier that decides how many happiness points the Game.player gets
	 * @param percentChance	the chance the action succeeds
	 */
	public void performPoliticsAction(int mult, double percentChance){
		//Generate the random percentage needed out of 100
		random = politicsGen.nextDouble();
		if (Game.player.getActionPoints() > 0) {
			//	This action has a chance of success
			if (random <= percentChance) {
				/*	If successful, happiness variable will be set to mult * Politics Focus value,
				 *	a message to the Game.player will tell them how many happiness points they've
				 *	gained and decrement the Game.players action points by 1.
				 */
				Game.player.setHappiness(Game.player.getHappiness() + Game.player.getPolitics() * mult);
				System.out.println(">> You have " + Game.player.getHappiness() + " happiness points.");
			} else {
				/*	If unsuccessful, still decrement action points, tell the Game.player that
				 *	they've gained no points, and decrement action points by 1.
				 */
				System.out.println("Action failed. No happiness gained");
			}
		}
		else System.out.println("You don't have enough action points");
		Game.player.setActionPoints(Game.player.getActionPoints()-1);
	}
	
	/**
	 * Closes the menu
	 */
	public void closeMenu() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}
	
	public static void main(String[] args){
		new PoliticsActionMenu("YEAH BUDDY");
	}
}
