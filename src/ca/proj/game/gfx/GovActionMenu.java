package ca.proj.game.gfx;

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
import javax.swing.WindowConstants;

import ca.proj.game.Game;

public class GovActionMenu extends JFrame {

	private JButton jButton1 = new JButton();
	private JButton jButton2 = new JButton();
	private JButton jButton3 = new JButton();
	private JButton jButton4 = new JButton();
	private JButton jButton5 = new JButton();
	public static boolean enterLevel;
	public static boolean running = false;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);

	public GovActionMenu(String title) {

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

		//Military Action Button
		jButton1.setBounds(168, 80, 305, 57);
		jButton1.setText("Military Action");
		jButton1.setMargin(new Insets(2, 2, 2, 2));
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		jButton1.setBackground(Color.WHITE);
		jButton1.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(jButton1);
		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
		
		//Diplomatic Action Button
		jButton2.setBounds(168, 80, 305, 57);
		jButton2.setText("Diplomatic Action");
		jButton2.setMargin(new Insets(2, 2, 2, 2));
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		jButton2.setBackground(Color.WHITE);
		jButton2.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(jButton2);
		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
		
		//Resource Action Button
		jButton3.setBounds(168, 80, 305, 57);
		jButton3.setText("Resource Action");
		jButton3.setMargin(new Insets(2, 2, 2, 2));
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		jButton3.setBackground(Color.WHITE);
		jButton3.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(jButton3);
		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
		
		//Trade Action Button
		jButton4.setBounds(168, 80, 305, 57);
		jButton4.setText("Trade Action");
		jButton4.setMargin(new Insets(2, 2, 2, 2));
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		jButton4.setBackground(Color.WHITE);
		jButton4.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(jButton4);
		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
		
		//Exit Menu Button
		jButton5.setBounds(168, 80, 305, 57);
		jButton5.setText("Exit Menu");
		jButton5.setMargin(new Insets(2, 2, 2, 2));
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		jButton5.setBackground(Color.WHITE);
		jButton5.setBorder(BorderFactory.createEtchedBorder(0, Color.GREEN,
				Color.BLACK));
		cp.add(jButton5);
		cp.setBackground(new Color(0xFFC800));

		setVisible(true);
	}

	// First Government Action
	public void jButton1_ActionPerformed(ActionEvent evt) { 
			
	}
		
	// Second Government Action
	public void jButton2_ActionPerformed(ActionEvent evt) { 
				
	}
		
	// Third Government Action
	public void jButton3_ActionPerformed(ActionEvent evt) { 
				
	}

	// Fourth Government Action
	public void jButton4_ActionPerformed(ActionEvent evt) { 
				
	}
		
	// Exit Menu Action
	public void jButton5_ActionPerformed(ActionEvent evt) { 
				
	}

	public void closeMenu() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	
}
