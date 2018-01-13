
public class Shoulder {
	private String [] shoulderList = {"Dumbbell Shoulder Press" ,"Upright Barbell Row","Side Lateral Raise",
			"Standing Front Barbell Raise Over Head", "Seated Barbell Military Press","Front Cable Raise",
			"Upright Cable Row", "Reverse Machine Flyes", "Machine Shoulder Press","One-Arm Side Laterals",
			"Cable Rear Delt Fly", "Arnold Dumbbell Press"};
	private int currentIndex;
	
	Shoulder()
	{
		currentIndex = 0;
		randomizeShoulderList();
	}
	
	public String returnShoulderWorkout()
	{
		if(currentIndex < shoulderList.length)
		{
			currentIndex++;
			return shoulderList[currentIndex - 1];
		}
		resetCurrentIndex();
		currentIndex++;
		return shoulderList[currentIndex - 1];
	}
	
	public void resetCurrentIndex()
	{
		currentIndex = 0;
		randomizeShoulderList();
	}
	
	public int returnListLength()
	{
		return shoulderList.length;
	}
	
	private void randomizeShoulderList()
	{
		String holdString;// String variable to hold a string
		int number;// Int variable to hold the randomize number
		
		for(int index = 0; index < shoulderList.length; index++)
		{
			number = (int)(Math.random()*shoulderList.length);//get a number that is randomize from 1 to arraySize
			holdString = shoulderList[number];// hold the shoulderList at index number
			shoulderList[number] = shoulderList[index];// hold the shoulderList at index
			shoulderList[index] = holdString;// swap the strings
		}
	}
}
