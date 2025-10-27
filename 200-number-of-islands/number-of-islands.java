class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int count = 0;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        } 

        return count;
    }

    public void dfs(char[][] grid, int row, int col){
        int numRow = grid.length;
        int numCol = grid[0].length;

        if(row < 0 || col < 0 || row >= numRow || col >= numCol){
            return;
        }
        grid[row][col] = '0';
        if(row + 1 < numRow){
            if( grid[row + 1][col] == '1'){
                dfs(grid, row + 1, col);
            }
        }
        if(col + 1 < numCol){
            if(grid[row][col + 1] == '1'){
                dfs(grid, row, col + 1);
            }

        }
        if(row - 1 > -1){

            if(grid[row - 1][col] == '1'){
                dfs(grid, row - 1, col);
            }
        }
        if(col - 1 > - 1){
            if(grid[row][col - 1] == '1'){
                dfs(grid, row, col - 1);
            }

        }
        

    }


}