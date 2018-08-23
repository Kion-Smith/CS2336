package Entity;

import TileMap.TileMap;

import java.util.*;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends MapObject 
{
	
	private int lives;
	private boolean form;
	private boolean dead;
	
	private ArrayList<BufferedImage[]> sprites;
	private final int[] numFrames = {1,2};
	
	private static final int IDLE =0;
	private static final int WALKING =1;//add death
	
	
	public Player(TileMap tm) 
	{
		super(tm);
		
		width = 30;
		height = 30;
		cwidth = 20;
		cheight = 20;
		
		moveSpeed = .3;
		maxSpeed= 1.6;
		stopSpeed = .4;
		
		try
		{
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/playersprites.gif"));
			
			sprites = new ArrayList<BufferedImage[]>();
			
			for(int i =0;i<2;i++)//!!
			{
				BufferedImage[] bi = new BufferedImage[numFrames[i]];
				
				for(int j =0;j<numFrames[i];j++)
				{
					bi[j] = spritesheet.getSubimage(j*width,i*height,width,height);
				}
				
				sprites.add(bi);
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		animation = new Animation();
		currentAction = IDLE;
		animation.setFrames(sprites.get(IDLE));
		animation.setDelay(400);
	}
	
	public int getLives()
	{
		return lives;
	}
	public boolean getForm()
	{
		return form;
	}
	
	
	private void getNextPostion()
	{
		
		if(left)
		{
			dx -=moveSpeed;
			if(dx < -maxSpeed)
			{
				dx = -maxSpeed;
				xtemp += dx;
			}
		}
		else if(right)
		{
			dx +=moveSpeed;
			if(dx > maxSpeed)
			{
				dx = maxSpeed;
				xtemp += dx;
			}
		}
		//
		else if(down)
		{
			dy +=moveSpeed;
			if(dy > maxSpeed)
			{
				dy = maxSpeed;
				ytemp += dy;
			}
		}
		else if(up)
		{
			dy -=moveSpeed;
			if(dy < -maxSpeed)
			{
				dy = -maxSpeed;
				ytemp += dy;
			}
		}
		///
		else
		{
			if(dx>0)
			{
				dx -=stopSpeed;
				if(dx<0)
				{
					dx=0;
				}
			}
			else if(dx<0)
			{
				dx+=stopSpeed;
				if(dx>0)
				{
					dx=0;
				}
			}
		}
		
		
	}
	
	public void update()
	{
		getNextPostion();
		checkTileMapCollsion();
		setPostion(xtemp,ytemp);
		
		if(left || right || up || down)
		{
			if(currentAction != WALKING)///add death
			{
				currentAction = WALKING;
				animation.setFrames(sprites.get(WALKING));
				animation.setDelay(40);
			}
		}
		else
		{
			if(currentAction != IDLE)
			{
				currentAction = IDLE;
				animation.setFrames(sprites.get(IDLE));
				animation.setDelay(40);
			}
		}
		
		animation.update();

	}
	
	public void draw(Graphics2D g)
	{
		setMapPostion();
		
		if(facingRight)//chage to left later
		{
			g.drawImage(animation.getImage(), (int)(x+xmap - width /2),(int)(y+ymap - height/2),null);
		}
		else
		{
			g.drawImage(animation.getImage(), (int)(x+xmap - width /2+width),(int)(y+ymap - height/2),-width,height,null);
		}
		
	}

}
