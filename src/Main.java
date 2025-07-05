import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long startCpuTime = threadMXBean.isCurrentThreadCpuTimeSupported() ? threadMXBean.getCurrentThreadCpuTime() : 0;

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
        } finally {
            long endTime = System.nanoTime();
            long endCpuTime = threadMXBean.isCurrentThreadCpuTimeSupported() ? threadMXBean.getCurrentThreadCpuTime() : 0;

            long totalTime = (endTime - startTime) / 1_000_000; // milliseconds
            long cpuTime = (endCpuTime - startCpuTime) / 1_000_000; // milliseconds

            System.out.println("\n--- Execution Times ---");
            System.out.println("Total Program Execution Time: " + totalTime + " ms");
            if (threadMXBean.isCurrentThreadCpuTimeSupported()) {
                System.out.println("CPU Time: " + cpuTime + " ms");
            } else {
                System.out.println("CPU Time: Not supported on this JVM.");
            }
        }
    }
}
