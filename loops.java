// Importing the necessary modules 
import classes.MyNumber; 

public class loops {
    public static void main(String[] args) {
        // working with prime numbers 
        MyNumber number = new MyNumber(9);
        boolean isPrime = number.isPrime();
        System.out.println("isPrime " + isPrime); 


        // Displaying the names 
        String fullname = "Mbonu Chinedum"; 
        number.displayName(fullname); 
    }
}