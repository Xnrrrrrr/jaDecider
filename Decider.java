import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Decider {
    // ANSI color codes for better formatting
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BOLD = "\033[1m";

    public static void main(String[] args) {
        // Display ASCII art and introductory message
        displayIntroduction();

        // Seed the random number generator
        Random random = new Random(System.currentTimeMillis());

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                // Display steps in blue
                displaySteps();

                // Get choices from the user
                List<String> choices = getUserChoices(scanner);

                // Randomly select a choice
                String selectedChoice = getRandomChoice(choices, random);

                // Display the selected choice with ASCII art and color
                displayDecision(selectedChoice);

                // Ask if the user wants to make another decision
                System.out.print("\nDo you want to make another decision? (yes/no): ");
            } while (scanner.nextLine().equalsIgnoreCase("yes"));

            // Display farewell message
            displayFarewell();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Display ASCII art and introductory message
    private static void displayIntroduction() {
        System.out.printf("%s=============================================%s\n", ANSI_RED, ANSI_RESET);
        System.out.printf("|               DECISION MAKER              |\n");
        System.out.printf("%s=============================================%s\n", ANSI_RED, ANSI_RESET);
        System.out.printf("%s >> Written by %sXnrrrrrr%s\n", ANSI_RED, ANSI_BOLD, ANSI_RESET);
    }

    // Display steps in blue
    private static void displaySteps() {
        System.out.println("\n" + ANSI_BLUE + "============================================="+ ANSI_RESET);
        System.out.printf("|                   STEPS                   %s|\n", ANSI_RESET);
        System.out.println( ANSI_BLUE +"============================================="+ ANSI_RESET);
        System.out.println("Enter your choices (one per line), press Enter when finished.");
        System.out.println("Press Enter with a blank choice to decide." + ANSI_RESET);
    }

    // getUserChoices gets choices from the user
    private static List<String> getUserChoices(Scanner scanner) {
        List<String> choices = new ArrayList<>();

        // ASCII art for the input prompt
        while (true) {
            System.out.print(ANSI_BLUE + "Choice: " + ANSI_RESET);
            String choice = scanner.nextLine();

            // Treat blank input as 'done'
            if (choice.trim().isEmpty()) {
                break;
            }

            choices.add(choice);
        }

        return choices;
    }

    // getRandomChoice randomly selects a choice from the provided list
    private static String getRandomChoice(List<String> choices, Random random) {
        if (choices.isEmpty()) {
            System.out.println("No choices provided.");
            System.exit(1);
        }

        int index = random.nextInt(choices.size());
        return choices.get(index);
    }

    // Display the decision with ASCII art and color
    private static void displayDecision(String selectedChoice) {
        System.out.printf("\n%s=============================================%s\n", ANSI_RED, ANSI_RESET);
        System.out.printf("|               DECISION MAKER               |\n");
        System.out.printf("%s=============================================%s\n", ANSI_RED, ANSI_RESET);
        System.out.println("\n" + ANSI_BLUE + "   Randomly selected choice: " + selectedChoice + ANSI_RESET);
    }

    // Display farewell message with ASCII art and color
    private static void displayFarewell() {
        System.out.printf("\n%s=============================================%s\n", ANSI_RED, ANSI_RESET);
        System.out.printf("|          THANK YOU FOR USING DECIDER          |\n");
        System.out.printf("%s=============================================%s\n", ANSI_RED, ANSI_RESET);
    }
}
