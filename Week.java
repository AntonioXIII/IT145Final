/*
 * Author:			Anthony Johnson
 * Date Created:	01/26/2016
 * Description:		This class is an array based collection of 7 Day objects.
 * 					The default constructor will create a standard week with 
 * 					Sunday as the first day in the array, and Saturday as the
 * 					last day in the array. The collection keeps track of the 
 * 					current day of the week, which may be moved ahead by using
 * 					the getFutureDay method. Methods also exist to provide the
 * 					user with what the current day is, as well as the next day,
 * 					and previous day. The user can also set the current day.
 */
public class Week 
{
	private Day[] week;
	private int currentDay;
	
	// Default constructor that sets up a week of days (an array of 7 days)
	// and sets the currentDay (which is an index of the week array) 
	// to the default day of Monday.
	public Week()
	{
		week = new Day[7];
		
		// Inserts the appropriate day into the week array
		for(int i = 0; i < 7; i++)
		{
			Day day = null;
			
			switch(i)
			{
				case 0:
					day = new Day(Day.DayName.SUNDAY);
					break;
				case 1:
					day = new Day(Day.DayName.MONDAY);
					break;
				case 2:
					day = new Day(Day.DayName.TUESDAY);
					break;
				case 3:
					day = new Day(Day.DayName.WEDNESDAY);
					break;
				case 4:
					day = new Day(Day.DayName.THURSDAY);
					break;
				case 5:
					day = new Day(Day.DayName.FRIDAY);
					break;
				case 6:
					day = new Day(Day.DayName.SATURDAY);
					break;
			}
			
			week[i] = day;
		}
		
		// set the default day to Monday
		currentDay = 1;
	}
	
	// Returns the day at the currentDay index
	// Postcondition: returns the day at the index of the current day
	public Day getCurrentDay()
	{
		return week[currentDay];
	}
	
	// Returns the day of the week that is after the current day
	// Postcondition: Returns the next day of the week
	public Day getNextDay()
	{
		// If the current day is at the end of the week, return the day
		// at the beginning of the week. Otherwise, return the next day
		// in the array
		if(currentDay == 6)
		{
			return week[0];
		}
		else
		{
			return week[currentDay + 1];
		}
	}
	
	// Returns the day of the week that is prior to the current day
	// Postcondition: returns the day before the current day of the week
	public Day getPreviousDay()
	{
		// If the current day is at the beginning of the week, return
		// the day at the end of the week. Otherwise, return the day 
		// before the current day.
		if(currentDay == 0)
		{
			return week[6];
		}
		else
		{
			return week[currentDay - 1];
		}
	}
	
	// Method that moves the current day ahead by the amount of days
	// passed into the method.
	// Postcondition: returns the proper day of the week that is 
	// ahead of the current day by the amount specified as an argument. currentDay
	// is also set to the index of this calculated future day.
	public Day getFutureDay(int daysAhead)
	{
		currentDay += daysAhead;
		
		// Since the largest index we can access the array is 6,
		// we need to convert currentDay into a correct index.
		// This is done by dividing by 7, and storing the remainder
		// into currentDay. For example, if the current day is Monday (1),
		// and the amount of days passed in is 7, currentDay will be equal to 8. 
		// Then the division occurs if currentDay is greater than or equal to 7,
		// (which it is in this scenario). The remainder of 8 divided by 7 is 1,
		// which is then stored into currentDay. The day at the currentDay index
		// of 1 is Monday, which is 7 days ahead of the previous currentDay, so
		// the algorithm is correct.
		if(currentDay >= 7)
		{
			currentDay %= 7;
		}
		
		return week[currentDay];
	}
	
	// Sets the current day based on a passed in enum DayName
	// Postcondition: sets the index of the week array (currentDay)
	// to a new value.
	public void setCurrentDay(Day.DayName name)
	{
		switch(name)
		{
			case SUNDAY:
				currentDay = 0;
				break;
			case MONDAY:
				currentDay = 1;
				break;
			case TUESDAY:
				currentDay = 2;
				break;
			case WEDNESDAY:
				currentDay = 3;
				break;
			case THURSDAY:
				currentDay = 4;
				break;
			case FRIDAY:
				currentDay = 5;
				break;
			case SATURDAY:
				currentDay = 6;
				break;
		}
	}
}
