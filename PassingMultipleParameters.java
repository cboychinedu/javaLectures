// Importing the necessary modules 
import java.util.Arrays; 

// Creating the class 
public class PassingMultipleParameters {

    // Setting a construction method
    // public PassingMultipleParameters(int age, String name, String location) {
    //     this.name = name; 
    //     this.age = age; 
    //     this.location = location; 
    // }

    // Declaring a function 
    public void arguments(int... values) {
        String arrayValues = Arrays.toString(values); 
        System.out.println(arrayValues); 
    }

    // Add elements inside an array 
    public int add(int... values) {
        int result = 0; 

        // Using for loop to loop through the array and 
        // add the values 
        for (int numbers: values) {
            result += numbers; 
        }

        // Returng the result 
        return result; 
    }

    // Running the main function 
    public static void main(String[] args) {
        // Getting the functions 
        PassingMultipleParameters functions = new PassingMultipleParameters(); 

        // Executing the functions 
        functions.arguments(20, 30, 40, 50);

        // Getting the sum of the array 
        int[] numbersArray = { 20, 30 ,40, 50 }; 

        // Adding the numbersArray 
        int result = functions.add(numbersArray);

        // Displaying the result 
        System.out.println("The result is: " + result);  


    }
    
}