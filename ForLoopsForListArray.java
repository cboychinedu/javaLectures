// Importing the necessary modules 
import java.util.ArrayList; 
import java.util.Arrays; 

// Creating the class 
public class ForLoopsForListArray {
    // Running the main function 
    public static void main(String[] args) {
        // Creating the list array 
        ArrayList <Double> ages = new ArrayList <Double>(); 

        // Adding items into the array of name ages 
        ages.add(30.4); 
        ages.add(10.35); 
        ages.add(122.234); 

        // Displaying the array 
        System.out.println(ages); 
        System.out.println(ages.get(0)); 

        // Using for loop to print out the array 
        // for (Double age: ages) {
        //     System.out.println(age); 
        // }
    }
}