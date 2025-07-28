class Solution {
    public int numRookCaptures(char[][] board) {
        int r = 0;
        int c = 0;
        int ans = 0;

        // Step 1: Locate the Rook's position
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                    break;
                }
            }
        }

        
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'B') break;
            if (board[i][c] == 'p') {
                ans++;
                break;
            }
        }

        
        for (int i = r + 1; i < board.length; i++) {
            if (board[i][c] == 'B') break;
            if (board[i][c] == 'p') {
                ans++;
                break;
            }
        }

       
        for (int i = c - 1; i >= 0; i--) {
            if (board[r][i] == 'B') break;
            if (board[r][i] == 'p') {
                ans++;
                break;
            }
        }

       
        for (int i = c + 1; i < board[0].length; i++) {
            if (board[r][i] == 'B') break;
            if (board[r][i] == 'p') {
                ans++;
                break;
            }
        }

        return ans;
    }
}
