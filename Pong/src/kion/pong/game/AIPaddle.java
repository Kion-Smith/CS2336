//package kion.pong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AIPaddle
{

	int x;
	 int y;

	 int width=15;
	 int height =40;

	 int speed =2;

	 boolean goingUp = false;
	 boolean goingDown = false;

	 Rectangle boundingBox;

	 public AIPaddle(int x,int y)
	 {
		 this.x = x;
	     this.y = y;
	     boundingBox = new Rectangle(x,y,width,height);
	     boundingBox.setBounds(x,y,width,height);
	 }

	 public void tick(Game game)
	 {
	 boundingBox.setBounds(x,y,width,height);
		if(game.ball.y<y+height && y >=0)
		{
			y-=speed;
		}
		else if(game.ball.y>y && y+ height <=game.getHeight())
		{
			y+=speed;
		}

	 }
	 public void render(Graphics g)
	 {
		 g.setColor(Color.WHITE);
		 g.fillRect(x,y,width,height);

	 }
}
