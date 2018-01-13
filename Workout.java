import java.util.Scanner;
import java.util.*;
import java.io.*;
public class Workout {	
	private static Scanner scanner = new Scanner(System.in);
	private int choicesWorkout;
	private int daysWorkout;
	private int holdNumber = 0;
	
	private String reps;
	private String sets;
	
	private Back backWorkout;
	private Legs legWorkout;
	private Biceps bicepWorkout;
	private Triceps tricepWorkout;
	private Shoulder shoulderWorkout;
	private Chest chestWorkout;

	
	Workout()
	{
		chestWorkout = new Chest();
		backWorkout = new Back(); 
		bicepWorkout = new Biceps();
		legWorkout = new Legs();
		tricepWorkout = new Triceps();
		shoulderWorkout = new Shoulder();
	}
	
	public void createWorkout()
	{
		FileOutputStream outFile = null;
		List<String> myWorkoutChoices;
		List<String> myWorkout;
		
		workOutChoices();
		
		if(daysWorkout != 0)
		{
			myWorkoutChoices = chooseBodytoWork();
			
			try
			{
				outFile = new FileOutputStream("monthlyWorkout.txt");
			}
			catch(IOException ie)
			{
				System.err.print(ie);
				return;
			}
			
			PrintWriter prtWriter =  new PrintWriter(outFile, true);
			
			prtWriter.println("Reps: " + reps);	
			prtWriter.println("Sets: " + sets);
			prtWriter.println("------------------------------------------------------------------------------"
					+ "------------------------------------------------------");
			
			while(holdNumber < daysWorkout)
			{
				myWorkout = createTheWorkout(myWorkoutChoices);
				printWorkout(myWorkout, prtWriter);
				myWorkout.clear();
			}
			
			System.out.print("End");
			
			try
			{
				outFile.close();
			}
			catch(IOException ie)
			{
				System.err.print(ie);
				return;
			}
		}
	}
	
	private List<String> chooseBodytoWork()
	{
		String userChoose;
		StringTokenizer tokens;
		String holdString;
		List<String> list = new ArrayList<String>();
		boolean correctChoice = true;
		
		while(correctChoice)
		{
			System.out.println("Choose workouts that you want to priortize first to last(Seperated by a comma).\n1)Chest \n2)Leg "
					+ "\n3)Tricep\n4)Shoulder\n5)Bicep\n6)Back");
			System.out.print("Enter another choice: ");
			userChoose = scanner.next();
			tokens = new StringTokenizer(userChoose, ",");
			while(tokens.hasMoreTokens() && correctChoice)
			{
				holdString = tokens.nextToken();
				switch(holdString)
				{
					case "Back": list.add(holdString.toLowerCase()); break;
					case "Tricep": list.add(holdString.toLowerCase()); break;
					case "Bicep": list.add(holdString.toLowerCase());  break;
					case "Shoulder": list.add(holdString.toLowerCase()); break;
					case "Chest": list.add(holdString.toLowerCase());  break; 
					case "Leg": list.add(holdString.toLowerCase());  break;
					
					case "1": list.add("chest"); break; 
					case "2": list.add("leg"); break;
					case "3": list.add("tricep");break;
					case "4": list.add("shoulder");  break;
					case "5": list.add("bicep"); break;
					case "6": list.add("back");  break;
					default: correctChoice = false; break;
				}
			}
			correctChoice = false;
		}
		return list;
	}
	
	private List<String> createTheWorkout(List<String> myWorkout)
	{
		List<String> theWorkout = new ArrayList<String>();
		Iterator<String> myIterator = myWorkout.iterator();
		StringBuilder createTheWork = new StringBuilder();
		String holdFirst;
		String holdSecond;
		
		while(myIterator.hasNext())
		{
	
			holdFirst = myIterator.next();
			holdSecond = myIterator.next();
			if(holdFirst.equals("back") && holdSecond.equals("tricep") || 
					holdSecond.equals("back") && holdFirst.equals("tricep"))
			{
				for(int i = 0; i < 3; i++)
				{
					createTheWork.append(backWorkout.returnBackWorkout() + ", " 
				+ tricepWorkout.returnTricepsWorkout() + ", ");
				}
				theWorkout.add(createTheWork.toString());
				createTheWork.setLength(0);
			}
			else if(holdFirst.equals("back") && holdSecond.equals("bicep") || 
					holdSecond.equals("back") && holdFirst.equals("bicep"))
			{
				for(int i = 0; i < 3; i++)
				{
					createTheWork.append(backWorkout.returnBackWorkout() + ", " 
				+ bicepWorkout.returnBicepWorkout()+ ", ");
				}
				theWorkout.add(createTheWork.toString());
				createTheWork.setLength(0);
			}
			else if(holdFirst.equals("back") && holdSecond.equals("shoulder") ||
					holdSecond.equals("back") && holdFirst.equals("shoulder"))
			{
				for(int i = 0; i < 3; i++)
				{
					createTheWork.append(backWorkout.returnBackWorkout() + ", " 
				+ shoulderWorkout.returnShoulderWorkout() + ", ");
				}
				theWorkout.add(createTheWork.toString());
				createTheWork.setLength(0);
			} 
			else if(holdFirst.equals("back") && holdSecond.equals("chest") || 
					holdSecond.equals("back") && holdFirst.equals("chest"))
			{
				for(int i = 0; i < 3; i++)
				{
					createTheWork.append(backWorkout.returnBackWorkout() + ", " 
				+ chestWorkout.returnChestWorkout()+ ", ");
				}
				theWorkout.add(createTheWork.toString());
				createTheWork.setLength(0);
			}
			else if(holdFirst.equals("back") && holdSecond.equals("leg") || 
					holdSecond.equals("back") && holdFirst.equals("leg"))
			{
				for(int i = 0; i < 3; i++)
				{
					createTheWork.append(backWorkout.returnBackWorkout() + ", " 
				+ legWorkout.returnLegWorkout()+ ", ");
				}
				theWorkout.add(createTheWork.toString());
				createTheWork.setLength(0);
			}
			else if(holdFirst.equals("tricep") && holdSecond.equals("bicep") || 
					holdSecond.equals("tricep") && holdFirst.equals("bicep"))
			{
				for(int i = 0; i < 3; i++)
				{
					createTheWork.append(tricepWorkout.returnTricepsWorkout() + ", " 
				+ bicepWorkout.returnBicepWorkout()+ ", ");
				}
				theWorkout.add(createTheWork.toString());
				createTheWork.setLength(0);
			}
			else if(holdFirst.equals("tricep") && holdSecond.equals("shoulder") ||
					holdSecond.equals("tricep") && holdFirst.equals("shoulder"))
			{
				for(int i = 0; i < 3; i++)
				{
					createTheWork.append(tricepWorkout.returnTricepsWorkout() + ", " 
				+ shoulderWorkout.returnShoulderWorkout()+ ", ");
				}
				theWorkout.add(createTheWork.toString());
				createTheWork.setLength(0);
			}
			else if(holdFirst.equals("tricep") && holdSecond.equals("chest") || 
					holdSecond.equals("tricep") && holdFirst.equals("chest"))
			{
				for(int i = 0; i < 3; i++)
				{
					createTheWork.append(tricepWorkout.returnTricepsWorkout() + ", " 
				+ chestWorkout.returnChestWorkout()+ ", ");
				}
			}
			else if(holdFirst.equals("tricep") && holdSecond.equals("leg") || 
					holdSecond.equals("tricep") && holdFirst.equals("leg"))
			{
				for(int i = 0; i < 3; i++)
				{
					createTheWork.append(tricepWorkout.returnTricepsWorkout() + ", " 
				+ legWorkout.returnLegWorkout()+ ", ");
				}
				theWorkout.add(createTheWork.toString());
				createTheWork.setLength(0);
			}
			else if(holdFirst.equals("shoulder") && holdSecond.equals("bicep") || 
					holdSecond.equals("shoulder") && holdFirst.equals("bicep"))
			{
				for(int i = 0; i < 3; i++)
				{
					createTheWork.append(shoulderWorkout.returnShoulderWorkout() + ", " 
				+ bicepWorkout.returnBicepWorkout()+ ", ");
				}
			}
			else if(holdFirst.equals("shoulder") && holdSecond.equals("chest") ||
					holdSecond.equals("shoulder") && holdFirst.equals("chest"))
			{
				for(int i = 0; i < 3; i++)
				{
					createTheWork.append(shoulderWorkout.returnShoulderWorkout() + ", " 
				+ chestWorkout.returnChestWorkout()+ ", ");
				}
				theWorkout.add(createTheWork.toString());
				createTheWork.setLength(0);
			}
			else if(holdFirst.equals("shoulder") && holdSecond.equals("leg") ||
					holdSecond.equals("shoulder") && holdFirst.equals("leg"))
			{
				for(int i = 0; i < 3; i++)
				{
					createTheWork.append(shoulderWorkout.returnShoulderWorkout() + ", " 
				+ legWorkout.returnLegWorkout()+ ", ");
				}
				theWorkout.add(createTheWork.toString());
				createTheWork.setLength(0);
			}
			else if(holdFirst.equals("chest") && holdSecond.equals("leg") || 
					holdSecond.equals("chest") && holdFirst.equals("leg"))
			{
				for(int i = 0; i < 3; i++)
				{
					createTheWork.append(chestWorkout.returnChestWorkout() + ", " 
				+ legWorkout.returnLegWorkout()+ ", ");
				}
				theWorkout.add(createTheWork.toString());
				createTheWork.setLength(0);
			}	
		}
		return theWorkout;
	}
	
	private int printWorkout(List<String> myWorkout, PrintWriter ptrWriter)
	{
		int index = 0;
		while(index < daysWorkout && index < myWorkout.size())
		{
			
			if(holdNumber % 6 == 0 && holdNumber != 0)
			{
				ptrWriter.println("Day " + ++holdNumber + " " + "Rest Day");
			}
			else
			{
				ptrWriter.println("Day " + ++holdNumber + ": " +  myWorkout.get(index));
				index++;
			}
		}
		return holdNumber;
	}
	
	private void workOutChoices()
	{
		System.out.print("How many days do you plan to workout?\n");
		System.out.print("Enter a number: ");
		daysWorkout = scanner.nextInt();
		while(daysWorkout < 0)
		{
			System.out.print("Error. Your choice must be a postive integer");
			System.out.print("Enter another choice: ");
			daysWorkout = scanner.nextInt();
		}
		System.out.print("Choices:\n1.High Reps Low Sets\n2.Low Reps High Sets\n3.Custom\n");
		System.out.print("Enter a number: ");
		choicesWorkout = scanner.nextInt();
		while(choicesWorkout > 3 || choicesWorkout < 0)
		{
			System.out.print("Error. Your choice must be between 1 to 3\n");
			System.out.print("Enter another choice: ");
			choicesWorkout = scanner.nextInt();
		}
		switch(choicesWorkout)
		{
			case 1: reps = "15"; sets = "3"; break;
			case 2: reps = "5"; sets = "5"; break;
			case 3: 	
				System.out.print("How many sets for each workout? ");
				sets = scanner.next();
				
				while(!isNumeric(sets))
				{
					System.out.print("Error. The input is not a number!\n");
					System.out.print("Enter a number for sets: ");
					sets = scanner.next();
				}
				
				System.out.print("How many reps for each workout? ");
				reps = scanner.next();
				
				while(!isNumeric(reps))
				{
					System.out.print("Error. The input is not a number!\n");
					System.out.print("Enter a number for reps: ");
					reps = scanner.next();
				}
				removeDecimal();
				break;
			default: choicesWorkout = -1; break;
		}
	}
	
	private void removeDecimal()
	{
		reps = reps.replaceFirst("^0+(?!$)", "");
		sets = sets.replaceFirst("^0+(?!$)", "");
		if(reps.indexOf('.') != -1)
		{
			if(reps.indexOf('.') == 0)
			{
				reps = "1";
			}
			else
			{
				reps = reps.substring(0, reps.indexOf('.'));
			}
		}
		if(sets.indexOf('.') != -1)
		{
			if(sets.indexOf('.') == 0)
			{
				sets = "1";
			}
			else
			{
				sets = sets.substring(0, sets.indexOf('.'));
			}
		}
		
	}
	
	private boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  
}
