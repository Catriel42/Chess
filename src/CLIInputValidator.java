public class CLIInputValidator {

    private final String[] args;

    private String sorterAlgorithm;
    private String typeOfList;
    private String colorOfPiece;
    private int numberOfPieces;
    private int pauseTime;

    public CLIInputValidator(String[] args) {
        this.args = args;
        parseArguments();
        validateArguments();
    }

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

    private void validateArguments() {
        if (sorterAlgorithm == null || !java.util.Arrays.asList("s", "b", "i", "q", "h", "c", "r").contains(sorterAlgorithm.toLowerCase())) {
            throw new IllegalArgumentException("Invalid sorting algorithm. Allowed: S, B, I, Q, H, C, R.");
        }

        if (typeOfList == null || !java.util.Arrays.asList("n", "c").contains(typeOfList.toLowerCase())) {
            throw new IllegalArgumentException("Invalid type of list. Allowed: N, C.");
        }

        if (colorOfPiece == null || !java.util.Arrays.asList("b", "w").contains(colorOfPiece.toLowerCase())) {
            throw new IllegalArgumentException("Invalid color of piece. Allowed: B, W.");
        }

        if (!java.util.Arrays.asList(1, 2, 4, 6, 8, 10, 16).contains(numberOfPieces)) {
            throw new IllegalArgumentException("Invalid number of pieces. Allowed: 1, 2, 4, 6, 8, 10, 16.");
        }

        if (pauseTime < 100 || pauseTime > 1000) {
            throw new IllegalArgumentException("Pause time must be between 100 and 1000.");
        }
    }

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

    public static void printHelp() {
        System.out.println("Usage: java Program [arguments]");
        System.out.println("Arguments:");
        System.out.println("  a=<algorithm>     Sorting algorithm (e.g., bubble, merge, quick)");
        System.out.println("  t=<list type>     Type of list (e.g., arraylist, linkedlist)");
        System.out.println("  c=<color>         Color of pieces (white or black)");
        System.out.println("  n=<number>        Number of pieces (1-32)");
        System.out.println("  s=<milliseconds>  Pause time between steps");
        System.out.println("Example:");
        System.out.println("  java Main a=bubble t=arraylist c=white n=16 s=500");
    }
}
