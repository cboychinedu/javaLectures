// Importing the necessary modules 
import java.util.Arrays; 

// Creating the class 
public class StringExercise {
    // Creating a method to find the days with the most 
    // number of letters 
    public void mostNumberOfLetters(String... values) {
        // Initialize the variables 
        String longestDay = ""; 
        int maxLength = 0; 

        // Loop through all the days  
        for (String day: values) {
            if (day.length() > maxLength ) {
                // Setting the longest day 
                maxLength = day.length(); 
                longestDay = day; 
            }
        } 

        // Displaying the result 
        System.out.println("The day with the most number of letters is: " + longestDay);   
    }

    // Runing the main function 
    public static void main(String[] args) {
        // Days of the week 
        String[] daysOfTheWeek = { 
            "Sunday", "Monday", "Tuesday", 
            "Wednesday", "Thursday", "Friday",
            "Saturday", 
        }; 

        // Getting the longest day method 
        StringExercise longestDay = new StringExercise(); 

        // Calling the method 
        longestDay.mostNumberOfLetters(daysOfTheWeek);
    }
}