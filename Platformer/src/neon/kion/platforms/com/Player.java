//package neon.kion.platforms.com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Player {

	int G = 10;


	 int locx;
	 int locy;

	 int pWidth = 40;
	 int pHeight = 40;
	 int apex = 25 ;




	 boolean isUp,isDown,isRight,isLeft;


	public Player(int locx,int locy)
	{

		this.locx = locx;
		this.locy = locy;
	}
	public void update(Game game)
	{
		move(game);


	}

	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(locx, locy, pWidth, pHeight);
	}
	public void move(Game game)
	{

		int ground = game.getHeight() - pHeight;


		if(isUp == true && locy !=0 + 25 )
		{
			/*
			System.out.println(ground);
				locy -=25;
					while(locy <= ground)
					{
				 		locy +=5;

					}
		*/

		}
		if(isDown== true && locy != game.getHeight() - pHeight)
		{
			locy+=5;
		}
		if( isLeft== true && locx != 0 + 5)
		{
			locx-=5;
		}
		if(isRight == true && locx != game.getWidth() - pWidth)
		{
			locx+=5;

		}

		/*
		if(locy != game.getHeight() - pHeight && isUp !=true)
		{
			locy += G;
		}
		*/
	}



}
