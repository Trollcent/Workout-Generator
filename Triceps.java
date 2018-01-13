
public class Triceps {
	private String[] tricepList = {"Close Grip Bench Press", "Bench Dip","Dumbbell Seated Overhead Tricep Extension"
	,"Skullcrusher", "Tricep Pushdown", "Weighted Parallel-Bar Dip", "Tricep Dip", "Cable Kick-Back", "Dumbbell Kickbacks"
	, "One Arm Dumbbell Tricep Extension" , "Back Dips"};
	private int currentIndex;
	Triceps()
	{
		currentIndex =0 ;
		randomizeTricepList();
	}
	
	public String returnTricepsWorkout()
	{
		if(currentIndex < tricepList.length)
		{
			currentIndex++;
			return tricepList[currentIndex - 1];
		}
		resetCurrentIndex();
		currentIndex++;
		return tricepList[currentIndex - 1];
	}
	
	public void resetCurrentIndex()
	{
		currentIndex = 0;
		randomizeTricepList();
	}
	
	public int returnListLength()
	{
		return tricepList.length;
	}
	
	private void randomizeTricepList()
	{
		String holdString;// String variable to hold a string
		int number;// Int variable to hold the randomize number
		
		for(int index = 0; index < tricepList.length; index++)
		{
			number = (int)(Math.random()*tricepList.length);//get a number that is randomize from 1 to arraySize
			holdString = tricepList[number];// hold the tricepList at index number
			tricepList[number] = tricepList[index];// hold the tricepList at index
			tricepList[index] = holdString;// swap the strings
		}
	}
}
