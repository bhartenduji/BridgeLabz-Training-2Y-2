package Recursion_and_Backtracking;

public class word_puzzle_game {
    static char[][] grid = {
        {'C', 'A', 'T', 'S'},
        {'O', 'R', 'E', 'A'},
        {'D', 'E', 'A', 'M'},
        {'E', 'L', 'L', 'S'}
    };
    
    static int[] dRow = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dCol = {0, 0, -1, 1, -1, 1, -1, 1};

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && backtrack(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int r, int c, int index, boolean[][] visited) {
        if (index == word.length() - 1) return true;

        visited[r][c] = true; 

        for (int i = 0; i < 8; i++) {
            int newRow = r + dRow[i];
            int newCol = c + dCol[i];

            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length 
                && !visited[newRow][newCol] 
                && board[newRow][newCol] == word.charAt(index + 1)) {
                
                if (backtrack(board, word, newRow, newCol, index + 1, visited)) {
                    return true;
                }
            }
        }

        visited[r][c] = false; 
        return false;
    }

    public static void main(String[] args) {
        String target = "DREAM";
        boolean found = exist(grid, target);
        System.out.println("Can form word '" + target + "': " + found);
    }
}