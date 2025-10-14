public class SwitchCase {

    public static void main(String[] args) {

        String day = "Saturday";

        switch (day) {
            case "Monday":
                System.out.println("Start of the work week!");
                break;

            case "Tuesday":
                System.out.println("Second day of the week!");
                break;

            case "Wednesday":
                System.out.println("Midweek motivation!");
                break;

            case "Thursday":
                System.out.println("Almost the weekend!");
                break;

            case "Friday":
                System.out.println("Weekend is here!");
                break;

            case "Saturday":
                System.out.println("Saturday"); 
                break; 

            case "Sunday": // combining cases
                System.out.println("It's the weekend! Time to rest!");
                break;

            default:
                System.out.println("Invalid day entered!");
                break;
        }
    }
}
