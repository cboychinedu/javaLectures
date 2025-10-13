// Adding the class package 
package classes; 

// Creating the class 
public class AreaOfACircle {

    // Defining PI as a constant
    public static final double PI = 3.142;

    // Defining the result 
    public double result; 

    // Adding a constructor
    public double AreaOfACircle(double radius) {
        // Getting the area 
        result = PI * radius * radius;

        // 
        return result;  
    }
    
}