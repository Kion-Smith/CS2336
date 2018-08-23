package Engine;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import GameStates.GameStateManager;

public class GamePanel extends JPanel implements Runnable,KeyListener
{
	public static final int WIDTH = 448;
	public static final int HEIGHT= 512;
	
	public int FPS = 60;
	private long targetTime = 1000/FPS;
	
	public boolean isRunning;
	
	private Thread thread;
	
	private BufferedImage image;
	private Graphics2D g;
	
	
	private GameStateManager gsm;
	
	public GamePanel()
	{
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify()
	{
		super.addNotify();
		thread = new Thread(this);
		addKeyListener(this);
		thread.start();
	}
	
	public void run()
	{
		init();
		
		long start;
		long wait;
		long elap;
		
		
		while(isRunning)
		{
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elap = System.nanoTime() - start;
			wait = targetTime - elap / 10000000;
			
			try
			{
				Thread.sleep(wait);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void init()
	{
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
		isRunning = true;
		
		gsm = new GameStateManager();
	}
	
	private void update()
	{
		gsm.update();
	}
	private void draw()
	{
		gsm.draw(g);
	}
	private void drawToScreen()
	{
		Graphics g2 = getGraphics();
		g2.drawImage(image,0,0, WIDTH,HEIGHT,null);
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent key)
	{
	
	}
	public void keyPressed(KeyEvent key)
	{
		gsm.keyPressed(key.getKeyCode());
	}
	public void keyReleased(KeyEvent key)
	{
		gsm.keyReleased(key.getKeyCode());
	}
}
