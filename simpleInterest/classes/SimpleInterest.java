// Adding the package 
package classes; 

// Creating the class 
public class SimpleInterest {
    // Setting the result 
    public double result;

    // Adding a function to calculate the simple interest 
    public double calculateSimpleInterest(double principal, double time, double rate) {
        result = (principal * time * rate) / 100.0; 

        // Return the result 
        return result; 
    }
}