package Question2;

public class RaceTrack 
{

	
	public static void main(String[] args)
	{
		
		int RaceNumber = 25;
		String Racetrack = "----------U-C-S-------C---S---------C--U----";
		int raceLength = Racetrack.length();
		
		cardCar car1 = new cardCar("Bob Barker Car", 0.30f, 0.65f, 0.1f, 0, 0, 0.95f, 0.11f,0,'B');// need to fix this
		cardCar car2 = new cardCar("Pat Sajak Car", 0.45f, 0.85f, 0.3f, 0, 0, 0.78f, 0.08f,0,'P');
		cardCar car3 = new cardCar("Alex Trebek Car", 0.25f, 0.55f, 0.1f, 0, 0, 0.95f, 0.19f,0,'A');
		cardCar car4 = new cardCar("Drew Carrie Car", 0.15f, 0.25f, 0.05f, 0, 0, 0.9999f, 0.21f,0,'D');
		
		cardCar[] carArray = { car1,car2,car3,car4};
		
		boolean runningRace = true; //once someone wins we can stop this
		//String Progress = "";
		
		
		for(int i = 1; i<=RaceNumber; i++) 
		{
			int raceLenght = Racetrack.length();
			for(int j =0;j<carArray.length;j++)
			{
				carArray[j].setCurrentSpeed(0);
				carArray[j].setRaceProgress(0);
			}
			
			while(runningRace)
			{
				System.out.println(Racetrack);
		        for (int k = 0; k < carArray.length; k++) 
		        {
			        String Progress = "";
			        for (int l = 0; l < carArray[k].getRaceProgress(); l++)
			        Progress += " ";
			                    System.out.println(Progress + carArray[k].getSymbol());
		
			        //accelerate based on where you are on the track
			        //Racetrack[(int)car1RaceProgress)]
			        switch (Racetrack.charAt((int) carArray[k].getRaceProgress())) 
			        {
			        case '-': //strait-away
			        	if (carArray[k].getCurrentSpeed() < carArray[k].getTopSpeed())
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getCurrentSpeed() + carArray[k].getAcceleration());
			        	}
			        	else if (carArray[k].getCurrentSpeed() > carArray[k].getTopSpeed())
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getTopSpeed());
			        	}
			        	break;
			        case 'S': //Chicane
			        	if (carArray[k].getCurrentSpeed() < carArray[k].getTopSpeed() * carArray[k].getHandlingS())
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getCurrentSpeed() + carArray[k].getAcceleration());
			        	}
			        	else if (carArray[k].getCurrentSpeed() > carArray[k].getTopSpeed() * carArray[k].getHandlingS())
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getTopSpeed() * carArray[k].getHandlingS());
			        	}
			        	break;
			        case 'C': //curve
			        	if (carArray[k].getCurrentSpeed() < carArray[k].getTopSpeed() * carArray[k].getHandlingC())
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getCurrentSpeed() + carArray[k].getAcceleration());
			        	}
			        	else if (carArray[k].getCurrentSpeed() > carArray[k].getTopSpeed() * carArray[k].getHandlingC())
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getTopSpeed() * carArray[k].getHandlingC());
			        	}
			        	break;
			        case 'U': //Hairpin
			        	if (carArray[k].getCurrentSpeed() < carArray[k].getTopSpeed() * carArray[k].getHandlingU())
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getCurrentSpeed() + carArray[k].getAcceleration());
			        	}
			        	else if (carArray[k].getCurrentSpeed() > carArray[k].getTopSpeed() * carArray[k].getHandlingU())
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getTopSpeed() * carArray[k].getHandlingU());
			        	}
			        	break;
			        }
			                    //increase progress
			        carArray[k].setRaceProgress(carArray[k].getRaceProgress() + carArray[k].getCurrentSpeed());
		
			        if (carArray[k].getRaceProgress() >= raceLength) 
			        {
			        	System.out.println(carArray[k].getCarName() + " wins");
			        	carArray[k].setWins(carArray[k].getWins() + 1);
			        	runningRace = false;
			        	break;
			        }
		        }
			}
		}
		
		int maxWins = 0;
		String winnerName="";
		for(int a=0; a<carArray.length; a++)
		{
			if(carArray[a].getWins() > maxWins)
			{
				winnerName = carArray[a].getCarName();
				maxWins = carArray[a].getWins();
			}
		}
		
		System.out.println("\n\nEnd Of Season Winner:");
		System.out.println(winnerName);
		System.out.println("Total Wins: "+maxWins);
	
		/*
		while (runningRace) 
		{
			for (int i=0;i<car1RaceProgress;i++)
			{
				Progress+= " ";
			}
			System.out.println(Racetrack);
		}
		
		//accelerate based on where you are on the track
		//Racetrack[(int)car1RaceProgress)]
		switch (Racetrack.charAt((int)car1RaceProgress)) 
		{
			case '-': //strait-away
				if (car1CurrentSpeed < car1TopSpeed)
				{
						car1CurrentSpeed += car1Acceleration;
				}
				else if (car1CurrentSpeed > car1TopSpeed)
				{
					car1CurrentSpeed = car1TopSpeed;
				}
					break;
					
			case 'S': //Chicane
					if (car1CurrentSpeed < car1TopSpeed*car1HandlingS)
					{
						car1CurrentSpeed += car1Acceleration;
					}
					else if (car1CurrentSpeed > car1TopSpeed*car1HandlingS)
					{
						car1CurrentSpeed = car1TopSpeed*car1HandlingS;
					}
						break;
			case 'C': //curve
				if (car1CurrentSpeed < car1TopSpeed*car1HandlingC)
				{
					car1CurrentSpeed += car1Acceleration;
				}
				else if (car1CurrentSpeed > car1TopSpeed*car1HandlingC)
				{
					car1CurrentSpeed = car1TopSpeed*car1HandlingC;
				}
					break;
			case 'U': //Hairpin
				if (car1CurrentSpeed < car1TopSpeed*car1HandlingU)
				{
					car1CurrentSpeed += car1Acceleration;
				}
				else if (car1CurrentSpeed < car1TopSpeed*car1HandlingU)
				{
					car1CurrentSpeed = car1TopSpeed*car1HandlingU;
				}
				break;
			}
		
	
		car1RaceProgress+=car1CurrentSpeed;
	
		if (car1RaceProgress >= raceLength) 
		{
			System.out.println(car1Name+" wins");
			car1Wins++;
			runningRace=false;
		}
		*/
	}
		
}


