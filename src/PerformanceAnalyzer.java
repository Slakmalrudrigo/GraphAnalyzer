package src;

import java.util.ArrayList;
import java.util.List;

public class PerformanceAnalyzer {
    private List<PerformanceRecord> records;

    public PerformanceAnalyzer() {
        this.records = new ArrayList<>();
    }


    public void addRecord(String operation, String algorithm, int steps, long executionTimeNs, String details) {
        records.add(new PerformanceRecord(operation, algorithm, steps, executionTimeNs, details));
    }


    public void clearRecords() {
        records.clear();
    }


    public void displayComparisonTable() {
        System.out.println("\n==========================================================================================================");
        System.out.println("                                     PERFORMANCE COMPARISON TABLE                                         ");
        System.out.println("==========================================================================================================");
        System.out.printf("%-20s %-20s %-12s %-18s %-30s%n", "Operation", "Algorithm", "Steps", "Time (ns / ms)", "Result Details");
        System.out.println("----------------------------------------------------------------------------------------------------------");

        if (records.isEmpty()) {
            System.out.println("No performance records collected yet. Run Searching or Graph Traversals first.");
        } else {
            for (PerformanceRecord r : records) {
                double timeMs = r.getExecutionTimeNs() / 1_000_000.0;
                String timeFormatted = String.format("%d ns (%.3f ms)", r.getExecutionTimeNs(), timeMs);
                System.out.printf("%-20s %-20s %-12d %-18s %-30s%n",
                        r.getOperation(),
                        r.getAlgorithm(),
                        r.getSteps(),
                        timeFormatted,
                        r.getResultDetails());
            }
        }
        System.out.println("==========================================================================================================");
    }
}
