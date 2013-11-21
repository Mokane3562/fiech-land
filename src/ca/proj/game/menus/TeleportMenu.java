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

	private boolean running = Game.isRunning();

	public TeleportMenu(String title) {

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
		
		fiechLandButton.setBounds(168, 392, 305, 57);
		fiechLandButton.setText("Return to Game");
		fiechLandButton.setMargin(new Insets(2, 2, 2, 2));
		fiechLandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fiechLandButton_ActionPerformed(evt);
			}
		});
		fiechLandButton.setBackground(Color.WHITE);
		fiechLandButton.setBorder(BorderFactory.createEtchedBorder(0,
				Color.GREEN, Color.BLACK));
		cp.add(fiechLandButton);

		returnToGameButton.setBounds(168, 480, 305, 57);
		returnToGameButton.setText("Return to Game");
		returnToGameButton.setMargin(new Insets(2, 2, 2, 2));
		returnToGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				returnToGameButton_ActionPerformed(evt);
			}
		});
		returnToGameButton.setBackground(Color.WHITE);
		returnToGameButton.setBorder(BorderFactory.createEtchedBorder(0,
				Color.GREEN, Color.BLACK));
		cp.add(returnToGameButton);
	

		cp.setBackground(new Color(0xFFC800));

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

	public void closeMenu() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

}
