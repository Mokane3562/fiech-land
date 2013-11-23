package ca.proj.game.menus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.WindowConstants;


/** TeleportMenu.java is used to select a territory to start a new game in.
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


public class GovernmentInitializationMenu extends JFrame {
	private JButton democratic=new JButton();
	private JButton dictatorship=new JButton();
	private JButton cancel=new JButton();
	
	public GovernmentInitializationMenu() {
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth=650;
		int frameHeight=500;
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
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		democratic.setMinimumSize(buttonSize);
		democratic.setPreferredSize(buttonSize);
		democratic.setMaximumSize(buttonSize);
		democratic.setAlignmentX(Component.CENTER_ALIGNMENT);
		democratic.setText("Democratic Government");
		democratic.setMargin(new Insets(2, 2, 2, 2));
		democratic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				democracy_ActionPerformed(evt);
			}
		});
		democratic.setBackground(Color.WHITE);
		democratic.setBorder(BorderFactory.createEtchedBorder(0,
				Color.GREEN, Color.BLACK));
		cp.add(democratic);
		   // Add dictatorship gov't button
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		dictatorship.setMinimumSize(buttonSize);
		dictatorship.setPreferredSize(buttonSize);
		dictatorship.setMaximumSize(buttonSize);
		dictatorship.setAlignmentX(Component.CENTER_ALIGNMENT);
		dictatorship.setText("Dictatorship Government");
		dictatorship.setMargin(new Insets(2, 2, 2, 2));
		dictatorship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dictatorship_actionPerformed(evt);
			}
			});
		dictatorship.setBackground(Color.WHITE);
		dictatorship.setBorder(BorderFactory.createEtchedBorder(0,
				Color.GREEN, Color.BLACK));
		cp.add(dictatorship);
		   // Add Cancel button
		cp.add(new Box.Filler(minSize, prefSize, maxSize));
		cancel.setMinimumSize(buttonSize);
	    cancel.setPreferredSize(buttonSize);
	    cancel.setMaximumSize(buttonSize);
	    cancel.setAlignmentX(Component.CENTER_ALIGNMENT);
	    cancel.setText("Cancel");
	    cancel.setMargin(new Insets(2, 2, 2, 2));
	    cancel.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    		cancel_actionPerformed(evt);
	    	}
	    });
	    cancel.setBackground(Color.WHITE);
	    cancel.setBorder(BorderFactory.createEtchedBorder(0,
				Color.GREEN, Color.BLACK));
	    cp.add(cancel);
	    
	    cp.setBackground(new Color(0xFFC800));
	    setVisible(true);
	}

	protected void cancel_actionPerformed(ActionEvent evt) {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	protected void dictatorship_actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	protected void democracy_ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
}
