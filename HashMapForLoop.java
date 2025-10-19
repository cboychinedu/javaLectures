// Importing the necesasry modules 
import java.util.HashMap; 

// Creating the class 
public class HashMapForLoop {
    // Running the main function 
    public static void main(String[] args) {
        // Create a hashmap object called people 
        HashMap<String, Integer> people = new HashMap<String, Integer>(); 

        // Add keys and value (name, Age) 
        people.put("John", 32); 
        people.put("Steve", 30); 
        people.put("Angie", 33); 

        // Looping through the hashmap 
        for (String i : people.keySet()) {
            // Displaying the elements in the hasmap 
            System.out.println("Key: " + i + " value: " + people.get(i)); 
        }
    }
}