package ca.proj.game.menus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AttributeMenu extends JFrame {
	
	//initialize components
	private JLabel jLabel1 = new JLabel("Wealth", JLabel.CENTER);
	private JLabel jLabel2 = new JLabel("Resources", JLabel.CENTER);
	private JLabel jLabel3 = new JLabel("Politics", JLabel.CENTER);
	private JLabel jLabel4 = new JLabel("Expansion", JLabel.CENTER);
	private JLabel jLabel5 = new JLabel("Military", JLabel.CENTER);
	private JLabel jLabel6 = new JLabel("Distribute your happiness points", JLabel.CENTER);
	private JButton jButton1 = new JButton("Roll");
	private JButton jButton2 = new JButton("Ok");
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
		cp.setLayout(new BorderLayout());
		
		//initialize panels
		final int VERT_SPACE = 50; 
		JPanel labels = new JPanel(new GridLayout(5, 1, 0, VERT_SPACE));
		JPanel buttons = new JPanel(new GridLayout(1, 3));
		JPanel numbers = new JPanel(new GridLayout(5, 1, 0, VERT_SPACE));
		JPanel sliders = new JPanel(new GridLayout(5, 1, 0, VERT_SPACE));
		
		//modify and add components to panels
		labels.add(jLabel1);
		labels.add(jLabel2);
		labels.add(jLabel3);
		labels.add(jLabel4);
		labels.add(jLabel5);
		
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//randomly distribute the 50 spare points
				System.out.println("\"Roll\" pressed");
			}
		});
		jButton1.setBackground(Color.WHITE);
		jButton1.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		buttons.add(jButton1);
		
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//send out the values and close the window
				System.out.println("\"Ok\" pressed");
			}
		});
		jButton2.setBackground(Color.WHITE);
		jButton2.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		buttons.add(jButton2);
		
		jSlider1.setMajorTickSpacing(10); //modify components
		jSlider1.setMinorTickSpacing(1);
		jSlider1.setSnapToTicks(true);
		jSlider1.setPaintLabels(true);
		jSlider1.setPaintTicks(true);
		jSlider1.setEnabled(true);
		jSlider1.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSlider1.setBackground(Color.WHITE);
		jSlider1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//do some shit
				System.out.println("Wealth: " + jSlider1.getValue());
			}
		});
		sliders.add(jSlider1);
		
		jSlider2.setMajorTickSpacing(10);
		jSlider2.setMinorTickSpacing(1);
		jSlider2.setSnapToTicks(true);
		jSlider2.setPaintLabels(true);
		jSlider2.setPaintTicks(true);
		jSlider2.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSlider2.setBackground(Color.WHITE);
		jSlider2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//do some shit
				System.out.println("Resources: " + jSlider2.getValue());
			}
		});
		sliders.add(jSlider2);
		
		jSlider3.setMajorTickSpacing(10);
		jSlider3.setMinorTickSpacing(1);
		jSlider3.setSnapToTicks(true);
		jSlider3.setPaintLabels(true);
		jSlider3.setPaintTicks(true);
		jSlider3.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSlider3.setBackground(Color.WHITE);
		jSlider3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//do some shit
				System.out.println("Politics: " + jSlider3.getValue());
			}
		});
		sliders.add(jSlider3);
		
		jSlider4.setMajorTickSpacing(10);
		jSlider4.setMinorTickSpacing(1);
		jSlider4.setSnapToTicks(true);
		jSlider4.setPaintLabels(true);
		jSlider4.setPaintTicks(true);
		jSlider4.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSlider4.setBackground(Color.WHITE);
		jSlider4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//do some shit
				System.out.println("Expansion: " + jSlider4.getValue());
			}
		});
		sliders.add(jSlider4);
		
		jSlider5.setMajorTickSpacing(10);
		jSlider5.setMinorTickSpacing(1);
		jSlider5.setSnapToTicks(true);
		jSlider5.setPaintLabels(true);
		jSlider5.setPaintTicks(true);
		jSlider5.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		jSlider5.setBackground(Color.WHITE);
		jSlider5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//do some shit
				System.out.println("Military: " + jSlider5.getValue());
			}
		});
		sliders.add(jSlider5);
		
		jSpinner1.setBackground(Color.WHITE);
		jSpinner1.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		numbers.add(jSpinner1);
		
		jSpinner2.setBackground(Color.WHITE);
		jSpinner2.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		numbers.add(jSpinner2);
		
		jSpinner3.setBackground(Color.WHITE);
		jSpinner3.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		numbers.add(jSpinner3);
		
		jSpinner4.setBackground(Color.WHITE);
		jSpinner4.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		numbers.add(jSpinner4);
		
		jSpinner5.setBackground(Color.WHITE);
		jSpinner5.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		numbers.add(jSpinner5);
		
		cp.add(labels, BorderLayout.WEST); //add panels to container
		cp.add(buttons, BorderLayout.SOUTH);
		cp.add(numbers, BorderLayout.EAST);
		cp.add(sliders, BorderLayout.CENTER);
		
		labels.setBackground(new Color(0xFFC800));
		numbers.setBackground(new Color(0xFFC800));
		sliders.setBackground(new Color(0xFFC800));

		setVisible(true);
	}

	public void closeMenu() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	public static void main(String[] args) {
		new AttributeMenu("Attribute Menu");
	}

}
