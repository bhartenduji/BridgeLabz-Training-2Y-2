package Submission_of_Stacks_Queues_Hash_Maps;

import java.util.Stack;

public class queue_using_stacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int x) {
        s1.push(x);
    }

    public int dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty()) return -1;
        return s2.pop();
    }

    public static void main(String[] args) {
        queue_using_stacks q = new queue_using_stacks();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}