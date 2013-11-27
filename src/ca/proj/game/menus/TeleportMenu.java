package ca.proj.game.menus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;


import ca.proj.game.Game;

/**
 * 
 * TeleportMenu.java is used to select a territory to start a new game in.
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
public class TeleportMenu extends JFrame {
	private JButton waterfallGrasslandButton = new JButton();
	private JButton ancientRuinsButton = new JButton();
	private JButton threeLakesButton = new JButton();
	private JButton desertBorderButton = new JButton();
	private JButton fiechLandButton = new JButton();
	private JButton returnToGameButton = new JButton();

	/**
	 * Creates a new teleport menu frame.
	 * 
	 * @param title
	 *            the title of the frame
	 */
	public TeleportMenu(String title) {

		super(title);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 275;
		int frameHeight = 500;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		FlowLayout boxLayout = new FlowLayout(FlowLayout.CENTER);
		cp.setLayout(boxLayout);

		Dimension buttonSize = new Dimension(128, 128);

		waterfallGrasslandButton.setMinimumSize(buttonSize);
		waterfallGrasslandButton.setPreferredSize(buttonSize);
		waterfallGrasslandButton.setMaximumSize(buttonSize);
		//waterfallGrasslandButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		// waterfallGrasslandButton.setText("WaterFall-Grassland");
		//waterfallGrasslandButton.setMargin(new Insets(2, 2, 2, 2));
		waterfallGrasslandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				waterfallGrasslandButton_ActionPerformed(evt);
			}
		});
		//waterfallGrasslandButton.setBackground(Color.WHITE);
		//waterfallGrasslandButton.setBorder(BorderFactory.createEtchedBorder(0,
		//		Color.GREEN, Color.BLACK));
		try {
			Image img = ImageIO.read(getClass().getResource(
					"/levels/waterfall-grassland.png"));
			waterfallGrasslandButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		cp.add(waterfallGrasslandButton);

		ancientRuinsButton.setMinimumSize(buttonSize);
		ancientRuinsButton.setPreferredSize(buttonSize);
		ancientRuinsButton.setMaximumSize(buttonSize);
		//ancientRuinsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		// ancientRuinsButton.setText("Ancient-Ruins");
		//ancientRuinsButton.setMargin(new Insets(2, 2, 2, 2));
		ancientRuinsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ancientRuinsButton_ActionPerformed(evt);
			}
		});
		//ancientRuinsButton.setBackground(Color.WHITE);
		//ancientRuinsButton.setBorder(BorderFactory.createEtchedBorder(0,
		//		Color.GREEN, Color.BLACK));
		try {
			Image img1 = ImageIO.read(getClass().getResource(
					"/levels/ancient-ruins.png"));
			ancientRuinsButton.setIcon(new ImageIcon(img1));
		} catch (IOException ex) {
		}
		cp.add(ancientRuinsButton);

		threeLakesButton.setMinimumSize(buttonSize);
		threeLakesButton.setPreferredSize(buttonSize);
		threeLakesButton.setMaximumSize(buttonSize);
		//threeLakesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		// threeLakesButton.setText("Three-Lakes");
		//threeLakesButton.setMargin(new Insets(2, 2, 2, 2));
		threeLakesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				threeLakesButton_ActionPerformed(evt);
			}
		});
		//threeLakesButton.setBackground(Color.WHITE);
		//threeLakesButton.setBorder(BorderFactory.createEtchedBorder(0,
		//		Color.GREEN, Color.BLACK));
		try {
			Image img2 = ImageIO.read(getClass().getResource(
					"/levels/three-lakes.png"));
			threeLakesButton.setIcon(new ImageIcon(img2));
		} catch (IOException ex) {
		}
		cp.add(threeLakesButton);

		desertBorderButton.setMinimumSize(buttonSize);
		desertBorderButton.setPreferredSize(buttonSize);
		desertBorderButton.setMaximumSize(buttonSize);
		//desertBorderButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		// desertBorderButton.setText("Desert-Border");
		//desertBorderButton.setMargin(new Insets(2, 2, 2, 2));
		desertBorderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				desertBorderButton_ActionPerformed(evt);
			}
		});
		//desertBorderButton.setBackground(Color.WHITE);
		//desertBorderButton.setBorder(BorderFactory.createEtchedBorder(0,
		//		Color.GREEN, Color.BLACK));
		try {
			Image img3 = ImageIO.read(getClass().getResource(
					"/levels/desert-border.png"));
			desertBorderButton.setIcon(new ImageIcon(img3));
		} catch (IOException ex) {
		}
		cp.add(desertBorderButton);

		fiechLandButton.setMinimumSize(buttonSize);
		fiechLandButton.setPreferredSize(buttonSize);
		fiechLandButton.setMaximumSize(buttonSize);
		//fiechLandButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		// fiechLandButton.setText("Fiech-Land");
		//fiechLandButton.setMargin(new Insets(2, 2, 2, 2));
		fiechLandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fiechLandButton_ActionPerformed(evt);
			}
		});
		//fiechLandButton.setBackground(Color.WHITE);
		//fiechLandButton.setBorder(BorderFactory.createEmptyBorder());
		try {
			Image img4 = ImageIO.read(getClass().getResource(
					"/levels/fiech-land.png"));
			fiechLandButton.setIcon(new ImageIcon(img4));
		} catch (IOException ex) {
		}
		cp.add(fiechLandButton);

		returnToGameButton.setMinimumSize(buttonSize);
		returnToGameButton.setPreferredSize(buttonSize);
		returnToGameButton.setMaximumSize(buttonSize);
		//returnToGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		returnToGameButton.setText("Return to Game");
		returnToGameButton.setMargin(new Insets(2, 2, 2, 2));
		returnToGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				returnToGameButton_ActionPerformed(evt);
			}
		});
		//returnToGameButton.setBackground(Color.WHITE);
		returnToGameButton.setBorder(BorderFactory.createEtchedBorder(0,
				Color.GREEN, Color.BLACK));

		cp.add(returnToGameButton);
		for (Component j : cp.getComponents()) {
			if (j instanceof JButton) {
				j.setFont(new Font("Sans", Font.BOLD, 14));
			}

		}
		cp.setBackground(new Color(0x555555));
		setVisible(true);
	}

	public void waterfallGrasslandButton_ActionPerformed(ActionEvent evt) {
		Game.startLevel("/levels/waterfall-grassland.png");
		closeMenu();
	}

	public void ancientRuinsButton_ActionPerformed(ActionEvent evt) {
		Game.startLevel("/levels/ancient-ruins.png");
		closeMenu();
	}

	public void threeLakesButton_ActionPerformed(ActionEvent evt) {
		Game.startLevel("/levels/three-lakes.png");
		closeMenu();
	}

	public void desertBorderButton_ActionPerformed(ActionEvent evt) {
		Game.startLevel("/levels/desert-border.png");
		closeMenu();
	}

	public void fiechLandButton_ActionPerformed(ActionEvent evt) {
		Game.startLevel("/levels/fiech-land.png");
		closeMenu();
	}

	public void returnToGameButton_ActionPerformed(ActionEvent evt) {
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
