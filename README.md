# CIT300 Data Structures and Algorithms
## Graded Practical Assignment 2 

###  Team Member Details & Individual Contributions

#### Member 1:
- **Student Name:** M.H.Fathima Mafaza
- **Student ID:** 23DA2_0106
- **Assigned Responsibility:** Array and Searching Implementation
- **Individual Contribution:**
  - Designed and implemented `CustomArray` class with Insert, Delete, Search, and Display operations.
  - Implemented Linear Search and Binary Search with step counting and execution timing.
  - Handled array resizing and search verification.

#### Member 2:
- **Student Name:** M.I.Mohamed Thasrif
- **Student ID:** 23DA2_0100
- **Assigned Responsibility:** Stack and Queue Implementation
- **Individual Contribution:**
  - Implemented `CustomStack` class with Push, Pop, Peek, Display, and empty stack validation.
  - Implemented `CustomQueue` class with Enqueue, Dequeue, Peek, Display, and empty queue validation.
  - Solved boundary conditions and overflow/underflow handling.

#### Member 3:
- **Student Name:** A.M.Nowfa Begum
- **Student ID:** 23DA2_0310
- **Assigned Responsibility:** Linked List Implementation
- **Individual Contribution:**
  - Developed `CustomLinkedList` class with dynamic Node pointer manipulation.
  - Implemented Linked List operations: Insert, Delete, Search, and Display.
  - Verified pointers and null pointer safety across operations.

#### Member 4:
- **Student Name:** M.R.Asheef Mohamed 
- **Student ID:** 23DA2_0099
- **Assigned Responsibility:** Graph Implementation and Traversals
- **Individual Contribution:**
  - Implemented `Graph` class using Adjacency List representation.
  - Added Vertex and Edge (directed and undirected) management.
  - Implemented Breadth-First Search (BFS) using Queue.
  - Implemented Depth-First Search (DFS) using Recursion.
  - Recorded step counts and execution timings for graph traversals.

#### Member 5 / Integration:
- **Student Name:** K.S.Lakmal Rudrigo
- **Student ID:** 23DA2_0416
- **Assigned Responsibility:** Main Menu System, Performance Comparison Table & Integration
- **Individual Contribution:**
  - Designed interactive console menu system with input validation.
  - Implemented `PerformanceAnalyzer` and `PerformanceRecord` classes for metrics aggregation.
  - Integrated all subcomponents into a unified system.
  - Built sample dataset loader and verified execution flow.

---

###  How to Compile and Run

#### Prerequisites
- Java Development Kit (JDK 17 or higher recommended).

#### Step 1: Open Terminal / Command Prompt
Navigate to the root directory of the project:
```bash
cd d:/Projects/GraphAnalyzer
```

#### Step 2: Compile Java Source Files
```bash
javac -d bin src/*.java
```

#### Step 3: Run the Application
```bash
java -cp bin src.Main
```

---

###  System Features & Menu Overview

1. **Array Operations:** Insert, Delete, Search, and Display array elements.
2. **Stack Operations:** Push, Pop, Peek, and Display LIFO stack elements safely.
3. **Queue Operations:** Enqueue, Dequeue, Peek, and Display FIFO queue elements safely.
4. **Linked List Operations:** Insert, Delete, Search, and Display singly linked list nodes.
5. **Searching Operations:** Compare Linear Search vs Binary Search with step counting and nanosecond timing.
6. **Graph Operations:** Add Vertices/Edges, view Adjacency List, and run BFS & DFS traversals.
7. **Performance Comparison Table:** Tabular summary displaying steps taken and execution speed.
8. **Display All Results:** Comprehensive snapshot of all active data structure contents.

---

###  Algorithmic Complexity Explanation (Simple Guide)

| Operation / Algorithm | Best Time | Average Time | Worst Time | Space | Explanation |
|---|---|---|---|---|---|
| **Linear Search** | O(1) | O(n) | O(n) | O(1) | Scans elements one by one from left to right. |
| **Binary Search** | O(1) | O(log n) | O(log n) | O(1) | Requires sorted array. Halves the search space at each step. |
| **Stack Push/Pop** | O(1) | O(1) | O(1) | O(n) | Direct index manipulation at top of stack. |
| **Queue Enqueue/Dequeue** | O(1) | O(1) | O(1) | O(n) | Front and rear pointer adjustments. |
| **Linked List Insert/Delete** | O(1) | O(n) | O(n) | O(n) | Fast pointer update once position is found. |
| **Graph BFS / DFS** | O(V + E) | O(V + E) | O(V + E) | O(V) | Visits every vertex V and edge E once during traversal. |

---

### Video Presentation Outline (Under 15 Minutes)

1. **Introduction:** State Name, Student ID, and assigned module.
2. **Code Explanation:** Briefly walk through relevant classes and methods.
3. **Live Demonstration:** Run options in the main menu to show operations working live.
4. **Complexity Explanation:** Explain step counts and execution time differences.
5. **Integration:** Demonstrate how your component feeds into the Performance Comparison Table.
