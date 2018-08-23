package TileMap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Engine.GamePanel;

public class Background 
{
	private BufferedImage image;
	
	private double x;
	private double y;
	
	public Background(String s)
	{
		try
		{
			image = ImageIO.read(getClass().getResourceAsStream(s));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void setPosition(double curX, double curY)
	{
		x = curX;
		y = curY;
	}
	
	public void update()
	{

	}
	
	public void draw(Graphics2D g)
	{
		g.drawImage(image,(int)x,(int)y,null);
	}
}
