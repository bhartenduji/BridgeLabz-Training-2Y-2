package Submission_of_Stacks_Queues_Hash_Maps;

import java.util.Stack;

public class sort_stack_recursion {
    public static void sortStack(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sortStack(s);
            insertSorted(s, x);
        }
    }

    private static void insertSorted(Stack<Integer> s, int x) {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }
        int temp = s.pop();
        insertSorted(s, x);
        s.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(10);
        s.push(40);
        s.push(20);
        sortStack(s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}