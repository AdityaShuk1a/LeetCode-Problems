class Solution {
    public void setZeroes(int[][] matrix) {
        String[][] check = new String[matrix.length][matrix[0].length];
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(matrix[row][col] == 0){
                    check[row][col] = "Default";
                }
            }
        }
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(matrix[row][col] == 0 && check[row][col] == "Default"){
                    changeToZero(matrix, check, row, col);
                }
            }
        }

    }

    public void changeToZero(int[][] matrix, String[][] check, int i, int j){
        //for row

        for(int col = 0; col < matrix[0].length; col++){
            if(check[i][col] != "Default"){
                check[i][col] = "Changed";
            }
            matrix[i][col] = 0;
        }
        //for column
        for(int row = 0; row < matrix.length; row++){
            if(check[row][j] != "Default"){
                check[row][j] = "Changed";
            }
            matrix[row][j] = 0;
        }
    }
}