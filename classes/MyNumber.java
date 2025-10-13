// Add this line to the top of your MyNumber.java file
package classes;

public class MyNumber {
    // Setting the number 
    public int number;

    // Adding a constructor method 
    public MyNumber(int number) {
        this.number = number;
    }

    public void displayName(String fullname) {
        // Displaying the name 
        System.out.println(fullname); 
    }

    // The method signature for isPrime() needs to be fixed.
    // It should operate on the instance variable 'this.number'
    public boolean isPrime() {
        if (this.number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(this.number); i++) {
            if (this.number % i == 0) {
                return false;
            }
        }
        return true;
    }
}