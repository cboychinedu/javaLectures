/** 
 * Importing the necessary modules 
 */
import classes.SimpleInterest; 
import classes.AreaOfACircle; 

// Starting the main application 
public class main {
    public static void main(String[] args) {
        // Finding the simple interest 
        double principal = 30000.0; 
        double time = 13.098; 
        double rate = 2.5; 
        double radius = 200.0985; 

        // Declaring the result 
        double result; 
        double area; 

        // Creating an instance of the simple interest class 
        SimpleInterest simpleInterest = new SimpleInterest();

        // Creating an instance of the calculate area class 
        AreaOfACircle areaOfACircle = new AreaOfACircle(); 

        // Getting the area of a circle 
        area = areaOfACircle.AreaOfACircle(radius); 

        // classing the calculate simple interest method 
        result = simpleInterest.calculateSimpleInterest(principal, time, rate); 

        // Displaying the result 
        System.out.printf("The simple interest is: %f", result).println(); 
        System.out.println("The area of the circle is: " + area); 

    }
}