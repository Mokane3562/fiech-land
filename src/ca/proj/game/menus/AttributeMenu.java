package ca.proj.game.menus;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AttributeMenu extends JFrame {

	private JSlider jSlider1 = new JSlider();
	private JSlider jSlider2 = new JSlider();
	private JSlider jSlider3 = new JSlider();
	private JSlider jSlider4 = new JSlider();
	private JSlider jSlider5 = new JSlider();
	public static boolean running = false;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);

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
		cp.setLayout(null);

		jSlider1.setMinimum(10);
		jSlider1.setMaximum(60);
		jSlider1.setMajorTickSpacing(10);
		jSlider1.setMinorTickSpacing(1);
		jSlider1.setSnapToTicks(true);
		jSlider1.setEnabled(true);
		jSlider1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//do some shit
			}
		});
		cp.add(jSlider1);
		
		jSlider2.setMinimum(10);
		jSlider2.setMaximum(60);
		jSlider2.setMajorTickSpacing(10);
		jSlider2.setMinorTickSpacing(1);
		jSlider2.setSnapToTicks(true);
		jSlider2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//do some shit
			}
		});
		cp.add(jSlider2);
		
		jSlider3.setMinimum(10);
		jSlider3.setMaximum(60);
		jSlider3.setMajorTickSpacing(10);
		jSlider3.setMinorTickSpacing(1);
		jSlider3.setSnapToTicks(true);
		jSlider3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//do some shit
			}
		});
		cp.add(jSlider3);
		
		jSlider4.setMinimum(10);
		jSlider4.setMaximum(60);
		jSlider4.setMajorTickSpacing(10);
		jSlider4.setMinorTickSpacing(1);
		jSlider4.setSnapToTicks(true);
		jSlider4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//do some shit
			}
		});
		cp.add(jSlider4);
		
		jSlider5.setMinimum(10);
		jSlider5.setMaximum(60);
		jSlider5.setMajorTickSpacing(10);
		jSlider5.setMinorTickSpacing(1);
		jSlider5.setSnapToTicks(true);
		jSlider5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//do some shit
			}
		});
		cp.add(jSlider5);
	    
		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
	}

	public void closeMenu() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	public static void main(String[] args) {
		new AttributeMenu("Menu");
	}

}
