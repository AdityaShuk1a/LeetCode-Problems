class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] r = new boolean[10][10];
        boolean[][] c = new boolean[10][10];
        boolean[][] b = new boolean[10][10];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){

                    int num = board[i][j] - '0';
                    int b_in  = (i / 3) * 3 + (j / 3);

                    if(r[i][num] == true || c[j][num] == true || b[b_in][num] == true) return false;

                    r[i][num] = true;
                    c[j][num] = true;
                    b[b_in][num] = true;
                }
            }
        }
        return true;
    }
}