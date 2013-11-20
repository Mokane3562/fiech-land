package ca.proj.game.menus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ca.proj.game.entities.Player;

/**
 * 
 * AttributeMenu.java
 * 
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
public class AttributeMenu extends JFrame {
	
	//components
	private JLabel jLabelHeader = new JLabel("Distribute your points", JLabel.CENTER);
	private JLabel jLabel1 = new JLabel("Wealth", JLabel.CENTER);
	private JLabel jLabel2 = new JLabel("Resources", JLabel.CENTER);
	private JLabel jLabel3 = new JLabel("Politics", JLabel.CENTER);
	private JLabel jLabel4 = new JLabel("Expansion", JLabel.CENTER);
	private JLabel jLabel5 = new JLabel("Military", JLabel.CENTER);
	private JButton jButton1 = new JButton("Reset");
	private JButton jButton2 = new JButton("Ok");
	private JTextField jTextField1 = new JTextField();
	private JSlider jSlider1 = new JSlider(10, 60, 10);
	private JSlider jSlider2 = new JSlider(10, 60, 10);
	private JSlider jSlider3 = new JSlider(10, 60, 10);
	private JSlider jSlider4 = new JSlider(10, 60, 10);
	private JSlider jSlider5 = new JSlider(10, 60, 10);
	private JSpinner jSpinner1 = new JSpinner();
	private JSpinner jSpinner2 = new JSpinner();
	private JSpinner jSpinner3 = new JSpinner();
	private JSpinner jSpinner4 = new JSpinner();
	private JSpinner jSpinner5 = new JSpinner();
	
	//player vars
	private int wealthVal = 10;
	private int resourcesVal = 10;
	private int politicsVal = 10;
	private int expansionVal = 10;
	private int militaryVal = 10;
	private int pointPool = 50;
	
	public static boolean running = false;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);

	/**
	 * Creates the Attribute Menu
	 * 
	 * @param title
	 */
	public AttributeMenu(String title) {

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
		cp.setLayout(new BorderLayout());
		
		//initialize panels
		final int VERT_SPACE = 50; 
		JPanel header = new JPanel(new FlowLayout());
		JPanel labels = new JPanel(new GridLayout(5, 1, 0, VERT_SPACE));
		JPanel footer = new JPanel(new GridLayout(1, 3));
		JPanel spinners = new JPanel(new GridLayout(5, 1, 0, VERT_SPACE));
		JPanel sliders = new JPanel(new GridLayout(5, 1, 0, VERT_SPACE));
		
		//prepare header panel
		header.setBackground(Color.WHITE);
		header.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		header.add(jLabelHeader);
		
		//prepare labels panel
		labels.add(jLabel1);
		labels.add(jLabel2);
		labels.add(jLabel3);
		labels.add(jLabel4);
		labels.add(jLabel5);
		
		//prepare footer panel
		jButton1.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent evt) {
				jSlider1.setValue(10);
				jSlider2.setValue(10);
				jSlider3.setValue(10);
				jSlider4.setValue(10);
				jSlider5.setValue(10);
			}
		});
		jButton1.setBackground(Color.WHITE);
		jButton1.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		footer.add(jButton1);
		
		jTextField1.setText("Points left: " + String.valueOf(pointPool));
		jTextField1.setEditable(false);
		jTextField1.setBackground(Color.WHITE);
		jTextField1.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		footer.add(jTextField1);
		
		jButton2.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent evt) {
				Player.setWealth(wealthVal);
				Player.setResources(resourcesVal);
				Player.setMilitary(militaryVal);
				Player.setExpansion(expansionVal);
				Player.setPolitics(politicsVal);
				closeMenu();
			}
		});
		jButton2.setBackground(Color.WHITE);
		jButton2.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		footer.add(jButton2);
		
		//prepare spinners panel
		jSpinner1.setModel(new SpinnerNumberModel(10, 10, 60, 1));
		jSpinner1.addChangeListener(new ChangeListener() {
			/* (non-Javadoc)
			 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
			 */
			public void stateChanged(ChangeEvent e) {
				jSlider1.setValue((Integer) jSpinner1.getValue());
			}
		});
		jSpinner1.setBackground(Color.WHITE);
		jSpinner1.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		spinners.add(jSpinner1);
		
		jSpinner2.setModel(new SpinnerNumberModel(10, 10, 60, 1));
		jSpinner2.addChangeListener(new ChangeListener() {
			/* (non-Javadoc)
			 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
			 */
			public void stateChanged(ChangeEvent e) {
				jSlider2.setValue((Integer) jSpinner2.getValue());
			}
		});
		jSpinner2.setBackground(Color.WHITE);
		jSpinner2.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		spinners.add(jSpinner2);
		
		jSpinner3.setModel(new SpinnerNumberModel(10, 10, 60, 1));
		jSpinner3.addChangeListener(new ChangeListener() {
			/* (non-Javadoc)
			 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
			 */
			public void stateChanged(ChangeEvent e) {
				jSlider3.setValue((Integer) jSpinner3.getValue());
			}
		});
		jSpinner3.setBackground(Color.WHITE);
		jSpinner3.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		spinners.add(jSpinner3);
		
		jSpinner4.setModel(new SpinnerNumberModel(10, 10, 60, 1));
		jSpinner4.addChangeListener(new ChangeListener() {
			/* (non-Javadoc)
			 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
			 */
			public void stateChanged(ChangeEvent e) {
				jSlider4.setValue((Integer) jSpinner4.getValue());
			}
		});
		jSpinner4.setBackground(Color.WHITE);
		jSpinner4.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		spinners.add(jSpinner4);
		
		jSpinner5.setModel(new SpinnerNumberModel(10, 10, 60, 1));
		jSpinner5.addChangeListener(new ChangeListener() {
			/* (non-Javadoc)
			 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
			 */
			public void stateChanged(ChangeEvent e) {
				jSlider5.setValue((Integer) jSpinner5.getValue());
			}
		});
		jSpinner5.setBackground(Color.WHITE);
		jSpinner5.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		spinners.add(jSpinner5);
		
		//prepare sliders panel
		jSlider1.setMajorTickSpacing(10);
		jSlider1.setMinorTickSpacing(1);
		jSlider1.setSnapToTicks(true);
		jSlider1.setPaintLabels(true);
		jSlider1.setPaintTicks(true);
		jSlider1.setEnabled(true);
		jSlider1.addChangeListener(new ChangeListener() {
			/* (non-Javadoc)
			 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
			 */
			public void stateChanged(ChangeEvent e) {
				int prevVal = wealthVal;
				int newVal = jSlider1.getValue();
				if (newVal - prevVal > pointPool){
					jSlider1.setValue(prevVal + pointPool);
					newVal = jSlider1.getValue();
				}
				pointPool -= newVal - prevVal;
                jSpinner1.setValue(jSlider1.getValue());
                wealthVal = jSlider1.getValue();
                jTextField1.setText("Points left: " + String.valueOf(pointPool));
                System.out.println("Wealth: " + wealthVal);
                System.out.println("Points: " + pointPool);
			}
		});
		jSlider1.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSlider1.setBackground(Color.WHITE);
		sliders.add(jSlider1);
		
		jSlider2.setMajorTickSpacing(10);
		jSlider2.setMinorTickSpacing(1);
		jSlider2.setSnapToTicks(true);
		jSlider2.setPaintLabels(true);
		jSlider2.setPaintTicks(true);
		jSlider2.addChangeListener(new ChangeListener() {
			/* (non-Javadoc)
			 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
			 */
			public void stateChanged(ChangeEvent e) {
				int prevVal = resourcesVal;
				int newVal = jSlider2.getValue();
				if (newVal - prevVal > pointPool){
					jSlider2.setValue(prevVal + pointPool);
					newVal = jSlider2.getValue();
				}
				pointPool -= newVal - prevVal;
                jSpinner2.setValue(jSlider2.getValue());
                resourcesVal = jSlider2.getValue();
                jTextField1.setText("Points left: " + String.valueOf(pointPool));
                System.out.println("Resources: " + resourcesVal);
                System.out.println("Points: " + pointPool);
			}
		});
		jSlider2.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSlider2.setBackground(Color.WHITE);
		sliders.add(jSlider2);
		
		jSlider3.setMajorTickSpacing(10);
		jSlider3.setMinorTickSpacing(1);
		jSlider3.setSnapToTicks(true);
		jSlider3.setPaintLabels(true);
		jSlider3.setPaintTicks(true);
		jSlider3.addChangeListener(new ChangeListener() {
			/* (non-Javadoc)
			 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
			 */
			public void stateChanged(ChangeEvent e) {
				int prevVal = politicsVal;
				int newVal = jSlider3.getValue();
				if (newVal - prevVal > pointPool){
					jSlider3.setValue(prevVal + pointPool);
					newVal = jSlider3.getValue();
				}
				pointPool -= newVal - prevVal;
                jSpinner3.setValue(jSlider3.getValue());
                politicsVal = jSlider3.getValue();
                jTextField1.setText("Points left: " + String.valueOf(pointPool));
                System.out.println("Politics: " + politicsVal);
                System.out.println("Points: " + pointPool);
			}
		});
		jSlider3.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSlider3.setBackground(Color.WHITE);
		sliders.add(jSlider3);
		
		jSlider4.setMajorTickSpacing(10);
		jSlider4.setMinorTickSpacing(1);
		jSlider4.setSnapToTicks(true);
		jSlider4.setPaintLabels(true);
		jSlider4.setPaintTicks(true);
		jSlider4.addChangeListener(new ChangeListener() {
			/* (non-Javadoc)
			 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
			 */
			public void stateChanged(ChangeEvent e) {
				int prevVal = expansionVal;
				int newVal = jSlider4.getValue();
				if (newVal - prevVal > pointPool){
					jSlider4.setValue(prevVal + pointPool);
					newVal = jSlider4.getValue();
				}
				pointPool -= newVal - prevVal;
                jSpinner4.setValue(jSlider4.getValue());
                expansionVal = jSlider4.getValue();
                jTextField1.setText("Points left: " + String.valueOf(pointPool));
                System.out.println("Expansion: " + expansionVal);
                System.out.println("Points: " + pointPool);
			}
		});
		jSlider4.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSlider4.setBackground(Color.WHITE);
		sliders.add(jSlider4);
		
		jSlider5.setMajorTickSpacing(10);
		jSlider5.setMinorTickSpacing(1);
		jSlider5.setSnapToTicks(true);
		jSlider5.setPaintLabels(true);
		jSlider5.setPaintTicks(true);
		jSlider5.addChangeListener(new ChangeListener() {
			/* (non-Javadoc)
			 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
			 */
			public void stateChanged(ChangeEvent e) {
				int prevVal = militaryVal;
				int newVal = jSlider5.getValue();
				if (newVal - prevVal > pointPool){
					jSlider5.setValue(prevVal + pointPool);
					newVal = jSlider5.getValue();
				}
				pointPool -= newVal - prevVal;
                jSpinner5.setValue(jSlider5.getValue());
                militaryVal = jSlider5.getValue();
                jTextField1.setText("Points left: " + String.valueOf(pointPool));
                System.out.println("Military: " + militaryVal);
                System.out.println("Points: " + pointPool);
			}
		});
		jSlider5.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSlider5.setBackground(Color.WHITE);
		sliders.add(jSlider5);
		
		//add panels to frame
		cp.add(header, BorderLayout.NORTH);
		cp.add(labels, BorderLayout.WEST); 
		cp.add(footer, BorderLayout.SOUTH);
		cp.add(spinners, BorderLayout.EAST);
		cp.add(sliders, BorderLayout.CENTER);
		
		
		labels.setBackground(new Color(0xFFC800));
		spinners.setBackground(new Color(0xFFC800));
		sliders.setBackground(new Color(0xFFC800));

		setVisible(true);
	}

	/**
	 * Closes the menu
	 */
	public void closeMenu() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

}
