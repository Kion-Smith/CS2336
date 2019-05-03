import javax.swing.*;
import javax.swing.border.Border.*;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.text.DecimalFormat;


public class IceCreamShopTesting
{
	public static void main(String [] args)
	{
		IceCreamShopWindow window = new IceCreamShopWindow();
		window.setSize(600, 175);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Ice Cream Shop"); 
		window.pack();
		//window.getContentPane().setBackground(Color.yellow); 
	}
}

class IceCreamShop 
{
	public IceCreamShop(ArrayList<String> toppings, ArrayList<String> flavors) 
	{
		
		Scanner input = null;
		try {
			input = new Scanner(new File("Toppings.txt"));
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Cannot find Toppings.txt");
		}
		while (input.hasNext()) {
		   toppings.add(input.nextLine());
	   }		
	} 
}

class IceCreamShopWindow extends JFrame implements ActionListener, ItemListener 
{
	private ArrayList<String> toppings;
	private ArrayList<String> flavors;
	private IceCreamShop shop;
	private ToppingsPanel topPanel;
	private ScoopsPanel scoopPanel;
	private ImageIcon iceCreamIcon;
	private JLabel picLabel;
	private FlavorsPanel flavPanel;
	private JButton costBtn;
	private JLabel costLbl;
	private JPanel costPanel;
	private LoggingWindow outputLog;
	
	public IceCreamShopWindow() 
	{
	
	   toppings = new ArrayList<String>();
		shop = new IceCreamShop(toppings, flavors);
		topPanel = new ToppingsPanel(toppings);
		topPanel.setPreferredSize(new Dimension(130, 100));

		//default layout for JFrame is BorderLayout
		//no need to execute setLayout method
		add(topPanel, BorderLayout.WEST);
		
		scoopPanel = new ScoopsPanel();
		scoopPanel.setPreferredSize(new Dimension(100, 50));
		add(scoopPanel, BorderLayout.NORTH);
		
		iceCreamIcon = new ImageIcon("icecream.png");
		picLabel = new JLabel(iceCreamIcon);		
		add(picLabel, BorderLayout.CENTER);
		
		flavPanel = new FlavorsPanel();
		flavPanel.setPreferredSize(new Dimension(100, 100));
		add(flavPanel, BorderLayout.EAST);
		
		costPanel = new JPanel();
		costPanel.setLayout(new GridLayout(0,1));
		costPanel.setPreferredSize(new Dimension(100, 50));
		costBtn = new JButton("Calculate bill");
		costBtn.addActionListener(this);
		costLbl = new JLabel("Welcome to SMU ICE CREAM Place", JLabel.CENTER);
		costPanel.add(costLbl);
		costPanel.add(costBtn);
		add(costPanel, BorderLayout.SOUTH);
		
		outputLog = new LoggingWindow();
		outputLog.setTitle("Daily Activity"); 
		outputLog.setSize(300, 200);
		outputLog.setVisible(true);
		outputLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outputLog.setLocation(new Point(this.getX() + 550, this.getY()));

	}
	public void actionPerformed(ActionEvent e) 
	{
	
		if (topPanel.isSelected() &&
			 flavPanel.isSelected() && 
			 scoopPanel.isSelected()) {

			double cost = 0;
			String message;
			if (e.getSource() == costBtn) {
				cost = topPanel.getCost();
				
			}
			DecimalFormat df = new DecimalFormat("#.00");
			int scoops = scoopPanel.getScoops();
			cost = scoops + cost;
			
			message = "Total bill : $" + df.format(cost);
			
			message += " for " + scoops + " scoop/s of Ice Cream";
			costLbl.setText(message);
			outputLog.logActivity(message + "\n");
		}
		else {
			costLbl.setText("Please make your selection.");
		}
	}
	public void itemStateChanged(ItemEvent e) {
		// add code here if you want to handle 
		// state change event
	
	}

}
class ToppingsPanel extends JPanel {
	private JCheckBox topChkBox [];
	private double topCost [] = {0.25, 0.25, 0.35, 0.50};
		
	public ToppingsPanel(ArrayList<String> toppings) {
		
	   //defualt layout for a JPanel is not GridLayout
		//calling setLayout to change it to GridLayout
		setLayout(new GridLayout(0,1));
		//setBorder(BorderFactory.createLineBorder(Color.black));
				
		topChkBox = new JCheckBox[toppings.size()];	
		for (int i=0; i<toppings.size(); i++) {
			topChkBox[i] = new JCheckBox(toppings.get(i));
			topChkBox[i].setSize(10,10);
			
		   add(topChkBox[i]);
		}	 
	}
	public boolean isSelected() {
		for (JCheckBox c : topChkBox) {
			if (c.isSelected())
				return true;
		}
		return false;
	}	
	
	public double getCost() {
	   double cost = 0.0;
		int i = 0;
		for (JCheckBox c : topChkBox) {
			if (c.isSelected()) {
				cost += topCost[i++];
			}
		}
		return cost;
	}
}

class ScoopsPanel extends JPanel {
	private JRadioButton scoopRadio[];
	private String [] scoops = {"1 Scoop", "2 Scoops", "3 Scoops"};
	private double scoopCost;
	
	private ButtonGroup btnGroup;
	
	public ScoopsPanel() {
		scoopCost = 1.00;
		btnGroup = new ButtonGroup();
		scoopRadio = new JRadioButton[scoops.length];
		for (int i=0; i<scoops.length; i++) {
			scoopRadio[i] = new JRadioButton(scoops[i]);
			btnGroup.add(scoopRadio[i]);
			add(scoopRadio[i]);
		}
	}
	public boolean isSelected() {
		for (JRadioButton c : scoopRadio) {
			if (c.isSelected())
				return true;
		}
		return false;
	}	
	public int getScoops() {
		int i;
		for (i=0; i<scoops.length; i++) {
			if (scoopRadio[i].isSelected())
				return i+1;
		}
		return 0;
	}	
		
}

class FlavorsPanel extends JPanel {
	private String [] flavors = {"Vanilla", "Strawberry", "Chocolate"};
	private JCheckBox [] flavChk;
	
	public FlavorsPanel() {
	   setLayout(new GridLayout(0,1));
		flavChk = new JCheckBox[flavors.length];
		for (int i=0; i<flavors.length; i++) {
			flavChk[i] = new JCheckBox(flavors[i]);
			add(flavChk[i]);
		}
	}
	public boolean isSelected() {
		for (JCheckBox c : flavChk) {
			if (c.isSelected())
				return true;
		}
		return false;
	}	
}

class LoggingWindow extends JFrame {
	private JTextArea log;
	private JScrollPane scrolling;
	
	public LoggingWindow () {
		log = new JTextArea();
		scrolling = new JScrollPane(log);
		add(scrolling);
	}
	public void logActivity(String m) {
		log.append(m);
	}
}