class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] vis = new boolean[row][col];
        boolean ans = false;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == word.charAt(0)){
                    if(help(board, vis, i, j, row, col, word, 0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean help(char[][] board, boolean[][] vis, int i, int j, int row, int col, String s, int index){
        if(index == s.length()) return true;
        if(i < 0 || i >= row || j < 0 || j >= col || vis[i][j]) return false;
        if(board[i][j] != s.charAt(index)) return false;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        vis[i][j] = true;
        boolean pass = false;
        for(int[] k: dir){
            if(help(board, vis, i + k[0], j + k[1], row, col, s, index + 1)){
                return true;
            }
        }

        vis[i][j] = false;
        return false;

    }
}