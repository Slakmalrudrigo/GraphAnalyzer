package src;


public class PerformanceRecord {
    private String operation;
    private String algorithm;
    private int steps;
    private long executionTimeNs; // Execution time in nanoseconds
    private String resultDetails;

    public PerformanceRecord(String operation, String algorithm, int steps, long executionTimeNs, String resultDetails) {
        this.operation = operation;
        this.algorithm = algorithm;
        this.steps = steps;
        this.executionTimeNs = executionTimeNs;
        this.resultDetails = resultDetails;
    }

    public String getOperation() {
        return operation;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public int getSteps() {
        return steps;
    }

    public long getExecutionTimeNs() {
        return executionTimeNs;
    }

    public String getResultDetails() {
        return resultDetails;
    }
}
