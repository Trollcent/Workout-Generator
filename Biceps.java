
public class Biceps {
	private String[] bicepList = {"Dumbbell Bicep Curl", "Incline Hammer Curls", "Incline Inner-Bicep Curl",
			"EZ Bar Curl", "Wide Grip Standing Barbell Curl", "Zottman Curl","Hammer Curl", "Overhead Cable Curl",
			"Barbell Curl", "Incline Dumbbell Curl", "Standing Bicep Cable Curl","Preacher Curl"};
	private int currentIndex;
	
	Biceps()
	{
		currentIndex = 0;
		randomizeBicepList();
	}
	
	public String returnBicepWorkout()
	{
		if(currentIndex < bicepList.length)
		{
			currentIndex++;
			return bicepList[currentIndex - 1];
		}
		resetCurrentIndex();
		currentIndex++;
		return bicepList[currentIndex - 1];
	}
	
	public void resetCurrentIndex()
	{
		currentIndex = 0;
		randomizeBicepList();
	}
	
	public int returnListLength()
	{
		return bicepList.length;
	}
	
	private void randomizeBicepList()
	{
		String holdString;// String variable to hold a string
		int number;// Int variable to hold the randomize number
		
		for(int index = 0; index < bicepList.length; index++)
		{
			number = (int)(Math.random()*bicepList.length);//get a number that is randomize from 1 to arraySize
			holdString = bicepList[number];// hold the bicepList at index number
			bicepList[number] = bicepList[index];// hold the bicepList at index
			bicepList[index] = holdString;// swap the strings
		}
	}
}
