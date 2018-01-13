
public class Back {
	private String[] backList = {"Barbell DeadLift", "Bent-Over Barbell Deadlift","Wide-Grip Pull-Up",
	"Standing T-Bar Row", "Wide-Grip Seated Cable Row","Close-Grip Pull-Down","Single-Arm Dumbbell Row",
	"Close-Grip Seated Cable Row","Wide-Grip Lat Pull-Down", "Pull-ups"};//, ""
	private int currentIndex;
	
	Back()
	{
		currentIndex = 0;
		randomizeBackList();
	}
	
	public String returnBackWorkout()
	{
		if(currentIndex < backList.length)
		{
			currentIndex++;
			return backList[currentIndex - 1];
		}
		resetCurrentIndex();
		currentIndex++;
		return backList[currentIndex - 1];
	}
	
	public void resetCurrentIndex()
	{
		currentIndex = 0;
		randomizeBackList();
	}
	
	public int returnListLength()
	{
		return backList.length;
	}
	
	private void randomizeBackList()
	{
		String holdString;// String variable to hold a string
		int number;// Int variable to hold the randomize number
		
		for(int index = 0; index < backList.length; index++)
		{
			number = (int)(Math.random()*backList.length);//get a number that is randomize from 1 to arraySize
			holdString = backList[number];// hold the backList at index number
			backList[number] = backList[index];// hold the backList at index
			backList[index] = holdString;// swap the strings
		}
	}
}
