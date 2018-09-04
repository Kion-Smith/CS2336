//package neon.kion.platforms.com;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Inputs extends KeyAdapter
{


	public Inputs(Game game)
	{
		game.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();

		if(keyCode == e.VK_UP ||keyCode == e.VK_W )
		{
			Game.p.isUp = true;
		}
		if(keyCode == e.VK_DOWN ||keyCode == e.VK_S )
		{
			Game.p.isDown = true;
		}
		if(keyCode == e.VK_LEFT ||keyCode == e.VK_A )
		{
			Game.p.isLeft = true;
		}
		if(keyCode == e.VK_RIGHT ||keyCode == e.VK_D )
		{
			Game.p.isRight= true;
		}

	}
	public void keyReleased(KeyEvent e)
	{

int keyCode = e.getKeyCode();

		if(keyCode == e.VK_UP ||keyCode == e.VK_W )
		{
			Game.p.isUp = false;
		}
		if(keyCode == e.VK_DOWN ||keyCode == e.VK_S )
		{
			Game.p.isDown = false;
		}
		if(keyCode == e.VK_LEFT ||keyCode == e.VK_A )
		{
			Game.p.isLeft = false;
		}
		if(keyCode == e.VK_RIGHT ||keyCode == e.VK_D )
		{
			Game.p.isRight= false;
		}

	}



}
