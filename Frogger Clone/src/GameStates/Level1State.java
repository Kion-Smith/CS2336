package GameStates;

import java.awt.*;
import java.awt.event.KeyEvent;

import Engine.GamePanel;
import Entity.Player;
import TileMap.TileMap;

public class Level1State extends GameState 
{

	private TileMap tileMap;
	private Player player;
	
	public Level1State(GameStateManager gsm)
	{
		this.gsm = gsm;
		init();
	}
	
	public void init() 
	{
		
		tileMap = new TileMap(32);
		//tileMap.loadTiles("/TileSets/grasstileset.gif");
		//tileMap.loadTiles("/Sprites/11067.png");
		tileMap.loadTiles("/TileSets/Tileset.png");
		//tileMap.loadMap("/Maps/level1-1.map");
		tileMap.loadMap("/Maps/level1.map");
		tileMap.setPostion(0,0);
		player = new Player(tileMap);
		
	}

	
	public void update() 
	{
	
		player.update();
		tileMap.setPostion(GamePanel.WIDTH / 2 - player.getx(),GamePanel.HEIGHT / 2 - player.gety());
	}

	
	public void draw(Graphics2D g) 
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0,GamePanel.WIDTH,GamePanel.HEIGHT);
		tileMap.draw(g);
		player.draw(g);
		player.setPostion(448/2, 465);
		
	}


	public void keyPressed(int k) 
	{
		if(k ==KeyEvent.VK_LEFT)
		{
			player.setLeft(true);
		}
		if(k ==KeyEvent.VK_RIGHT)
		{
			player.setRight(true);
		}
		if(k ==KeyEvent.VK_DOWN)
		{
			player.setDown(true);
		}
		if(k ==KeyEvent.VK_UP)
		{
			player.setUp(true);
		}
		
	}


	public void keyReleased(int k) 
	{
		if(k ==KeyEvent.VK_LEFT)
		{
			player.setLeft(false);
		}
		if(k ==KeyEvent.VK_RIGHT)
		{
			player.setRight(false);
		}
		if(k ==KeyEvent.VK_DOWN)
		{
			player.setDown(false);
		}
		if(k ==KeyEvent.VK_UP)
		{
			player.setUp(false);
		}
		
	}

}
