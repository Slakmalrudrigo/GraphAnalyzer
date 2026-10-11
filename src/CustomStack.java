package src;


public class CustomStack {
    private int[] stack;
    private int top;
    private static final int DEFAULT_CAPACITY = 20;

    public CustomStack() {
        this.stack = new int[DEFAULT_CAPACITY];
        this.top = -1;
    }


    public void push(int value) {
        if (top == stack.length - 1) {
            // Resize stack if full
            int[] newStack = new int[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++top] = value;
        System.out.println("Pushed " + value + " onto stack.");
    }


    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Error: Stack is empty! Cannot perform pop operation.");
            return null;
        }
        int poppedValue = stack[top--];
        System.out.println("Popped " + poppedValue + " from stack.");
        return poppedValue;
    }


    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Error: Stack is empty! Cannot perform peek operation.");
            return null;
        }
        return stack[top];
    }


    public boolean isEmpty() {
        return top == -1;
    }


    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack elements (Top -> Bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println(" | " + stack[i] + " |");
        }
        System.out.println("  ---  ");
    }

    public int getSize() {
        return top + 1;
    }
}
