// Importing the hashmap 
import java.util.Map; 
import java.util.HashMap; 

// Running the main class 
public class Maps{
    // Running the main function 
    public static void main(String[] args) {
        // Creating the map 
        Map<String, Integer> map = Map.of("A", 20); 

        System.out.println(map); 

        // Creating a hashmap 
        Map<String, Integer> hashmap = new HashMap<>(map); 

        // displaying the hashmap 
        System.out.println(hashmap); 


    }
}