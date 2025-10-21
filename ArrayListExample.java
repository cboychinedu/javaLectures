// Import the necessary modules 
import java.util.List;
import java.util.ArrayList;

// Creating the class 
public class ArrayListExample {
    // Running the main function 
    public static void main(String[] args) {
        // Creating the array list of type string 
        ArrayList<String> items = new ArrayList <String>(); 
        ArrayList<Integer> numbers = new ArrayList <Integer>(); 
        ArrayList<Double> doubleValue = new ArrayList<>(); 
        ArrayList<Float> floatingPointValue = new ArrayList<Float>();

        // other ways of creating array list  
        ArrayList<String> fruits = new ArrayList<>(List.of("Mango", "Apple", "Grape"));

        // Double 
        List <String> words = List.of("Apple", "Bat", "Cat"); 

        // list with integers 
        List <Integer> intergerValue = List.of(3, 4, 5, 6, 1); 

        for (int value: intergerValue) {
            System.out.println(value); 
        }

        // Displaying the list 
        System.out.println(words); 

        // Adding items into the items array list 
        items.add("Pineapple"); 
        items.add("Orange"); 
        items.add("Apple"); 

        // Removing apple from the items array list 
        items.remove("Apple"); 

        // New items 
        System.out.println("item array: " + items); 

        // Adding items into the interger array 
        numbers.add(20); 
        numbers.add(30); 
        numbers.add(40); 

        // Adding items to the double value 
        doubleValue.add(23.45); 
        doubleValue.add(100.234); 

        // Displaying the contents of the array list 
        System.out.println(items); 
        System.out.println(numbers); 

        // using for-loop 
        for (String fruit: fruits) {
            System.out.println("The fruits are: " + fruit); 
        }

        // printing the floating point array 
        System.out.println(floatingPointValue); 

        // Displaying the double value 
        System.out.println("Double value: " + doubleValue); 

    }
}