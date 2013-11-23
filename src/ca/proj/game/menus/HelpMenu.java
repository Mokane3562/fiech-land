package ca.proj.game.menus;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * 
 * HelpMenu.java Displays Help Information to the player.
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
public class HelpMenu extends JFrame {

	public HelpMenu(String title) {
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
		String helpText = "<html>ESC - Display the Main Menu<br>"
				+ "F1 - Looks like you found this one already<br>"
				+ "F2 - Display Government Action<br>"
				+ "F3 - Display Military actions<br>"
				+ "F4 - Display Political actions menu<br>"
				+ "F5 - Display Resource actions<br>"
				+ "F6 - Display wealth actions<br>"
				+ "WASD - Movement of the player<br>"
				+ "UP,DOWN,LEFT,RIGHT - Movement of the player<br>"
				+ "T - Display the teleport menu<br>"
				+ "E - Get support of the territory<br>"
				+ "G - Start a government<br>"
				+ "I - Investigate an Item<br>"
				+ "ENTER - In game select actions<br>"
				+ "K - Display Player coordinates in the terminal<br></html>";
		JLabel helpInfo = new JLabel(helpText, JLabel.CENTER);
		helpInfo.setFont(new Font("Sans", Font.BOLD, 22));
		cp.add(helpInfo);
		
		cp.setBackground(new Color(0x3399FF));

		setVisible(true);
	}

	/**
	 * Closes the menu.
	 */
	public void closeMenu() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

}
