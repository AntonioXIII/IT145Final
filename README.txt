###################################################################################################################
ASSIGNMENT SUMMARY
###################################################################################################################

This project was a final coding assignment for a Java object oriented programming class. The program
made from this code completed the following assignment directives:

-------------------------------------------------------------------------------------------------------------------
Design and implement the class Day that implements the day of the week in a program. The class Day should 
store the day, such as Sun for Sunday. The program should be able to perform the following operations on an 
object of type Day:

A. Set the day.

B. Print the day.

C. Return the day.

D. Return the next day.

E. Return the previous day.

F. Calculate and return the day by adding certain days to the current day. For example, if the current day is 
	Monday and we add four days, the day to be returned is Friday. Similarly, if today is Tuesday and we 
	add 13 days, the day to be returned is Monday.

G. Add the appropriate constructors.

H. Write the definitions of the methods to implement the operations for the class Day, as defined in A through G.

I. Write a program to test various operations on the class Day.
-------------------------------------------------------------------------------------------------------------------
###################################################################################################################
PROGRAM SUMMARY
###################################################################################################################

The program accomplishes the aforementioned assignment objectives through a visual user interface (UI) that utilizes
a grid layout. Three labels at the top of the UI display information about the current day selected, the day before
the current day, and the day after the current day. Text boxes and their corresponding buttons are provided on the UI
to change the current day to a specific day in the week (regardless of what case the letters in the day of the week
are), and to enter a number of days to move the current day ahead by. 

###################################################################################################################
CLASS SUMMARIES
###################################################################################################################

This program consists of 5 classes, and one public enumeration declared in the Day class. 

-- Day

The Day class provides functionality on setting the day, and getting the day in a couple of different ways. Using 
the DayName enumeration in this class, the name of the day may be set to any day of the week (all letters in the 
name of the day would be capitalized, since it is a value of an enumeration). The day may be retrieved in two 
different ways in this class. One getter method returns the day name as a value of the DayName enumeration. Another
method returns the name of the day as a formatted string, with only the first letter in the name of day being
capitalized while the rest of the word is in lowercase.

-- Week

The Week class is an array based collection of 7 Day objects, starting with Sunday at the first position (index 0)
and ending with Saturday at the seventh position (index 6). This class keeps track of the current day of the week
that the program is on. Using methods the day before, and the day after the current day may be retrieved. There
is also a getter method for the current day. The current day may be changed through 2 methods. There exists a
setter method for the current day that requires an argument of enum type DayName, which changes the current day
to the day passed in. The method GetFutureDay also changes the value of current day. GetFutureDay takes in an
amount of days to move the current day ahead in the week, and properly calculates what the new current day will 
be. 

-- DayCalcGUI (extends JFrame)

This class provides the visual interface in which the user interacts with the program. This is the only window
in the program, which utilizes a container JPanel that organizes its components with a 5 column grid layout.
At the top of the UI, there are three labels that specify what the current day of the week is, and what the 
days before, and after the current day are. In the middle of the window, there are controls (a textfield with
corresponding button) that can change the current day to a specified day, or move the current day ahead by a
number of days. At the bottom right of the UI there is also a button to quit the program. The functionality
behind the button clicks is handled by the CalculatorActions class.

-- CalculatorActions (implements ActionListener)

The CalculatorActions class provides the functionality to respond to button clicks with appropriate actions.
When a button is clicked an object of this class first determines what button was clicked. Once that has been
determined, the appropriate methods in the Week or DayCalcGUI objects are executed (change current day methods
in the Week object, quit method in the DayCalcGUI object).

-- DayCalculator

This class is the starting point of the program. It instantiates a DayCalcGUI and a Week for the 
CalculatorActions object in the DayCalcGUI to use. It then makes the DayCalcGUI visible.