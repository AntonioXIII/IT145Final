import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/*
 * Author:			Anthony Johnson
 * Date Created:	01/27/2016
 * Description:		This class provides the event handling for the Day
 * 					Calculator GUI. Through this class, the GUI can access
 * 					days of the week array, and provide additional functionality
 * 					on button clicks.
 */
public class CalculatorActions implements ActionListener
{
	private Week week;
	private DayCalcGUI ui;
	
	// Constructor that sets up the calculator actions object with
	// references to the ui, and the week array
	public CalculatorActions(Week week, DayCalcGUI ui)
	{
		this.week = week;
		this.ui = ui;
	}
	
	// Method that retrieves the current day name from the array.
	// Postcondition: returns the String day name of the current day of the week.
	public String getCurrentDay()
	{
		return week.getCurrentDay().getDay();
	}
	
	// Method that retrieves the String day name before the current day from the array.
	// Postcondition: returns the String day name before the current day in the week array.
	public String getPreviousDay()
	{
		return week.getPreviousDay().getDay();
	}
	
	// This method returns the day name of the day after the current day.
	// Postcondition: returns the string name of the day after the current day.
	public String getNextDay()
	{
		return week.getNextDay().getDay();
	}
	
	// Implemented method from the ActionListener interface. This method
	// handles the response to a button click on the GUI.
	// Postcondition: This method could perform a variety of actions
	// based on what button was pressed. A future day could be calculated,
	// the current day could be set to a new day, or the program could be 
	// terminated.
	public void actionPerformed(ActionEvent event)
	{
		// This will store the text of the button that
		// triggered the command
		String sourceName = event.getActionCommand();
		
		// If the change day button was pressed, change the current day
		// if the input is valid.
		if(sourceName.equals("Change Day"))
		{
			JButton eventSource = (JButton)(event.getSource());
			// Change current day based on what the user put in the text box
			String day = ui.getTextfieldText(eventSource);
			
			if(day.toLowerCase().equals("monday"))
			{
				week.setCurrentDay(Day.DayName.MONDAY);
				ui.updateLabels();
			}
			else if(day.toLowerCase().equals("tuesday"))
			{
				week.setCurrentDay(Day.DayName.TUESDAY);
				ui.updateLabels();
			}
			else if(day.toLowerCase().equals("wednesday"))
			{
				week.setCurrentDay(Day.DayName.WEDNESDAY);
				ui.updateLabels();
			}
			else if(day.toLowerCase().equals("thursday"))
			{
				week.setCurrentDay(Day.DayName.THURSDAY);
				ui.updateLabels();
			}
			else if(day.toLowerCase().equals("friday"))
			{
				week.setCurrentDay(Day.DayName.FRIDAY);
				ui.updateLabels();
			}
			else if(day.toLowerCase().equals("saturday"))
			{
				week.setCurrentDay(Day.DayName.SATURDAY);
				ui.updateLabels();
			}
			else if(day.toLowerCase().equals("sunday"))
			{
				week.setCurrentDay(Day.DayName.SUNDAY);
				ui.updateLabels();
			}
			// The input was not valid, inform the user of the requirements through a popup.
			else
			{
				JOptionPane.showMessageDialog(ui, "That is not a day of the week. Please enter "
						+ "only a day of the week in the text box to change the current day.");
			}
			
			ui.clearTextfields();
		}
		// If the move days ahead button was pressed, attempt to move the current
		// day ahead by the number of days specified in the text box.
		else if(sourceName.equals("Move Days Ahead"))
		{
			// Advance the current day by the amount in the textbox
			try
			{
				JButton eventSource = (JButton)(event.getSource());
				int numDaysAhead = Integer.parseInt(ui.getTextfieldText(eventSource));
				Day futureDay = week.getFutureDay(numDaysAhead);
				
				week.setCurrentDay(futureDay.getDayName());
				ui.updateLabels();
				ui.clearTextfields();
			}
			// The input in the textbox was not a whole number, inform the user
			// with a popup.
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(ui, "That is not a whole number. Please enter "
						+ "the amount of days you wish to move the current day forward "
						+ "only as a whole number.");
			}
		}
		
		// If the exit button was pressed, exit the program.
		else if(sourceName.equals("Exit"))
		{
			// Exit the program
			ui.exitProgram();
		}
	}
}
