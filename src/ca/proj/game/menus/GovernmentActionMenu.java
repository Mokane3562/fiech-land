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
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import ca.proj.game.Game;
/**
 * 
 * GovernmentActionMenu.java 
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

public class GovernmentActionMenu extends JFrame {

	private JButton militaryAction = new JButton();
	private JButton politicalAction = new JButton();
	private JButton resourceAction = new JButton();
	private JButton wealthAction = new JButton();
	private JButton exitMenu = new JButton();
	
	private boolean running = Game.isRunning();
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);

	/**
	 * Creates a new government action menu frame.
	 * 
	 * @param title the title on the frame
	 */
	public GovernmentActionMenu(String title) {

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

		//Military Action Button - Opens Military Action Menu
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		militaryAction.setMinimumSize(buttonSize);
		militaryAction.setPreferredSize(buttonSize);
		militaryAction.setMaximumSize(buttonSize);
		militaryAction.setAlignmentX(Component.CENTER_ALIGNMENT);
		militaryAction.setText("Military Action");
		militaryAction.setMargin(new Insets(2, 2, 2, 2));
		militaryAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				militaryAction_ActionPerformed(evt);
			}
		});
		militaryAction.setBackground(Color.WHITE);
		militaryAction.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(militaryAction);
				
		//Political Action Button - Opens Diplomatic Action Menu
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		politicalAction.setMinimumSize(buttonSize);
		politicalAction.setPreferredSize(buttonSize);
		politicalAction.setMaximumSize(buttonSize);
		politicalAction.setAlignmentX(Component.CENTER_ALIGNMENT);
		politicalAction.setText("Political Action");
		politicalAction.setMargin(new Insets(2, 2, 2, 2));
		politicalAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				militaryAction_ActionPerformed(evt);
			}
		});
		politicalAction.setBackground(Color.WHITE);
		politicalAction.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(politicalAction);
		
		//Resource Action Button - Opens Resource Action Menu
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		resourceAction.setMinimumSize(buttonSize);
		resourceAction.setPreferredSize(buttonSize);
		resourceAction.setMaximumSize(buttonSize);
		resourceAction.setAlignmentX(Component.CENTER_ALIGNMENT);
		resourceAction.setText("Resource Action");
		resourceAction.setMargin(new Insets(2, 2, 2, 2));
		resourceAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				militaryAction_ActionPerformed(evt);
			}
		});
		resourceAction.setBackground(Color.WHITE);
		resourceAction.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(resourceAction);
		
		//Wealth Action Button - Opens Trade Action Button
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		wealthAction.setMinimumSize(buttonSize);
		wealthAction.setPreferredSize(buttonSize);
		wealthAction.setMaximumSize(buttonSize);
		wealthAction.setAlignmentX(Component.CENTER_ALIGNMENT);
		wealthAction.setText("Wealth Action");
		wealthAction.setMargin(new Insets(2, 2, 2, 2));
		wealthAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				militaryAction_ActionPerformed(evt);
			}
		});
		wealthAction.setBackground(Color.WHITE);
		wealthAction.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(wealthAction);
				
		//Exit Menu Button - Closes menu screen
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		exitMenu.setMinimumSize(buttonSize);
		exitMenu.setPreferredSize(buttonSize);
		exitMenu.setMaximumSize(buttonSize);
		exitMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		exitMenu.setText("Exit Menu");
		exitMenu.setMargin(new Insets(2, 2, 2, 2));
		exitMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				militaryAction_ActionPerformed(evt);
			}
		});
		exitMenu.setBackground(Color.WHITE);
		exitMenu.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(exitMenu);
		
		for (Component j : cp.getComponents() ){
			if (j instanceof JButton){
				j.setFont(new Font("Sans", Font.BOLD, 14));
			}
			
		}
		cp.setBackground(new Color(0x3399FF));

		setVisible(true);
	}

	// Take Military Action
	public void militaryAction_ActionPerformed(ActionEvent evt) { 
		if (running == false) {
			new MilitaryActionMenu("Take a Military Action");
			closeMenu();
		} else {
			JOptionPane.showMessageDialog(this,
				    "Please close the menu and try again!",
				    "This menu is already running!",
				    JOptionPane.WARNING_MESSAGE);
		}
	
	}
		
	// Take Political Action
	public void politicalAction_ActionPerformed(ActionEvent evt) { 
		if (running == false) {
			new PoliticsActionMenu("Take a Political Action");
			closeMenu();
		} else {
			JOptionPane.showMessageDialog(this,
				    "Please close the menu and try again!",
				    "This menu is already running!",
				    JOptionPane.WARNING_MESSAGE);
		}		
	}
		
	// Take Resource Action
	public void resourceAction_ActionPerformed(ActionEvent evt) { 
		if (running == false) {
			new ResourceActionMenu("Take a Resource Action");
			closeMenu();
		} else {
			JOptionPane.showMessageDialog(this,
				    "Please close the menu and try again!",
				    "This menu is already running!",
				    JOptionPane.WARNING_MESSAGE);
		}		
	}

	// Take Wealth Action
	public void wealthAction_ActionPerformed(ActionEvent evt) { 
		if (running == false) {
			new WealthActionMenu("Take a Wealth Action");
			closeMenu();
		} else {
			JOptionPane.showMessageDialog(this,
				    "Please close the menu and try again!",
				    "This menu is already running!",
				    JOptionPane.WARNING_MESSAGE);
		}				
	}
		
	// Exit Menu Action
	public void exitMenu_ActionPerformed(ActionEvent evt) { 
		closeMenu();
	}

	/**
	 * Closes the menu.
	 */
	public void closeMenu() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	
}
