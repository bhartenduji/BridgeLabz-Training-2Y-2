package Recursion_and_Backtracking;

import java.util.*;

public class n_queens_optimization {

    public static List<List<String>> solveNQueensOptimized(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n]; 
        
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; 
        boolean[] diag2 = new boolean[2 * n - 1]; 
        
        backtrack(0, n, queens, cols, diag1, diag2, solutions);
        return solutions;
    }

    private static void backtrack(int row, int n, int[] queens, boolean[] cols, 
                                  boolean[] diag1, boolean[] diag2, List<List<String>> solutions) {
        if (row == n) {
            solutions.add(generateBoard(queens, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            queens[row] = col;
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row + 1, n, queens, cols, diag1, diag2, solutions);

            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    private static List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueensOptimized(n);
        System.out.println("Total solutions for " + n + "-Queens: " + solutions.size());
    }
}