package ca.proj.game.menus;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import ca.proj.game.Game;

/**
 * 
 * Menu.java is displayed to start new games and exit the game.
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
@SuppressWarnings("serial")
public class Menu extends JFrame {

	private JButton startNewGameButton = new JButton();
	private JButton returnToGameButton = new JButton();
	private JButton quitGameButton = new JButton();

	private boolean running = Game.isRunning();

	/**
	 * Creates a new menu frame.
	 * 
	 * @param title the title of the frame
	 */
	public Menu(String title) {

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

		startNewGameButton.setBounds(168, 80, 305, 57);
		startNewGameButton.setText("Start New Game");
		startNewGameButton.setMargin(new Insets(2, 2, 2, 2));
		startNewGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				startNewGameButton_ActionPerformed(evt);
			}
		});
		startNewGameButton.setBackground(Color.WHITE);
		startNewGameButton.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(startNewGameButton);

		returnToGameButton.setBounds(168, 168, 305, 57);
		returnToGameButton.setText("Return to Game");
		returnToGameButton.setMargin(new Insets(2, 2, 2, 2));
		returnToGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				returnToGameButton_ActionPerformed(evt);
			}
		});
		returnToGameButton.setBackground(Color.WHITE);
		returnToGameButton.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(returnToGameButton);

		quitGameButton.setBounds(168, 256, 305, 57);
		quitGameButton.setText("Exit Game");
		quitGameButton.setMargin(new Insets(2, 2, 2, 2));
		quitGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				quitGameButton_ActionPerformed(evt);
			}
		});
		quitGameButton.setBackground(Color.WHITE);
		quitGameButton.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(quitGameButton);

		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
	}
	public void startNewGameButton_ActionPerformed(ActionEvent evt) { // ENTER LEVEL
		if (running == false) {
			new TerritoryMenu("Choose a Territory");
			closeMenu();
		} else {
			JOptionPane.showMessageDialog(this,
				    "Please restart the application to start a new game!",
				    "Already Running!",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	public void returnToGameButton_ActionPerformed(ActionEvent evt) { // ENTER LEVEL
		if (running == false) {
			JOptionPane.showMessageDialog(this, "No game running!",
					"Not Running!", JOptionPane.WARNING_MESSAGE);
		} else {
			closeMenu();
		}
	}
	public void quitGameButton_ActionPerformed(ActionEvent evt) { // ENTER LEVEL
		Game.quit();
	}

	/**
	 * Closes the menu.
	 */
	public void closeMenu() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	public static void main(String[] args) {
		new Menu("Menu");
	}

}
