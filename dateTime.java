// Importing the necessary modules 
import java.time.*;  

// Creating the class 
public class dateTime {

    // running the main function 
    public static void main(String[] args) {
        // Getting todays date
        LocalDate today = LocalDate.now();

        // Getting the month 
        int month = today.getMonthValue(); 
        int day = today.getDayOfMonth(); 

        // Converting the day into a string value 
        String dayValue = Integer.toString(day); 

        // Displaying the month and day 
        System.out.println(dayValue); 
        // System.out.println("The day is: " + day); 
        // System.out.println("The month is: " + month); 
    }
}
