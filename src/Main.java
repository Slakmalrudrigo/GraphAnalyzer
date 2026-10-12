package src;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomArray customArray = new CustomArray();
    private static CustomStack customStack = new CustomStack();
    private static CustomQueue customQueue = new CustomQueue();
    private static CustomLinkedList customLinkedList = new CustomLinkedList();
    private static Graph graph = new Graph();
    private static PerformanceAnalyzer analyzer = new PerformanceAnalyzer();

    public static void main(String[] args) {

        loadSampleData();

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readIntChoice(1, 9);
            switch (choice) {
                case 1 -> handleArrayMenu();
                case 2 -> handleStackMenu();
                case 3 -> handleQueueMenu();
                case 4 -> handleLinkedListMenu();
                case 5 -> handleSearchingMenu();
                case 6 -> handleGraphMenu();
                case 7 -> analyzer.displayComparisonTable();
                case 8 -> displayAllResults();
                case 9 -> {
                    System.out.println("\nThank you for using Data Structure & Graph Performance Analyzer. Goodbye!");
                    running = false;
                }
            }
        }
    }

    private static void loadSampleData() {

        int[] initialArray = {15, 42, 8, 23, 74, 91, 33, 5, 62};
        for (int val : initialArray) {
            customArray.insert(val);
        }


        customStack.push(10);
        customStack.push(20);
        customStack.push(30);


        customQueue.enqueue(100);
        customQueue.enqueue(200);
        customQueue.enqueue(300);


        customLinkedList.insert(50);
        customLinkedList.insert(60);
        customLinkedList.insert(70);


        graph.addEdge("A", "B", false);
        graph.addEdge("A", "C", false);
        graph.addEdge("B", "D", false);
        graph.addEdge("C", "E", false);
        graph.addEdge("D", "E", false);
        graph.addEdge("E", "F", false);
    }

    private static void printMainMenu() {
       
        System.out.println("      DATA STRUCTURE & GRAPH ANALYZER        ");
        System.out.println("=============================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Linked List Operations");
        System.out.println("5. Searching Operations (Linear vs Binary)");
        System.out.println("6. Graph Operations (BFS / DFS)");
        System.out.println("7. Performance Comparison Table");
        System.out.println("8. Display All Results & Data Structures");
        System.out.println("9. Exit");
        System.out.print("Enter your choice (1-9): ");
    }


    private static void handleArrayMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert Element");
            System.out.println("2. Delete Element");
            System.out.println("3. Search Element");
            System.out.println("4. Display Array");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter choice: ");

            int choice = readIntChoice(1, 5);
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter integer value to insert: ");
                    int val = readInt();
                    customArray.insert(val);
                    System.out.println("Inserted " + val + " into array.");
                }
                case 2 -> {
                    System.out.print("Enter integer value to delete: ");
                    int val = readInt();
                    boolean deleted = customArray.delete(val);
                    if (deleted) System.out.println("Deleted " + val + " from array.");
                    else System.out.println("Value " + val + " not found in array.");
                }
                case 3 -> {
                    System.out.print("Enter integer value to search: ");
                    int target = readInt();
                    PerformanceRecord rec = customArray.linearSearch(target);
                    System.out.println("Result: " + rec.getResultDetails() + " (Steps taken: " + rec.getSteps() + ")");
                }
                case 4 -> customArray.display();
                case 5 -> back = true;
            }
        }
    }

    private static void handleStackMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push (Add to Top)");
            System.out.println("2. Pop (Remove Top)");
            System.out.println("3. Peek (View Top)");
            System.out.println("4. Display Stack");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter choice: ");

            int choice = readIntChoice(1, 5);
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to push: ");
                    int val = readInt();
                    customStack.push(val);
                }
                case 2 -> customStack.pop();
                case 3 -> {
                    Integer topVal = customStack.peek();
                    if (topVal != null) System.out.println("Top element is: " + topVal);
                }
                case 4 -> customStack.display();
                case 5 -> back = true;
            }
        }
    }

    private static void handleQueueMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue (Add to Rear)");
            System.out.println("2. Dequeue (Remove Front)");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display Queue");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter choice: ");

            int choice = readIntChoice(1, 5);
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to enqueue: ");
                    int val = readInt();
                    customQueue.enqueue(val);
                }
                case 2 -> customQueue.dequeue();
                case 3 -> {
                    Integer frontVal = customQueue.peek();
                    if (frontVal != null) System.out.println("Front element is: " + frontVal);
                }
                case 4 -> customQueue.display();
                case 5 -> back = true;
            }
        }
    }

    private static void handleLinkedListMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n------------ LINKED LIST OPERATIONS ------------");
            System.out.println("1. Insert Node");
            System.out.println("2. Delete Node");
            System.out.println("3. Search Node");
            System.out.println("4. Display Linked List");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter choice: ");

            int choice = readIntChoice(1, 5);
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to insert: ");
                    int val = readInt();
                    customLinkedList.insert(val);
                }
                case 2 -> {
                    System.out.print("Enter value to delete: ");
                    int val = readInt();
                    customLinkedList.delete(val);
                }
                case 3 -> {
                    System.out.print("Enter value to search: ");
                    int val = readInt();
                    int idx = customLinkedList.search(val);
                    if (idx != -1) System.out.println("Value " + val + " found at node position " + idx);
                    else System.out.println("Value " + val + " not found in Linked List.");
                }
                case 4 -> customLinkedList.display();
                case 5 -> back = true;
            }
        }
    }

    private static void handleSearchingMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n------------- SEARCHING OPERATIONS ------------");
            System.out.println("Current Array contents:");
            customArray.display();
            System.out.println("1. Perform Linear Search");
            System.out.println("2. Perform Binary Search");
            System.out.println("3. Compare Both (Linear & Binary Search)");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter choice: ");

            int choice = readIntChoice(1, 4);
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter target value to search: ");
                    int target = readInt();
                    PerformanceRecord rec = customArray.linearSearch(target);
                    analyzer.addRecord(rec.getOperation(), rec.getAlgorithm(), rec.getSteps(), rec.getExecutionTimeNs(), rec.getResultDetails());
                    System.out.println("[Linear Search] " + rec.getResultDetails() + " | Steps: " + rec.getSteps() + " | Time: " + rec.getExecutionTimeNs() + " ns");
                }
                case 2 -> {
                    System.out.print("Enter target value to search: ");
                    int target = readInt();
                    PerformanceRecord rec = customArray.binarySearch(target);
                    analyzer.addRecord(rec.getOperation(), rec.getAlgorithm(), rec.getSteps(), rec.getExecutionTimeNs(), rec.getResultDetails());
                    System.out.println("[Binary Search] " + rec.getResultDetails() + " | Steps: " + rec.getSteps() + " | Time: " + rec.getExecutionTimeNs() + " ns");
                }
                case 3 -> {
                    System.out.print("Enter target value to compare: ");
                    int target = readInt();
                    PerformanceRecord recLin = customArray.linearSearch(target);
                    PerformanceRecord recBin = customArray.binarySearch(target);

                    analyzer.addRecord(recLin.getOperation(), recLin.getAlgorithm(), recLin.getSteps(), recLin.getExecutionTimeNs(), recLin.getResultDetails());
                    analyzer.addRecord(recBin.getOperation(), recBin.getAlgorithm(), recBin.getSteps(), recBin.getExecutionTimeNs(), recBin.getResultDetails());

                    System.out.println("\n--- SEARCH COMPARISON RESULT ---");
                    System.out.println("Linear Search: " + recLin.getSteps() + " steps, " + recLin.getExecutionTimeNs() + " ns");
                    System.out.println("Binary Search: " + recBin.getSteps() + " steps, " + recBin.getExecutionTimeNs() + " ns");
                    System.out.println("Difference: Binary Search saved " + Math.max(0, recLin.getSteps() - recBin.getSteps()) + " search steps.");
                }
                case 4 -> back = true;
            }
        }
    }

    private static void handleGraphMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph (Adjacency List)");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Compare Both Traversals (BFS & DFS)");
            System.out.println("7. Return to Main Menu");
            System.out.print("Enter choice: ");

            int choice = readIntChoice(1, 7);
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Vertex label (e.g. A, B, Node1): ");
                    String v = readString();
                    graph.addVertex(v);
                }
                case 2 -> {
                    System.out.print("Enter Source Vertex: ");
                    String src = readString();
                    System.out.print("Enter Destination Vertex: ");
                    String dest = readString();
                    System.out.print("Is Edge Directed? (y/n): ");
                    String dirStr = readString();
                    boolean isDirected = dirStr.equalsIgnoreCase("y");
                    graph.addEdge(src, dest, isDirected);
                }
                case 3 -> graph.displayGraph();
                case 4 -> {
                    System.out.print("Enter Start Vertex for BFS: ");
                    String start = readString();
                    PerformanceRecord rec = graph.bfsTraversal(start);
                    if (rec.getSteps() > 0) {
                        analyzer.addRecord(rec.getOperation(), rec.getAlgorithm(), rec.getSteps(), rec.getExecutionTimeNs(), rec.getResultDetails());
                    }
                }
                case 5 -> {
                    System.out.print("Enter Start Vertex for DFS: ");
                    String start = readString();
                    PerformanceRecord rec = graph.dfsTraversal(start);
                    if (rec.getSteps() > 0) {
                        analyzer.addRecord(rec.getOperation(), rec.getAlgorithm(), rec.getSteps(), rec.getExecutionTimeNs(), rec.getResultDetails());
                    }
                }
                case 6 -> {
                    System.out.print("Enter Start Vertex for Traversal Comparison: ");
                    String start = readString();
                    PerformanceRecord recBfs = graph.bfsTraversal(start);
                    PerformanceRecord recDfs = graph.dfsTraversal(start);

                    if (recBfs.getSteps() > 0 && recDfs.getSteps() > 0) {
                        analyzer.addRecord(recBfs.getOperation(), recBfs.getAlgorithm(), recBfs.getSteps(), recBfs.getExecutionTimeNs(), recBfs.getResultDetails());
                        analyzer.addRecord(recDfs.getOperation(), recDfs.getAlgorithm(), recDfs.getSteps(), recDfs.getExecutionTimeNs(), recDfs.getResultDetails());

                        System.out.println("\n--- GRAPH TRAVERSAL COMPARISON ---");
                        System.out.println("BFS: " + recBfs.getSteps() + " steps, " + recBfs.getExecutionTimeNs() + " ns");
                        System.out.println("DFS: " + recDfs.getSteps() + " steps, " + recDfs.getExecutionTimeNs() + " ns");
                    }
                }
                case 7 -> back = true;
            }
        }
    }











    


    private static int readIntChoice(int min, int max) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                int val = Integer.parseInt(input);
                if (val >= min && val <= max) {
                    return val;
                }
                System.out.print("Invalid choice. Please enter a number between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a valid integer: ");
            }
        }
    }

    private static int readInt() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a valid integer: ");
            }
        }
    }

    private static String readString() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.print("Input cannot be empty. Please enter text: ");
        }
    }
}
