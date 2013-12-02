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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import ca.proj.game.Game;
import ca.proj.game.entities.Government.Gov_Type;

/**
 * 
 * GovernmentInitMenu.java displayed when initializing a governemnt
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
public class GovernmentInitMenu extends JFrame {

	private JButton democracyButton = new JButton();
	private JButton dictatorshipButton = new JButton();
	private JButton cancelButton = new JButton();

	public GovernmentInitMenu(String title) {
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

		// Add Democratic gov't button
		if (Game.player.getLevelSupport() > 50) {	
			cp.add(new Box.Filler(minSize, prefSize, maxSize));
			democracyButton.setMinimumSize(buttonSize);
			democracyButton.setPreferredSize(buttonSize);
			democracyButton.setMaximumSize(buttonSize);
			democracyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			democracyButton.setText("Start a Democracy");
			democracyButton.setMargin(new Insets(2, 2, 2, 2));
			democracyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					try {
						democracyButton_ActionPerformed(evt);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			democracyButton.setBackground(Color.WHITE);
			democracyButton.setBorder(BorderFactory.createEtchedBorder(0,
					Color.GREEN, Color.BLACK));
			cp.add(democracyButton);

			// Add dictatorship gov't button
			cp.add(new Box.Filler(minSize, prefSize, maxSize));
			dictatorshipButton.setMinimumSize(buttonSize);
			dictatorshipButton.setPreferredSize(buttonSize);
			dictatorshipButton.setMaximumSize(buttonSize);
			dictatorshipButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			dictatorshipButton.setText("Start a Dictatorship");
			dictatorshipButton.setMargin(new Insets(2, 2, 2, 2));
			dictatorshipButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					try {
						dictatorshipButton_ActionPerformed(evt);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			dictatorshipButton.setBackground(Color.WHITE);
			dictatorshipButton.setBorder(BorderFactory.createEtchedBorder(0,
					Color.GREEN, Color.BLACK));
			cp.add(dictatorshipButton);

			cp.add(new Box.Filler(minSize, prefSize, maxSize));
			cancelButton.setMinimumSize(buttonSize);
			cancelButton.setPreferredSize(buttonSize);
			cancelButton.setMaximumSize(buttonSize);
			cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			cancelButton.setText("Cancel");
			cancelButton.setMargin(new Insets(2, 2, 2, 2));
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					closeMenu();
				}
			});
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setBorder(BorderFactory.createEtchedBorder(0,
					Color.GREEN, Color.BLACK));
			cp.add(cancelButton);
		} else {
			String helpText = "<html>You do not have<br>"
					+ "enough support!</html>";
			JLabel helpInfo = new JLabel(helpText, JLabel.CENTER);
			helpInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
			helpInfo.setFont(new Font("Sans", Font.BOLD, 48));
			cp.add(helpInfo);

			cp.add(new Box.Filler(minSize, prefSize, maxSize));
			cancelButton.setMinimumSize(buttonSize);
			cancelButton.setPreferredSize(buttonSize);
			cancelButton.setMaximumSize(buttonSize);
			cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			cancelButton.setText("Return to Game");
			cancelButton.setMargin(new Insets(2, 2, 2, 2));
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					closeMenu();
				}
			});
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setBorder(BorderFactory.createEtchedBorder(0,
					Color.GREEN, Color.BLACK));
			cp.add(cancelButton);
		}
		cp.setBackground(new Color(0x3399FF));

		setVisible(true);
	}

	public void democracyButton_ActionPerformed(ActionEvent evt)
			throws InterruptedException, CloneNotSupportedException {
		Game.level.startGovernment(Gov_Type.DEMOCRACY);
		closeMenu();
	}

	public void dictatorshipButton_ActionPerformed(ActionEvent evt)
			throws InterruptedException, CloneNotSupportedException {
		Game.level.startGovernment(Gov_Type.DICTATORSHIP);
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
