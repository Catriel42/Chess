public class Main {

    public static void main(String[] args) {
        try {
            // 1. Validate command line arguments
            CLIInputValidator validator = new CLIInputValidator(args);

            // 2. Initialize and run the chess game manager
            new ChessManager(validator);

        } catch (IllegalArgumentException e) {
            // If validation fails, print a helpful error message
            System.err.println("Error: " + e.getMessage());
            System.err.println();
            CLIInputValidator.printHelp();
        } catch (Exception e) {
            // Catch any other unexpected errors
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
