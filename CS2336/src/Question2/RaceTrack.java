package Question2;
/*Name: Kion Smith
 * NetID: kls160430
 * CS2336-502
 */
///Simulating a race track///
public class RaceTrack 
{

	
	public static void main(String[] args)
	{
		int RaceNumber = 25;//number of races
		boolean runningRace = true; // set this to start the races
		
		//creation of car objects using default constructor
		cardCar car1 = new cardCar("Bob Barker Car", 0.30f, 0.65f, 0.1f, 0, 0, 0.95f, 0.11f,0,'B');
		cardCar car2 = new cardCar("Pat Sajak Car", 0.45f, 0.85f, 0.3f, 0, 0, 0.78f, 0.08f,0,'P');
		cardCar car3 = new cardCar("Alex Trebek Car", 0.25f, 0.55f, 0.1f, 0, 0, 0.95f, 0.19f,0,'A');
		cardCar car4 = new cardCar("Drew Carrie Car", 0.15f, 0.25f, 0.05f, 0, 0, 0.9999f, 0.21f,0,'D');
		
		cardCar[] carArray = { car1,car2,car3,car4};//create array of cars
		
		
		String racetrack = createTrack();//create new track before race
		//keep going until all races are done
		for(int i = 1; i<=RaceNumber; i++) 
		{
			 runningRace = true; //keep this true
			 //set all the original speeds and progress locations back to zero for next race
			for(int j =0;j<carArray.length;j++)
			{
				carArray[j].setCurrentSpeed(0);
				carArray[j].setRaceProgress(0);
			}
			//while the race is still going on run the race
			while(runningRace)
			{
		        for (int k = 0; k < carArray.length; k++) //run all the cars through this
		        {
			       
			       //Switch statement to tell the car what speed it gets
			        switch (racetrack.charAt((int) carArray[k].getRaceProgress())) //current location  equals the char 
			        {
			        case '-': //strait-away
			        	if (carArray[k].getCurrentSpeed() < carArray[k].getTopSpeed())
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getCurrentSpeed() + carArray[k].getAcceleration());//add up current speed and accel
			        	}
			        	else if (carArray[k].getCurrentSpeed() > carArray[k].getTopSpeed())// check to make sure car it is not moving faster than its top speed
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getTopSpeed());
			        	}
			        	break;
			        case 'S': //Chicane
			        	if (carArray[k].getCurrentSpeed() < carArray[k].getTopSpeed() * carArray[k].getHandlingS())
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getCurrentSpeed() + carArray[k].getAcceleration()); //add up current speed and S
			        	}
			        	else if (carArray[k].getCurrentSpeed() > carArray[k].getTopSpeed() * carArray[k].getHandlingS())// check to make sure car it is not moving faster than its top speed
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getTopSpeed() * carArray[k].getHandlingS());
			        	}
			        	break;
			        case 'C': //curve
			        	if (carArray[k].getCurrentSpeed() < carArray[k].getTopSpeed() * carArray[k].getHandlingC())
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getCurrentSpeed() + carArray[k].getAcceleration());//add up current speed and C
			        	}
			        	else if (carArray[k].getCurrentSpeed() > carArray[k].getTopSpeed() * carArray[k].getHandlingC())
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getTopSpeed() * carArray[k].getHandlingC());
			        	}
			        	break;
			        case 'U': //Hairpin
			        	if (carArray[k].getCurrentSpeed() < carArray[k].getTopSpeed() * carArray[k].getHandlingU())
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getCurrentSpeed() + carArray[k].getAcceleration());//add up current speed and U
			        	}
			        	else if (carArray[k].getCurrentSpeed() > carArray[k].getTopSpeed() * carArray[k].getHandlingU())// check to make sure car it is not moving faster than its top speed
			        	{
			        		carArray[k].setCurrentSpeed(carArray[k].getTopSpeed() * carArray[k].getHandlingU());
			        	}
			        	break;
			        }
			                    //increase progress
			        carArray[k].setRaceProgress(carArray[k].getRaceProgress() + carArray[k].getCurrentSpeed());//set the progress of current car k
		
			        if (carArray[k].getRaceProgress() >= racetrack.length()) //give the win to the car who finished first
			        {
			        	carArray[k].setWins(carArray[k].getWins() + 1);
			        	runningRace = false;// end the race
			        }
		        }
			}
			 racetrack = createTrack();//create track for new race
		}
		
		int max = 0;//max number of wins
		String winner="";// winners name
		
		for(int x=0; x<carArray.length; x++)//check the whole array for winner
		{
			if(carArray[x].getWins() > max)// car at x has greater than max then replace max
			{
				//the new car at x becomes max
				winner = carArray[x].getCarName();
				max = carArray[x].getWins();
			}
			
		}
		
		System.out.print("The racers with the most wins is "+winner+ "with a total of "+max+" wins ");// out print the winner
	
	}
	
	public static String createTrack()
	{
		String track ="";//create an empty track to append to
		int[] arrayChoices = new int[4];// 4 choices to symbolize -/S/C/U
		int choice =0;//Initialize choice
		 int numOfObstacles = 18+ ((int) Math.random() * 40);// create a string shortest being 18 longest 40
		 for(int i = numOfObstacles;i>0;i--)
		 {
			  choice = (int) (Math.random() *8);// select a random choice
			 if(choice == 0 || choice >= 4)// have a higher chane of creating straight away
			 {
				 track +="-";
				 arrayChoices[0]++;
			 }
			 else if(choice == 1)//creating Chinace
			 {
				 track +="S";
				 arrayChoices[1]++;
			 }
			 else if(choice ==2)//create curve
			 {
				 track +="C";
				 arrayChoices[2]++;
			 } 
			 else if(choice ==3)//create Hairpin
			 {
				 track +="U";
				 arrayChoices[3]++;
			 }
		 }
		 //If any of these array choices are empty add one to the end
		 if(arrayChoices[0] ==0)
		 {
			 track+="-";
		 }
		 if(arrayChoices[1] ==0)
		 {
			 track +="S";
		 }
		 if(arrayChoices[2] ==0)
		 {
			 track +="C";
		 }
		 if(arrayChoices[3] ==0)
		 {
			 track +="U";
		 }
		 
		return track;
	}
		
}


