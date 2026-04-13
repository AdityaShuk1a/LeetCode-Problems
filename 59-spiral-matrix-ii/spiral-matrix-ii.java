class Solution {
    public int[][] generateMatrix(int n) {
        int start = 1;
        int[][] ans = new int[n][n];
        int top = 0;
        int down = n - 1;
        int right = n - 1;
        int left = 0;

        while(top <= down && left <= right){
            for(int i = left; i <= right; i++){
                ans[top][i] = start++;
            }
            top++;
            for(int i = top; i <= down; i++){
                ans[i][right] = start++;
            }
            right--;
            if(top <= down){
                for(int i = right; i >= left; i--){
                    ans[down][i] = start++;
                }
                down--;
            }
            if(left <= right){
                for(int i = down; i >= top; i--){
                    ans[i][left] = start++;
                }
                left++;
            }
        }

        return ans;
    }
}