// Importing the necessary modules 
import java.util.Arrays;

// Creating the class 
public class ArraysGuide {
    // Running the main function 
    public static void main(String[] args) {
        // Creating an array of different data types 
        int[] marks = { 40, 50, 100, 28, 75, 64}; 
        String[] names = {"Mark", "Sophia", "Brown", "Chinedu"}; 
        double[] doubleValues = {0.987, 3.945, 0.2345, 98.9843}; 
        float[] floatingPointValues = {0.98f, 0.234f, 34.05f }; 
        short[] shortValues = { 4, 12, 15, 0 }; 
        long[] longValues = { 3400, 6000, 100 }; 

        // Using for loop to loop through the array 
        for (int mark: marks) {
            // Printing the marks inside the array 
            System.out.println(mark); 
        }

        // Setting a seperation in the for loop 
        System.out.println("Printing the other type of array. "); 

        // Using the other for loop to loop through the array 
        for (int i = 0; i < marks.length; i++) {
            // Printing the contents of the array 
            System.out.println(marks[i]); 
        }

        // Displaying the names 
        for (String name: names) {
            System.out.println("The names are: " + name); 

        }

        // Displaying the array names explictity 
        String arrayNames = Arrays.toString(names); 
        System.out.println(arrayNames); 

        // Printing the contents of the array using System.out 
        String arrayString = Arrays.toString(marks); 
        System.out.println(arrayString);
    }
}
