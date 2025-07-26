class Solution {
    List<List<String>> ans = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        queens(board, 0); 
        return ans;   
    }

    public int queens(boolean[][] board, int row) {
        if (row == board.length) {
            add(board);
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    public boolean isSafe(boolean[][] board, int row, int col) {
     
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

      
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    public void add(boolean[][] board) {
        List<String> row = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j] ? 'Q' : '.');
            }
            row.add(sb.toString());
        }
        ans.add(row);
    }
}
