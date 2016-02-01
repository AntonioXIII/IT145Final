import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Author:			Anthony Johnson
 * Date Created:	01/26/2016
 * Description:		This class provides the user interface for
 * 					the day calculator program.
 */
public class DayCalcGUI extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private CalculatorActions eventHandler;
	private JPanel container;
	private JLabel previousDay;
	private JLabel nextDay;
	private JLabel currentDay;
	private JTextField setCurrentDay;
	private JTextField moveDaysAhead;
	private JButton daysAheadButton;
	private JButton currentDayButton;
	private JButton quitButton;
	
	// Constructor that sets up the Day Calculator GUI with a reference
	// to the week object for the event handler to use.
	public DayCalcGUI(Week week)
	{
		// The GUI is made up of a grid layout with five columns, and as
		// many rows as necessary.
		container = new JPanel(new GridLayout(0,5));
		eventHandler = new CalculatorActions(week, this);
		// Wrapping the text of a JLabel within HTML tags makes the text wrap
		// unto another line of text if all the text does not fit on to
		// one line due to the window's size
		currentDay = new JLabel("<html>Current Day: " + eventHandler.getCurrentDay() +
				"</html>");
		previousDay = new JLabel("<html>Previous Day: " + eventHandler.getPreviousDay() +
				"</html>");
		nextDay = new JLabel("<html>Next Day: " + eventHandler.getNextDay() + 
				"</html>");
		setCurrentDay = new JTextField();
		moveDaysAhead = new JTextField();
		currentDayButton = new JButton("Change Day");
		daysAheadButton = new JButton("Move Days Ahead");
		quitButton = new JButton("Exit");
		
		// Register listener with buttons
		currentDayButton.addActionListener(eventHandler);
		daysAheadButton.addActionListener(eventHandler);
		quitButton.addActionListener(eventHandler);
		
		// Row 1 of GUI
		container.add(currentDay);
		container.add(new JLabel());
		container.add(previousDay);
		container.add(new JLabel());
		container.add(nextDay);
		
		// Row 2 (empty)
		addEmptyRow(5);
		
		// Row 3 (set the current day)
		container.add(new JLabel("<html>Set the current day:</html>"));
		container.add(setCurrentDay);
		container.add(new JLabel());
		container.add(currentDayButton);
		container.add(new JLabel());
		
		// Row 4 (empty)
		addEmptyRow(5);
		
		// Row 5 (move current day x amount of days)
		container.add(new JLabel("<html>Move the current day ahead by an amount of days:</html>"));
		container.add(moveDaysAhead);
		container.add(new JLabel());
		container.add(daysAheadButton);
		container.add(new JLabel());
		
		// Rows 6 & 7(empty)
		addEmptyRow(5);
		addEmptyRow(5);
		
		// Row 8 (quit button)
		container.add(new JLabel());
		container.add(new JLabel());
		container.add(new JLabel());
		container.add(new JLabel());
		container.add(quitButton);
		
		// Finish frame setup
		this.getContentPane().add(container);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700,400);
		this.setTitle("Day Calculator");
		
	}
	
	// Method that closes the GUI properly when the user wishes to quit.
	// Postcondition: program is successfully terminated.
	public void exitProgram()
	{
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
	// Method that updates the day labels with new days if the current day has been
	// changed.
	// Postcondition: changes the value of the previous day, current day, and next
	// day labels if the current day value has been changed. 
	public void updateLabels()
	{
		// HTML tags in the labels help keep the text from disappearing when the window
		// gets too small.
		previousDay.setText("<html>Previous Day: " + eventHandler.getPreviousDay() +
				"</html>");
		currentDay.setText("<html>Current Day: " + eventHandler.getCurrentDay() + 
				"</html>");
		nextDay.setText("<html>Next Day: " + eventHandler.getNextDay() + 
				"</html>");
	}
	
	// Clears all text fields on the GUI.
	// Postcondition: sets the text of all textfields to an empty string.
	public void clearTextfields()
	{
		setCurrentDay.setText("");
		moveDaysAhead.setText("");
	}
	
	// Method that returns the text of a textfield that corresponds
	// with the passed in JButton, if applicable.
	// Postcondition: returns the string text of a textfield that
	// corresponds with the button that was pressed.
	public String getTextfieldText(JButton eventSource)
	{
		if(eventSource == daysAheadButton)
		{
			return moveDaysAhead.getText();
		}
		else if(eventSource == currentDayButton)
		{
			return setCurrentDay.getText();
		}
		else
		{
			return "";
		}
	}
	
	// Private method that adds an empty row onto the GUI during initial setup
	// of the GUI.
	// Postcondition: Adds a row of empty JLabels to create an empty row
	// on the GUI. The number of columns of the GUI must be specified so
	// the JLabels span the entire length of the row.
	private void addEmptyRow(int numColumns)
	{
		for(int i = 0; i < numColumns; i++)
		{
			container.add(new JLabel());
		}
	}
}
