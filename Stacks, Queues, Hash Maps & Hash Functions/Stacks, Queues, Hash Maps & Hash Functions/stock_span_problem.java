package Submission_of_Stacks_Queues_Hash_Maps;

import java.util.Stack;

public class stock_span_problem {
    public static void calculateSpan(int[] price, int n, int[] S) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        S[0] = 1;

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && price[st.peek()] <= price[i]) {
                st.pop();
            }
            S[i] = (st.isEmpty()) ? (i + 1) : (i - st.peek());
            st.push(i);
        }
    }

    public static void main(String[] args) {
        int[] price = {10, 4, 5, 90, 120, 80};
        int[] S = new int[price.length];
        calculateSpan(price, price.length, S);
        for (int span : S) {
            System.out.print(span + " ");
        }
    }
}