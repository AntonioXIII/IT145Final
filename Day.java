/*
 * Author:			Anthony Johnson
 * Date Created:	01/26/2016
 * Description:		This class represents a single day in a week. Using an
 * 					enumeration, the user may specify what day of the week
 * 					this object is. 
 */
public class Day 
{
	private DayName name;
	
	// Enum to specify what days of the week this day could be
	public enum DayName
	{
		SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY;
	}
	
	// For the default constructor, the default day is Monday
	public Day()
	{
		name = DayName.MONDAY;
	}
	// Constructor that specifies what day this day will be
	public Day(DayName name)
	{
		this.name = name;
	}
	
	// Sets the day of the week if it needs to be changed from what was specified
	// in the constructor.
	// Postcondition: name of the day is changed to a new DayName value
	public void setDay(DayName name)
	{
		this.name = name;
	}
	
	// Returns formatted string representation of day with first letter in the name
	// capitalized, and all other letters in lowercase
	// Postcondition: Returns capitalized string word of the day
	public String getDay()
	{
		StringBuilder day = new StringBuilder();
		String dayName = name.toString();
		
		day.append(dayName.substring(0, 1).toUpperCase());
		day.append(dayName.substring(1, dayName.length()).toLowerCase());
		return day.toString();
	}
	
	// Method that returns the day of the name as an Enum
	// Postcondition: returns the name of the day as a DayName enum
	public DayName getDayName()
	{
		return name;
	}
}
