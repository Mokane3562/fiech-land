package ca.proj.game.menus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
	private JLabel jLabelWealth = new JLabel("Wealth", JLabel.CENTER);
	private JLabel jLabelResources = new JLabel("Resources", JLabel.CENTER);
	private JLabel jLabelPolitics = new JLabel("Politics", JLabel.CENTER);
	private JLabel jLabelSolitude = new JLabel("Solitude", JLabel.CENTER);
	private JLabel jLabelMilitary = new JLabel("Military", JLabel.CENTER);
	private JButton jButtonReset = new JButton("Reset");
	private JButton jButtonOk = new JButton("Ok");
	private JTextField jTextFieldPointPool = new JTextField();
	private JSlider jSliderWealth = new JSlider(10, 60, 10);
	private JSlider jSliderResources = new JSlider(10, 60, 10);
	private JSlider jSliderPolitics = new JSlider(10, 60, 10);
	private JSlider jSliderExpansion = new JSlider(10, 60, 10);
	private JSlider jSliderMilitary = new JSlider(10, 60, 10);
	private JSpinner jSpinnerWealth = new JSpinner();
	private JSpinner jSpinnerResources = new JSpinner();
	private JSpinner jSpinnerPolitics = new JSpinner();
	private JSpinner jSpinnerExpansion = new JSpinner();
	private JSpinner jSpinnerMilitary = new JSpinner();
	
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
	 * Creates a new attribute menu frame.
	 * 
	 * @param title the title of the frame
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
		labels.add(jLabelWealth);
		labels.add(jLabelResources);
		labels.add(jLabelPolitics);
		labels.add(jLabelSolitude);
		labels.add(jLabelMilitary);
		
		//prepare footer panel
		jButtonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jSliderWealth.setValue(10);
				jSliderResources.setValue(10);
				jSliderPolitics.setValue(10);
				jSliderExpansion.setValue(10);
				jSliderMilitary.setValue(10);
			}
		});
		jButtonReset.setBackground(Color.WHITE);
		jButtonReset.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		footer.add(jButtonReset);
		
		jTextFieldPointPool.setText("Points left: " + String.valueOf(pointPool));
		jTextFieldPointPool.setEditable(false);
		jTextFieldPointPool.setBackground(Color.WHITE);
		jTextFieldPointPool.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		footer.add(jTextFieldPointPool);
		
		jButtonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Player.setWealth(wealthVal);
				Player.setResources(resourcesVal);
				Player.setMilitary(militaryVal);
				Player.setSolitude(expansionVal);
				Player.setPolitics(politicsVal);
				closeMenu();
			}
		});
		jButtonOk.setBackground(Color.WHITE);
		jButtonOk.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		footer.add(jButtonOk);
		
		//prepare spinners panel
		jSpinnerWealth.setModel(new SpinnerNumberModel(10, 10, 60, 1));
		jSpinnerWealth.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jSliderWealth.setValue((Integer) jSpinnerWealth.getValue());
			}
		});
		jSpinnerWealth.setBackground(Color.WHITE);
		jSpinnerWealth.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		spinners.add(jSpinnerWealth);
		
		jSpinnerResources.setModel(new SpinnerNumberModel(10, 10, 60, 1));
		jSpinnerResources.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jSliderResources.setValue((Integer) jSpinnerResources.getValue());
			}
		});
		jSpinnerResources.setBackground(Color.WHITE);
		jSpinnerResources.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		spinners.add(jSpinnerResources);
		
		jSpinnerPolitics.setModel(new SpinnerNumberModel(10, 10, 60, 1));
		jSpinnerPolitics.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jSliderPolitics.setValue((Integer) jSpinnerPolitics.getValue());
			}
		});
		jSpinnerPolitics.setBackground(Color.WHITE);
		jSpinnerPolitics.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		spinners.add(jSpinnerPolitics);
		
		jSpinnerExpansion.setModel(new SpinnerNumberModel(10, 10, 60, 1));
		jSpinnerExpansion.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jSliderExpansion.setValue((Integer) jSpinnerExpansion.getValue());
			}
		});
		jSpinnerExpansion.setBackground(Color.WHITE);
		jSpinnerExpansion.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		spinners.add(jSpinnerExpansion);
		
		jSpinnerMilitary.setModel(new SpinnerNumberModel(10, 10, 60, 1));
		jSpinnerMilitary.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jSliderMilitary.setValue((Integer) jSpinnerMilitary.getValue());
			}
		});
		jSpinnerMilitary.setBackground(Color.WHITE);
		jSpinnerMilitary.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		spinners.add(jSpinnerMilitary);
		
		//prepare sliders panel
		jSliderWealth.setMajorTickSpacing(10);
		jSliderWealth.setMinorTickSpacing(1);
		jSliderWealth.setSnapToTicks(true);
		jSliderWealth.setPaintLabels(true);
		jSliderWealth.setPaintTicks(true);
		jSliderWealth.setEnabled(true);
		jSliderWealth.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int prevVal = wealthVal;
				int newVal = jSliderWealth.getValue();
				if (newVal - prevVal > pointPool){
					jSliderWealth.setValue(prevVal + pointPool);
					newVal = jSliderWealth.getValue();
				}
				pointPool -= newVal - prevVal;
                jSpinnerWealth.setValue(jSliderWealth.getValue());
                wealthVal = jSliderWealth.getValue();
                jTextFieldPointPool.setText("Points left: " + String.valueOf(pointPool));
                System.out.println("Wealth: " + wealthVal);
                System.out.println("Points: " + pointPool);
			}
		});
		jSliderWealth.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSliderWealth.setBackground(Color.WHITE);
		sliders.add(jSliderWealth);
		
		jSliderResources.setMajorTickSpacing(10);
		jSliderResources.setMinorTickSpacing(1);
		jSliderResources.setSnapToTicks(true);
		jSliderResources.setPaintLabels(true);
		jSliderResources.setPaintTicks(true);
		jSliderResources.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int prevVal = resourcesVal;
				int newVal = jSliderResources.getValue();
				if (newVal - prevVal > pointPool){
					jSliderResources.setValue(prevVal + pointPool);
					newVal = jSliderResources.getValue();
				}
				pointPool -= newVal - prevVal;
                jSpinnerResources.setValue(jSliderResources.getValue());
                resourcesVal = jSliderResources.getValue();
                jTextFieldPointPool.setText("Points left: " + String.valueOf(pointPool));
                System.out.println("Resources: " + resourcesVal);
                System.out.println("Points: " + pointPool);
			}
		});
		jSliderResources.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSliderResources.setBackground(Color.WHITE);
		sliders.add(jSliderResources);
		
		jSliderPolitics.setMajorTickSpacing(10);
		jSliderPolitics.setMinorTickSpacing(1);
		jSliderPolitics.setSnapToTicks(true);
		jSliderPolitics.setPaintLabels(true);
		jSliderPolitics.setPaintTicks(true);
		jSliderPolitics.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int prevVal = politicsVal;
				int newVal = jSliderPolitics.getValue();
				if (newVal - prevVal > pointPool){
					jSliderPolitics.setValue(prevVal + pointPool);
					newVal = jSliderPolitics.getValue();
				}
				pointPool -= newVal - prevVal;
                jSpinnerPolitics.setValue(jSliderPolitics.getValue());
                politicsVal = jSliderPolitics.getValue();
                jTextFieldPointPool.setText("Points left: " + String.valueOf(pointPool));
                System.out.println("Politics: " + politicsVal);
                System.out.println("Points: " + pointPool);
			}
		});
		jSliderPolitics.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSliderPolitics.setBackground(Color.WHITE);
		sliders.add(jSliderPolitics);
		
		jSliderExpansion.setMajorTickSpacing(10);
		jSliderExpansion.setMinorTickSpacing(1);
		jSliderExpansion.setSnapToTicks(true);
		jSliderExpansion.setPaintLabels(true);
		jSliderExpansion.setPaintTicks(true);
		jSliderExpansion.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int prevVal = expansionVal;
				int newVal = jSliderExpansion.getValue();
				if (newVal - prevVal > pointPool){
					jSliderExpansion.setValue(prevVal + pointPool);
					newVal = jSliderExpansion.getValue();
				}
				pointPool -= newVal - prevVal;
                jSpinnerExpansion.setValue(jSliderExpansion.getValue());
                expansionVal = jSliderExpansion.getValue();
                jTextFieldPointPool.setText("Points left: " + String.valueOf(pointPool));
                System.out.println("Expansion: " + expansionVal);
                System.out.println("Points: " + pointPool);
			}
		});
		jSliderExpansion.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSliderExpansion.setBackground(Color.WHITE);
		sliders.add(jSliderExpansion);
		
		jSliderMilitary.setMajorTickSpacing(10);
		jSliderMilitary.setMinorTickSpacing(1);
		jSliderMilitary.setSnapToTicks(true);
		jSliderMilitary.setPaintLabels(true);
		jSliderMilitary.setPaintTicks(true);
		jSliderMilitary.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int prevVal = militaryVal;
				int newVal = jSliderMilitary.getValue();
				if (newVal - prevVal > pointPool){
					jSliderMilitary.setValue(prevVal + pointPool);
					newVal = jSliderMilitary.getValue();
				}
				pointPool -= newVal - prevVal;
                jSpinnerMilitary.setValue(jSliderMilitary.getValue());
                militaryVal = jSliderMilitary.getValue();
                jTextFieldPointPool.setText("Points left: " + String.valueOf(pointPool));
                System.out.println("Military: " + militaryVal);
                System.out.println("Points: " + pointPool);
			}
		});
		jSliderMilitary.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSliderMilitary.setBackground(Color.WHITE);
		sliders.add(jSliderMilitary);
		
		//add panels to frame
		cp.add(header, BorderLayout.NORTH);
		cp.add(labels, BorderLayout.WEST); 
		cp.add(footer, BorderLayout.SOUTH);
		cp.add(spinners, BorderLayout.EAST);
		cp.add(sliders, BorderLayout.CENTER);
		
		for (Component j : cp.getComponents() ){
			if (j instanceof JButton){
				j.setFont(new Font("Sans", Font.BOLD, 14));
			}
			
		}
		labels.setBackground(new Color(0x3399FF));
		spinners.setBackground(new Color(0x3399FF));
		sliders.setBackground(new Color(0x3399FF));

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
