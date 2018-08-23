package Engine;

import javax.swing.JFrame;

public class Game 
{
	public static void main(String [] args)
	{
		JFrame window  = new JFrame("Frogger");
		window.setContentPane(new GamePanel() );
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		window.pack();
		window.setLocationRelativeTo(null);
		
	}
}
