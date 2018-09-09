//package kion.pong.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MainMenu
{
	 public Rectangle playButton = new Rectangle(150,75, 100,40);
	 public Rectangle helpButton = new Rectangle(150,125,100,40);
	 public Rectangle quitButton = new Rectangle(150,175,100,40);

	 public MainMenu()
	 {

	 }
	 public void render(Graphics g)
	 {
		 Graphics2D g2d = (Graphics2D) g;

		 Font fnt0 = new Font("arial",Font.BOLD,24);
		 g.setFont(fnt0);
		 g.setColor(Color.WHITE);
		 g.drawString("Pong", 170,50);

		 Font fnt1 = new Font("ariel",Font.BOLD,15);

		 g2d.draw(playButton);
		 g.drawString("Play!",playButton.x+25,playButton.y+ 30);

		 g2d.draw(helpButton);
		 g.drawString("Help",helpButton.x+25,helpButton.y+ 30);
		 g2d.draw(quitButton);
		 g.drawString("Quit",quitButton.x+25,quitButton.y+ 30);
	 }
}
