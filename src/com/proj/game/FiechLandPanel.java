package com.proj.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class FiechLandPanel extends JPanel implements Runnable {

	  private static final int PWIDTH = 800;   // size of panel
	  private static final int PHEIGHT = 400; 

	  private static final int NO_DELAYS_PER_YIELD = 16;
	  /* Number of frames with a delay of 0 ms before the animation thread yields
	     to other running threads. */
	  private static final int MAX_FRAME_SKIPS = 5;
	    // no. of frames that can be skipped in any one animation loop
	    // i.e the games state is updated but not rendered

	  // light blue for the background
	  private static final Color lightBlue = new Color(0.17f, 0.87f, 1.0f);

	  private Thread animator;           // the thread that performs the animation
	  private volatile boolean running = false;   // used to stop the animation thread
	  private volatile boolean isPaused = false;

	  private long period;                // period between drawing in _nanosecs_


	  private FiechLand fiechLand;

	  private long gameStartTime;   // when the game started
	  private int timeSpentInGame;

	  // used at game termination
	  private volatile boolean gameOver = false;
	  private int score = 0;

	  // for displaying messages
	  private Font msgsFont;
	  private FontMetrics metrics;

	  // off-screen rendering
	  private Graphics dbg; 
	  private Image dbImage = null;

	  // to display the title/help screen
	  private boolean showHelp;
	  private BufferedImage helpIm;


	  public FiechLandPanel(FiechLand fiechLand, long period) {
		// TODO Auto-generated constructor stub
	    this.fiechLand = fiechLand;
	    this.period = period;

	    setDoubleBuffered(false);
	    setBackground(Color.black);
	    setPreferredSize( new Dimension(PWIDTH, PHEIGHT));

	    setFocusable(true);
	    requestFocus();    // the JPanel now has focus, so receives key events

		addKeyListener( new KeyAdapter() {
	       public void keyPressed(KeyEvent e)
	       { processKey(e);  }
	     });
	  }  // end of FiechLandPanel()


	  private void processKey(KeyEvent e)
	  // handles termination, help, and game-play keys
	  {
	    int keyCode = e.getKeyCode();

	    // termination keys
		// listen for esc, q, end, ctrl-c on the canvas to
		// allow a convenient exit from the full screen configuration
	    if ((keyCode == KeyEvent.VK_ESCAPE) || (keyCode == KeyEvent.VK_Q) ||
	        (keyCode == KeyEvent.VK_END) ||
	        ((keyCode == KeyEvent.VK_C) && e.isControlDown()) )
	      running = false;

	  }  // end of processKey()


	  public void gameOver()
	  /* PlayerSprite or WorldDisplay can call gameOver(). PlayerSprite
	     calls it when it has been hit by aliens enough times. 
	     WorldDisplay calls it when all the pickups have been picked up.
	  */
	  { 
	    if (!gameOver) {
	      gameOver = true; 
	      score = (int) ((System.nanoTime() - gameStartTime)/1000000000L);
	    }
	  } // end of gameOver()



	  public void addNotify()
	  // wait for the JPanel to be added to the JFrame before starting
	  { super.addNotify();   // creates the peer
	    startGame();         // start the thread
	  }


	  private void startGame()
	  // initialise and start the thread 
	  { 
	    if (animator == null || !running) {
	      animator = new Thread(this);
		  animator.start();
	    }
	  } // end of startGame()
	    

	  // ------------- game life cycle methods ------------
	  // called by the JFrame's window listener methods


	  public void resumeGame()
	  // called when the JFrame is activated / deiconified
	  { if (!showHelp)
	      isPaused = false;  
	  } 


	  public void pauseGame()
	  // called when the JFrame is deactivated / iconified
	  { isPaused = true;   } 


	  public void stopGame() 
	  // called when the JFrame is closing
	  {  running = false;   }

	  // ----------------------------------------------

	  public void run()
	  /* The frames of the animation are drawn inside the while loop. */
	  {
	    long beforeTime, afterTime, timeDiff, sleepTime;
	    long overSleepTime = 0L;
	    int noDelays = 0;
	    long excess = 0L;

	    gameStartTime = System.nanoTime();
	    beforeTime = gameStartTime;

		running = true;

		while(running) {
		  gameUpdate();
	      gameRender();
	      paintScreen();

	      afterTime = System.nanoTime();
	      timeDiff = afterTime - beforeTime;
	      sleepTime = (period - timeDiff) - overSleepTime;  

	      if (sleepTime > 0) {   // some time left in this cycle
	        try {
	          Thread.sleep(sleepTime/1000000L);  // nano -> ms
	        }
	        catch(InterruptedException ex){}
	        overSleepTime = (System.nanoTime() - afterTime) - sleepTime;
	      }
	      else {    // sleepTime <= 0; the frame took longer than the period
	        excess -= sleepTime;  // store excess time value
	        overSleepTime = 0L;

	        if (++noDelays >= NO_DELAYS_PER_YIELD) {
	          Thread.yield();   // give another thread a chance to run
	          noDelays = 0;
	        }
	      }

	      beforeTime = System.nanoTime();

	      /* If frame animation is taking too long, update the game state
	         without rendering it, to get the updates/sec nearer to
	         the required FPS. */
	      int skips = 0;
	      while((excess > period) && (skips < MAX_FRAME_SKIPS)) {
	        excess -= period;
		    gameUpdate();    // update state but don't render
	        skips++;
	      }
		}
	    System.exit(0);   // so window disappears
	  } // end of run()


	  private void gameUpdate() 
	  { 
	    if (!isPaused && !gameOver) {
	    } 
	  }  // end of gameUpdate()


	  private void gameRender()
	  {
	    if (dbImage == null){
	      dbImage = createImage(PWIDTH, PHEIGHT);
	      if (dbImage == null) {
	        System.out.println("dbImage is null");
	        return;
	      }
	      else
	        dbg = dbImage.getGraphics();
	    }

	    // a light blue background
	    dbg.setColor(lightBlue);
	    dbg.fillRect(0, 0, PWIDTH, PHEIGHT);

	    reportStats(dbg);

	    if (gameOver)
	      gameOverMessage(dbg);

	    if (showHelp)    // draw the help at the very front (if switched on)
	      dbg.drawImage(helpIm, (PWIDTH-helpIm.getWidth())/2, 
	                          (PHEIGHT-helpIm.getHeight())/2, null);
	  }  // end of gameRender()


	  private void reportStats(Graphics g)
	  // Report time spent playing, the number of hits, pickups left
	  {
	    if (!gameOver)    // stop incrementing the timer once the game is over
	      timeSpentInGame = 
	          (int) ((System.nanoTime() - gameStartTime)/1000000000L);  // ns --> secs
		g.setColor(Color.red);
	    g.setFont(msgsFont);
		g.drawString("Time: " + timeSpentInGame + " secs", 15, 25);
		g.setColor(Color.black);
	  }  // end of reportStats()



	  private void paintScreen()
	  // use active rendering to put the buffered image on-screen
	  { 
	    Graphics g;
	    try {
	      g = this.getGraphics();
	      if ((g != null) && (dbImage != null))
	        g.drawImage(dbImage, 0, 0, null);
	      // Sync the display on some systems.
	      // (on Linux, this fixes event queue problems)
	      Toolkit.getDefaultToolkit().sync();
	      g.dispose();
	    }
	    catch (Exception e)
	    { System.out.println("Graphics context error: " + e);  }
	  } // end of paintScreen()

}