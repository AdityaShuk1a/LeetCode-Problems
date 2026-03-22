class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] region = new boolean[row][col];

        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O'){
                help(board, region, i, 0, row, col);
            }
            if(board[i][col - 1] == 'O'){
                help(board, region, i, col - 1, row, col);
            }
        }
        for(int i = 0; i < col; i++){
            if(board[0][i] == 'O') help(board, region, 0, i, row, col);
            if(board[row - 1][i] == 'O') help(board, region, row - 1, i, row, col);
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!region[i][j]) board[i][j] = 'X';
            }
        }
    }

    public void help(char[][] board, boolean[][] region, int i, int j, int row, int col){
        if(i < 0 || i >= row || j < 0 || j >= col) return;
        if(region[i][j]) return;
        if(board[i][j] == 'X') return;
        region[i][j] = true;
        int[][] dfs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int[] k: dfs){
            help(board, region, i + k[0], j + k[1], row, col);
        }
    }
}