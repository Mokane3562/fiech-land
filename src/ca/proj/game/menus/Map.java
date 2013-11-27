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
public class Map extends JFrame {
	private JButton returnToGameButton = new JButton();

	/**
	 * Creates a new teleport menu frame.
	 * 
	 * @param title
	 *            the title of the frame
	 */
	public Map(String title) {

		super(title);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 384 + 10;
		int frameHeight = 384 + 10;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		FlowLayout boxLayout = new FlowLayout(FlowLayout.CENTER);
		cp.setLayout(boxLayout);

		Image img = null;
		try {
			img = ImageIO.read(getClass().getResource(
					"/levels/overview_map.png"));
			returnToGameButton.setIcon(new ImageIcon(img));

		} catch (IOException ex) {
		}

		Dimension buttonSize = new Dimension(384, 384);
		returnToGameButton.setMinimumSize(buttonSize);
		returnToGameButton.setPreferredSize(buttonSize);
		returnToGameButton.setMaximumSize(buttonSize);
		// returnToGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		//returnToGameButton.setText("Return to Game");
		returnToGameButton.setMargin(new Insets(2, 2, 2, 2));
		returnToGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				returnToGameButton_ActionPerformed(evt);
			}
		});
		// returnToGameButton.setBackground(Color.WHITE);
		returnToGameButton.setBorder(BorderFactory.createEtchedBorder(0,
				Color.GREEN, Color.BLACK));

		cp.add(returnToGameButton);

		cp.setBackground(new Color(0x555555));
		setVisible(true);
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
