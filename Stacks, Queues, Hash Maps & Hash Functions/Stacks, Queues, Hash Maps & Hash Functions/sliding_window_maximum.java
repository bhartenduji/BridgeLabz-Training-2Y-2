package Submission_of_Stacks_Queues_Hash_Maps;

import java.util.Deque;
import java.util.LinkedList;

public class sliding_window_maximum {
    public static void printMax(int[] arr, int k) {
        Deque<Integer> Qi = new LinkedList<>();
        int i;
        for (i = 0; i < k; ++i) {
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
                Qi.removeLast();
            }
            Qi.addLast(i);
        }
        for (; i < arr.length; ++i) {
            System.out.print(arr[Qi.peek()] + " ");
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k) {
                Qi.removeFirst();
            }
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()]) {
                Qi.removeLast();
            }
            Qi.addLast(i);
        }
        System.out.print(arr[Qi.peek()] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        printMax(arr, k);
    }
}