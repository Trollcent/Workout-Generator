
public class Legs {
	private String[] legList = {"Barbell Squats", "Dumbbell Lunges", "Leg Press", "Lying Leg Curls", 
			"Leg Extensions", "Standing Calf Raises", "Donkey Calf Raises", "Goblet Squat",
			"Seated Leg Curl", "Hack Squats", "Romanian Deadlift", "Smith Machine Squat"};
	private int currentIndex;
	
	Legs()
	{
		currentIndex = 0;
		randomizeLegList();
	}
	
	public String returnLegWorkout()
	{
		if(currentIndex < legList.length)
		{
			currentIndex++;
			return legList[currentIndex - 1];
		}
		resetCurrentIndex();
		currentIndex++;
		return legList[currentIndex - 1];
	}
	
	public void resetCurrentIndex()
	{
		currentIndex = 0;
		randomizeLegList();
	}
	
	
	public int returnListLength()
	{
		return legList.length;
	}
	
	private void randomizeLegList()
	{
		String holdString;// String variable to hold a string
		int number;// Int variable to hold the randomize number
		
		for(int index = 0; index < legList.length; index++)
		{
			number = (int)(Math.random()*legList.length);//get a number that is randomize from 1 to arraySize
			holdString = legList[number];// hold the legList at index number
			legList[number] = legList[index];// hold the legList at index
			legList[index] = holdString;// swap the strings
		}
	}
}
