package Graphs_DSA;

import java.util.*;

public class island_counter {

    public static void dfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0) return;
        
        grid[r][c] = 0;
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    public static void bfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        grid[r][c] = 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] d : dirs) {
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];
                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1) {
                    grid[nr][nc] = 0;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    public static int countIslands(int[][] grid, boolean useDFS) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        
        int[][] gridCopy = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, gridCopy[i], 0, grid[i].length);
        }

        for (int i = 0; i < gridCopy.length; i++) {
            for (int j = 0; j < gridCopy[0].length; j++) {
                if (gridCopy[i][j] == 1) {
                    count++;
                    if (useDFS) dfs(gridCopy, i, j);
                    else bfs(gridCopy, i, j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 1, 1}
        };

        System.out.println(countIslands(grid, true));
        System.out.println(countIslands(grid, false));
    }
}