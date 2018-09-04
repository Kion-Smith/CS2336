//package neon.kion.platforms.com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable
{
	public static int WIDTH = 400;
	public static int HEIGHT = 600;

	public static boolean isRunning;
	private Thread gThread;

	public static Player p;
	public static Platform plat;

	Inputs i;

	BufferedImage img = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);

	public Game()
	{
		setSize(WIDTH,HEIGHT);
		setTitle("Platforms");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		 p = new Player(100,500);
		 i = new Inputs(this);
		 plat = new Platform(this);

		 addKeyListener(i);

	}

	public synchronized void start()
	{
		isRunning = true;
		Thread gThread =  new Thread(this);
		gThread.start();

	}

	public synchronized void stop()
	{
		isRunning = false;


		System.exit(0);
	}


	public void run()
	{
		while(isRunning = true)
		{
			try
			{
				update();
				render();
				//add updates here
				Thread.sleep(1000/60);

			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	public void render()
	{
		BufferStrategy bs = getBufferStrategy();

		if(bs == null)
		{
			createBufferStrategy(7);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.drawImage(img,0,0,getWidth(),getHeight(),null);
		Graphics g2d = (Graphics2D) g;

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);



		p.render(g);
		plat.render(g);


		g.dispose();
		bs.show();
	}

	public void update()
	{
		//add player and enemy updates here.
		p.update(this);

	}


	public static void main(String [] args)
	{
		Game game = new Game();
		game.start();

	}


}
