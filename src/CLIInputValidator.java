/**
 * Parses and validates the command-line arguments provided to the application.
 * This class ensures that all required parameters are present and fall within
 * the expected values before the main logic of the program proceeds.
 */
public class CLIInputValidator {

    private final String[] args;

    private String sorterAlgorithm;
    private String typeOfList;
    private String colorOfPiece;
    private int numberOfPieces;
    private int pauseTime;

    /**
     * Constructs a validator and immediately parses and validates the provided arguments.
     *
     * @param args The command-line arguments from the main method.
     * @throws IllegalArgumentException if any argument is invalid.
     */
    public CLIInputValidator(String[] args) {
        this.args = args;
        parseArguments();
        validateArguments();
    }

    /**
     * Parses the raw string arguments into their corresponding fields.
     * Arguments are expected in a "key=value" format.
     */
    private void parseArguments() {
        for (String arg : args) {
            String[] parts = arg.split("=");
            if (parts.length != 2) {
                System.err.println("Ignoring malformed argument: " + arg);
                continue;
            }

            String key = parts[0].trim().toLowerCase();
            String value = parts[1].trim().toLowerCase();

            switch (key) {
                case "a": // algorithm
                    sorterAlgorithm = value;
                    break;
                case "t": // type of list
                    typeOfList = value;
                    break;
                case "c": // color
                    colorOfPiece = value;
                    break;
                case "r": // number of pieces
                    try {
                        numberOfPieces = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number of pieces: " + value);
                    }
                    break;
                case "s": // pause time
                    try {
                        pauseTime = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid pause time: " + value);
                    }
                    break;
                default:
                    System.err.println("Unknown argument: " + key);
            }
        }
    }

    /**
     * Validates the parsed arguments to ensure they meet the application's requirements.
     *
     * @throws IllegalArgumentException if any validation rule fails.
     */
    private void validateArguments() {
        if (sorterAlgorithm == null || !java.util.Arrays.asList("s", "b", "i", "q", "h", "c", "r", "m").contains(sorterAlgorithm.toLowerCase())) {
            throw new IllegalArgumentException("Invalid sorting algorithm. Allowed: S, B, I, Q, H, C, R, M");
        }

        if (typeOfList == null || !java.util.Arrays.asList("n", "c").contains(typeOfList.toLowerCase())) {
            throw new IllegalArgumentException("Invalid type of list. Allowed: N, C.");
        }

        if (colorOfPiece == null || !java.util.Arrays.asList("b", "w").contains(colorOfPiece.toLowerCase())) {
            throw new IllegalArgumentException("Invalid color of piece. Allowed: B, W.");
        }

        if (!java.util.Arrays.asList(1, 2, 4, 6, 8, 10, 16).contains(numberOfPieces)) {
            throw new IllegalArgumentException("Invalid number of pieces. Allowed: 8, 10, 16.");
        }

        if (pauseTime < 0 || pauseTime > 1000) {
            throw new IllegalArgumentException("Pause time must be between 0 and 1000.");
        }
    }

    //<editor-fold desc="Getters">
    public String getSorterAlgorithm() {
        return sorterAlgorithm;
    }

    public String getTypeOfList() {
        return typeOfList;
    }

    public String getColorOfPiece() {
        return colorOfPiece;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public int getPauseTime() {
        return pauseTime;
    }
    //</editor-fold>

    /**
     * Prints a help message to the console detailing the correct usage and available arguments.
     */
    public static void printHelp() {
        System.out.println("Usage: java Program [arguments]");
        System.out.println("Arguments:");
        System.out.println("  a=<algorithm>     Sorting algorithm (e.g., b");
        System.out.println("  t=<list type>     Type of list sorter (numerical (n) or chars (c) ) (e.g., n)");
        System.out.println("  c=<color>         Color of pieces (white or black)");
        System.out.println("  n=<number>        Number of pieces (8, 10 or 16)");
        System.out.println("  s=<milliseconds>  Pause time between steps (0 - 1000 milliseconds)");
        System.out.println("Example:");
        System.out.println("  java Main a=b t=n c=b n=16 s=100");
    }
}
