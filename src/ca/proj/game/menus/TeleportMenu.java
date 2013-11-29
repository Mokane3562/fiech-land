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
	private JButton blankButton1 = new JButton();
	private JButton blankButton2 = new JButton();
	private JButton blankButton3 = new JButton();
	private JButton blankButton4 = new JButton();

	/**
	 * Creates a new teleport menu frame.
	 * 
	 * @param title
	 *            the title of the frame
	 */
	public TeleportMenu(String title) {

		super(title);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 400;
		int frameHeight = 400;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		GridLayout gridLayout = new GridLayout(3, 3);
		cp.setLayout(gridLayout);

		Dimension buttonSize = new Dimension(128, 128);

		blankButton1.setMinimumSize(buttonSize);
		blankButton1.setPreferredSize(buttonSize);
		blankButton1.setMaximumSize(buttonSize);
		blankButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
		blankButton1.setBackground(Color.BLUE);
		cp.add(blankButton1);

		waterfallGrasslandButton.setMinimumSize(buttonSize);
		waterfallGrasslandButton.setPreferredSize(buttonSize);
		waterfallGrasslandButton.setMaximumSize(buttonSize);
		waterfallGrasslandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				waterfallGrasslandButton_ActionPerformed(evt);
			}
		});
		if (Game.level.getImagePath() == "/levels/waterfall-grassland.png") {
			try {
				Image img = ImageIO.read(getClass().getResource(
						"/levels/waterfall-grassland-x.png"));
				waterfallGrasslandButton.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		} else {
			try {
				Image img = ImageIO.read(getClass().getResource(
						"/levels/waterfall-grassland.png"));
				waterfallGrasslandButton.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		}
		cp.add(waterfallGrasslandButton);

		blankButton2.setMinimumSize(buttonSize);
		blankButton2.setPreferredSize(buttonSize);
		blankButton2.setMaximumSize(buttonSize);
		blankButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
		blankButton2.setBackground(Color.BLUE);
		cp.add(blankButton2);
		
		ancientRuinsButton.setMinimumSize(buttonSize);
		ancientRuinsButton.setPreferredSize(buttonSize);
		ancientRuinsButton.setMaximumSize(buttonSize);
		ancientRuinsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ancientRuinsButton_ActionPerformed(evt);
			}
		});
		if (Game.level.getImagePath() == "/levels/ancient-ruins.png") {
			try {
				Image img = ImageIO.read(getClass().getResource(
						"/levels/ancient-ruins-x.png"));
				waterfallGrasslandButton.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		} else {
			try {
				Image img = ImageIO.read(getClass().getResource(
						"/levels/ancient-ruins.png"));
				waterfallGrasslandButton.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		}
		cp.add(ancientRuinsButton);

		threeLakesButton.setMinimumSize(buttonSize);
		threeLakesButton.setPreferredSize(buttonSize);
		threeLakesButton.setMaximumSize(buttonSize);
		threeLakesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				threeLakesButton_ActionPerformed(evt);
			}
		});
		if (Game.level.getImagePath() == "/levels/three-lakes.png") {
			try {
				Image img = ImageIO.read(getClass().getResource(
						"/levels/three-lakes-x.png"));
				waterfallGrasslandButton.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		} else {
			try {
				Image img = ImageIO.read(getClass().getResource(
						"/levels/three-lakes.png"));
				waterfallGrasslandButton.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		}
		cp.add(threeLakesButton);

		desertBorderButton.setMinimumSize(buttonSize);
		desertBorderButton.setPreferredSize(buttonSize);
		desertBorderButton.setMaximumSize(buttonSize);
		desertBorderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				desertBorderButton_ActionPerformed(evt);
			}
		});
		if (Game.level.getImagePath() == "/levels/desert-border.png") {
			try {
				Image img = ImageIO.read(getClass().getResource(
						"/levels/desert-border-x.png"));
				waterfallGrasslandButton.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		} else {
			try {
				Image img = ImageIO.read(getClass().getResource(
						"/levels/desert-border.png"));
				waterfallGrasslandButton.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		}
		cp.add(desertBorderButton);
		
		blankButton3.setMinimumSize(buttonSize);
		blankButton3.setPreferredSize(buttonSize);
		blankButton3.setMaximumSize(buttonSize);
		blankButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
		blankButton3.setBackground(Color.BLUE);
		cp.add(blankButton3);

		fiechLandButton.setMinimumSize(buttonSize);
		fiechLandButton.setPreferredSize(buttonSize);
		fiechLandButton.setMaximumSize(buttonSize);
		fiechLandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fiechLandButton_ActionPerformed(evt);
			}
		});
		if (Game.level.getImagePath() == "/levels/fiech-land.png") {
			try {
				Image img = ImageIO.read(getClass().getResource(
						"/levels/fiech-land-x.png"));
				waterfallGrasslandButton.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		} else {
			try {
				Image img = ImageIO.read(getClass().getResource(
						"/levels/fiech-land.png"));
				waterfallGrasslandButton.setIcon(new ImageIcon(img));
			} catch (IOException ex) {
			}
		}
		cp.add(fiechLandButton);

		blankButton4.setMinimumSize(buttonSize);
		blankButton4.setPreferredSize(buttonSize);
		blankButton4.setMaximumSize(buttonSize);
		blankButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
		blankButton4.setBackground(Color.BLUE);
		cp.add(blankButton4);
		
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
