package Question2;
/*Name: Kion Smith
 * NetID: kls160430
 * CS2336-502
 */
//Create a object//
public class cardCar 
{
	private String carName;
	
	private float handlingS;
	private float handlingC;
	private float handlingU;
	private float raceProgress;
	private float currentSpeed;
	private float topSpeed;
	private float acceleration;
	
	private int wins;
	
	private char symbol;
	//default constructor using all the variables
	public cardCar(String name,float hS,float hC,float hU,float rP,float cP, float tP,float a,int w,char s)
	{
		carName = name;
		handlingS = hS;
		handlingC = hC;
		handlingU = hU;
		raceProgress = rP;
		currentSpeed = cP;
		topSpeed = tP;
		acceleration =a;
		wins = w;
		symbol= s;
	}
	//getters for car
	public String getCarName()
	{
		return carName;
	}
	public float getHandlingS()
	{
		return handlingS;
	}
	public float getHandlingC()
	{
		return handlingC;
	}
	public float getHandlingU()
	{
		return handlingU;
	}
	public float getRaceProgress()
	{
		return raceProgress;
	}
	public float getCurrentSpeed()
	{
		return currentSpeed;
	}
	public float getTopSpeed()
	{
		return topSpeed;
	}
	public float getAcceleration()
	{
		return acceleration;
	}
	public int getWins()
	{
		return wins;
	}
	public char getSymbol()
	{
		return symbol;
	}
	//Setters for car
	public void setCarName(String name)
	{
		carName = name;
	}
	public void setHandlingS(float hS)
	{
		handlingS = hS;
	}
	public void setHandlingC(float hC)
	{
		handlingC = hC;
	}
	public void setHandlingU(float hU)
	{
		handlingU = hU;
	}
	public void setRaceProgress(float rP)
	{
		raceProgress = rP;
	}
	public void setCurrentSpeed(float cS)
	{
		currentSpeed= cS;
	}
	public void setTopSpeed(float tS)
	{
		topSpeed = tS;
	}
	public void setAcceleration(float a)
	{
		acceleration = a;
	}
	public void setWins(int w)
	{
		wins = w;
	}
	public void setSymbol(char s)
	{
		symbol =s;
	}
}