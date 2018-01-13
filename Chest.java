
public class Chest {
	private String[] chestList = {"Barbell Bench Press", "Low-Incline Barbell Bench Press","Machine Decline Press",
			"Seated Machine Chest Press", "Dips for Chest","Incline Bench Cable Fly"
			,"Pec-Deck Machine", "Dumbbell Squeeze Press" , "Weighted Push Up", "Close-Grip Bench Press",
			"Cable Fly"};
	private int currentIndex;
	
	Chest()
	{
		currentIndex = 0;
		randomizeChestList();
	}
	
	public String returnChestWorkout()
	{
		if(currentIndex < chestList.length)
		{
			currentIndex++;
			return chestList[currentIndex - 1];
		}
		resetCurrentIndex();
		currentIndex++;
		return chestList[currentIndex - 1];
	}
	
	public void resetCurrentIndex()
	{
		currentIndex = 0;
		randomizeChestList();
	}
	
	public int returnListLength()
	{
		return chestList.length;
	}
	
	private void randomizeChestList()
	{
		String holdString;// String variable to hold a string
		int number;// Int variable to hold the randomize number
				
		for(int index = 0; index < chestList.length; index++)
		{
			number = (int)(Math.random()*chestList.length);//get a number that is randomize from 1 to arraySize
			holdString = chestList[number];// hold the chestList at index number
			chestList[number] = chestList[index];
			chestList[index] = holdString;
		}
	}
}
