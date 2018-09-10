package kion.space.game.com;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.geom.*;
import java.awt.image.*;
import java.applet.*;
import java.util.*;


public class Asteroids extends BaseVectorShape implements Runnable, KeyListener
{

	Thread gameloop;
	BufferedImage backbuffer;
	Graphics2D g2d;
	
	boolean showBounds = false;
	
	int ASTEROIDS =20;
	Asteroid[] ast = new Asteroid[ASTEROIDS];
	
	int BULLETS = 10;
	Bullet[] bullet = new Bullet[BULLETS];
	int currentBullet = 0;
	
	Ship ship = new Ship();
	
	AffineTransform identity = new AffineTransform();
	
	Random rand  = new Random();
	
	/////////The Applet/////////////////////
	
	public void init()
	{
		backbuffer = new BufferedImage(640,480,BufferedImage.TYPE_INT_RGB);
		g2d = backbuffer.createGraphics();
	
		////Ship//////////////
		ship.setX(320);
		ship.setY(240);
		
		//Bullets////////////
		
		for(int n = 0;n < BULLETS;n++)
		{
			bullet[n]=new Bullet();
		}
		
		//Asteroids///////////
		
		for (int n = 0;n < ASTEROIDS;n++)
		{
			ast[n]= new Asteroid();
			ast[n].setRotationVelocity(rand.nextInt(3)+1);
			ast[n].setX((double)rand.nextInt(600)+20);
			ast[n].setY((double)rand.nextInt(440)+20);
			ast[n].setMoveAngle(rand.nextInt(360));
			double ang = ast[n].getMoveAngle() -90;
			ast[n].setVelX(calcAngleMoveX(ang));
			ast[n].setVelY(calcAngleMoveY(ang));
		}
			
		addKeyListener(this);
		}
		
	}

