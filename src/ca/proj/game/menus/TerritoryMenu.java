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

/**
 * 
 * TerritoryMenu.java is used to select a territory to start a new game in.
 * 
 * Copyright (C) 2013 Tyler Stacey, Mark Gauci, Ryan Martin, Mike Singleton
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
@SuppressWarnings("serial")
public class TerritoryMenu extends JFrame {
	private JButton waterfallGrasslandButton = new JButton();
	private JButton ancientRuinsButton = new JButton();
	private JButton returnToMainButton = new JButton();
	private JButton threeLakesButton = new JButton();
	private JButton desertBorderButton = new JButton();

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

		waterfallGrasslandButton.setBounds(168, 40, 305, 57);
		waterfallGrasslandButton.setText("Start in WaterFall-Grassland");
		waterfallGrasslandButton.setMargin(new Insets(2, 2, 2, 2));
		waterfallGrasslandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				waterfallGrasslandButton_ActionPerformed(evt);
			}
		});
		waterfallGrasslandButton.setBackground(Color.WHITE);
		waterfallGrasslandButton.setBorder(BorderFactory.createEtchedBorder(0,
				Color.GREEN, Color.BLACK));
		cp.add(waterfallGrasslandButton);

		ancientRuinsButton.setBounds(168, 128, 305, 57);
		ancientRuinsButton.setText("Start in Ancient-Ruins");
		ancientRuinsButton.setMargin(new Insets(2, 2, 2, 2));
		ancientRuinsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ancientRuinsButton_ActionPerformed(evt);
			}
		});
		ancientRuinsButton.setBackground(Color.WHITE);
		ancientRuinsButton.setBorder(BorderFactory.createEtchedBorder(0,
				Color.GREEN, Color.BLACK));
		cp.add(ancientRuinsButton);

		threeLakesButton.setBounds(168, 216, 305, 57);
		threeLakesButton.setText("Start in Three-Lakes");
		threeLakesButton.setMargin(new Insets(2, 2, 2, 2));
		threeLakesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				threeLakesButton_ActionPerformed(evt);
			}
		});
		threeLakesButton.setBackground(Color.WHITE);
		threeLakesButton.setBorder(BorderFactory.createEtchedBorder(0,
				Color.GREEN, Color.BLACK));
		cp.add(threeLakesButton);

		desertBorderButton.setBounds(168, 304, 305, 57);
		desertBorderButton.setText("Start in Desert-Border");
		desertBorderButton.setMargin(new Insets(2, 2, 2, 2));
		desertBorderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				desertBorderButton_ActionPerformed(evt);
			}
		});
		desertBorderButton.setBackground(Color.WHITE);
		desertBorderButton.setBorder(BorderFactory.createEtchedBorder(0,
				Color.GREEN, Color.BLACK));
		cp.add(desertBorderButton);

		returnToMainButton.setBounds(168, 392, 305, 57);
		returnToMainButton.setText("Return to Main Menu");
		returnToMainButton.setMargin(new Insets(2, 2, 2, 2));
		returnToMainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				returnToMainButton_ActionPerformed(evt);
			}
		});
		returnToMainButton.setBackground(Color.WHITE);
		returnToMainButton.setBorder(BorderFactory.createEtchedBorder(0,
				Color.GREEN, Color.BLACK));
		cp.add(returnToMainButton);

		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
	}

	public void waterfallGrasslandButton_ActionPerformed(ActionEvent evt) {
		if (running == false) {
			Game g = new Game("/levels/waterfall-grassland.png");
			g.start();
			closeMenu();
			new AttributeMenu("Adjust your Attributes...");
		} else {
			JOptionPane.showMessageDialog(this,
					"Please restart the application to start a new game!",
					"Already Running!", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void ancientRuinsButton_ActionPerformed(ActionEvent evt) {
		if (running == false) {
			Game g = new Game("/levels/ancient-ruins.png");
			g.start();
			closeMenu();
			new AttributeMenu("Adjust your Attributes...");
		} else {
			JOptionPane.showMessageDialog(this,
					"Please restart the application to start a new game!",
					"Already Running!", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void threeLakesButton_ActionPerformed(ActionEvent evt) {
		if (running == false) {
			Game g = new Game("/levels/three-lakes.png");
			g.start();
			closeMenu();
			new AttributeMenu("Adjust your Attributes...");
		} else {
			JOptionPane.showMessageDialog(this,
					"Please restart the application to start a new game!",
					"Already Running!", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void desertBorderButton_ActionPerformed(ActionEvent evt) {
		if (running == false) {
			Game g = new Game("/levels/desert-border.png");
			g.start();
			closeMenu();
			new AttributeMenu("Adjust your Attributes...");
		} else {
			JOptionPane.showMessageDialog(this,
					"Please restart the application to start a new game!",
					"Already Running!", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void returnToMainButton_ActionPerformed(ActionEvent evt) {
		new Menu("Menu");
		closeMenu();
	}

	public void closeMenu() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

}
