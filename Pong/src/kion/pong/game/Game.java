//package kion.pong.game;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Game extends Canvas implements Runnable // canvas is like jpanel
{
	private static final long serialVersionUID = 1L;//

	public static PlayerPaddle player;
	public static AIPaddle ai;
	public static Ball ball;
	int pScore,aScore;
	InputHandler IH;


	JFrame frame;

	//Game Dimensions
	public final int WIDTH = 400;
	public final int HEIGHT = WIDTH /16*9;
	public final Dimension gameSize = new Dimension(WIDTH,HEIGHT);
	public final String TITLE = "Pong Kion Edition";

	//public static enum STATE{GAME,MENU};
	//public static STATE State= STATE.MENU;
//	private MainMenu menu;

	BufferedImage image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);

	static boolean gameRunning = false;

	public void run()/// needs to be added when using runnable, runnable lets the game use a thread(Procces)
	{
		while (gameRunning)
		{
			tick();
			render();

			try
			{
				Thread.sleep(5);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

	public synchronized void start()
	{
		gameRunning = true;
		new Thread(this).start();//Starts the game in a new thread so that it can run
	}
	public static synchronized void stop()
	{
		gameRunning = false;
		System.exit(0);
	}


	public Game()
	{
		frame = new JFrame();

		setMinimumSize(gameSize);//refrenceing game class so would be just like doing this.setMinimumSize
		setPreferredSize(gameSize);
		setMaximumSize(gameSize);

		frame.add(this,BorderLayout.CENTER);
		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle(TITLE);
		frame.setLocationRelativeTo(null);

	//	gameRunning = true;

		//if(State == STATE.GAME)
		//{
		 IH = new InputHandler(this);

		player = new PlayerPaddle(10,60);

		ai = new AIPaddle(getWidth()-25,getHeight()-150);
		 ball = new Ball(getWidth()/2,getHeight()/2);


		frame.addKeyListener(IH);
	//	}

	//	menu = new MainMenu();

	}

	public void tick()
	{
		//if(State == STATE.GAME)
		//{
		player.tick(this);//Game, game
		ai.tick(this);
		ball.tick(this);
		//}

	}
	public void render()
	{

		BufferStrategy bs =  getBufferStrategy();

		if(bs ==null)
		{
			 createBufferStrategy(7);
			 return;

		}
		Graphics g = bs.getDrawGraphics();




		g.drawImage(image,0,0,getWidth(), getHeight(), null);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	//	if(State == STATE.GAME)
		//{
		g.setColor(Color.WHITE);
		g.fillRect(190, 0, 10, 1000);

		player.render(g);
		ai.render(g);
		ball.render(g);

		g.drawString(""+pScore, 150,50);
		g.drawString(""+aScore, 230,50);

		//g.setColor(Color.ORANGE);
		//g.fillRect(0, 0, getWidth(), getHeight());
	//	}

		//if(State == STATE.MENU)
		//{
			//menu.render(g);
		//}
		g.dispose();
		bs.show();



	}





	public static void main(String [] args)
	{
		Game game =new Game();
		game.start();

	}



}
