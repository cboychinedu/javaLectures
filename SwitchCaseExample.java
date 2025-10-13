public class SwitchCaseExample {
    public static void main(String[] args) {
        // Setting the day 
        int day = 4;

        // Saving the day name 
        String dayName;

        // Using the switch case 
        dayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };

        // Displaying the day for the switch case. 
        System.out.println("Day " + day + " is " + dayName);
    }
}