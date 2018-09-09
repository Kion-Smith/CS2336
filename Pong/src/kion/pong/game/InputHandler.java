//package kion.pong.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
	public InputHandler(Game game)
	{
		game.addKeyListener(this);

	}

	public void keyPressed(KeyEvent e)
	{

		// Makes go up or down
		int KeyCode = e.getKeyCode();
		if(KeyCode == e.VK_W ||KeyCode == e.VK_UP)
		{
			Game.player.goingUp = true;

		}
		if(KeyCode == e.VK_S||KeyCode == e.VK_DOWN)
		{

			Game.player.goingDown = true;
		}

	}

	public void keyReleased(KeyEvent e)
	{
		//
		int KeyCode = e.getKeyCode();
		if(KeyCode == e.VK_W||KeyCode == e.VK_UP)
		{

			Game.player.goingUp = false;
		}
		if(KeyCode == e.VK_S||KeyCode == e.VK_DOWN)
		{
			Game.player.goingDown = false;

		}
	}

	public void keyTyped(KeyEvent e) {
		//

	}

}
