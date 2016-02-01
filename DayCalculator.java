/*
 * Author:			Anthony Johnson
 * Date Created:	01/26/2016
 * Description:		Test program that utilizes the functionality in the
 * 					Day and Week classes, as well as GUI classes to provide 
 * 					the user with a day calculator. In this program, the user 
 * 					can add a number of days on to the current day to find 
 * 					out what day of the week that number of days would be on. 
 * 					The user can also get the previous day, and the next date 
 * 					(with respect to the current day).
 */
public class DayCalculator 
{
	public static void main(String[] args)
	{
		Week week = new Week();
		DayCalcGUI ui = new DayCalcGUI(week);
		
		ui.setVisible(true);
	}
}
