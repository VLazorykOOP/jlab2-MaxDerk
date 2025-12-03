import java.util.LinkedList;
import java.util.Scanner;

public class Lab23 {
    private LinkedList<Integer> stack;

    public Lab23() {
        stack = new LinkedList<>();
    }

    public void push(int value) {
        stack.addFirst(value);
    }

    public Integer pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack.removeFirst();
    }

    public Integer peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack.getFirst();
    }

    public boolean search(int value) {
        return stack.contains(value);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        System.out.println("Stack: " + stack);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lab23 s = new Lab23();

        System.out.print("Enter stack size: ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            int value = scanner.nextInt();
            s.push(value);
        }

        s.printStack();
        System.out.println("Peeked: " + s.peek());
        System.out.println("Popped: " + s.pop());
        s.printStack();

        System.out.print("Enter value to search: ");
        int searchValue = scanner.nextInt();
        System.out.println(searchValue + " in the stack: " + s.search(searchValue));

        while (!s.isEmpty()) {
            s.pop();
        }

        scanner.close();
    }
}