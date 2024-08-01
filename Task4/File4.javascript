import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VotingSystem {
    // Map to store vote counts for each option
    private static Map<String, Integer> votes = new HashMap<>();
    
    public static void main(String[] args) {
        // Initialize options
        votes.put("Option 1", 0);
        votes.put("Option 2", 0);
        votes.put("Option 3", 0);

        Scanner scanner = new Scanner(System.in);
        String input;
        
        while (true) {
            System.out.println("Online Voting System");
            System.out.println("1. Vote for Option 1");
            System.out.println("2. Vote for Option 2");
            System.out.println("3. Vote for Option 3");
            System.out.println("4. Show Results");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            input = scanner.nextLine();
            
            switch (input) {
                case "1":
                    castVote("Option 1");
                    break;
                case "2":
                    castVote("Option 2");
                    break;
                case "3":
                    castVote("Option 3");
                    break;
                case "4":
                    showResults();
                    break;
                case "5":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    // Method to cast a vote for a given option
    private static void castVote(String option) {
        if (votes.containsKey(option)) {
            votes.put(option, votes.get(option) + 1);
            System.out.println("Vote cast for " + option + "!");
        } else {
            System.out.println("Invalid option.");
        }
    }
    
    // Method to display the current vote counts
    private static void showResults() {
        System.out.println("Current Vote Counts:");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.p
