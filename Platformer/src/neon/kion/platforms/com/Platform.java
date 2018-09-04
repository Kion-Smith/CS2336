//package neon.kion.platforms.com;

import java.awt.Color;
import java.awt.Graphics;

public class Platform
{

	public static boolean isPlatform;

	public Platform(Game game)
	{

	}
	public void render(Graphics g)
	{

		g.setColor(Color.black);
		g.fillRect(200,500,100,40);
	}
	public void update()
	{
		//For moving platforms
	}
}
