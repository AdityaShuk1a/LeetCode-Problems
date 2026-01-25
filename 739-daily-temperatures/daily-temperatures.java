class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> temp = new Stack<>();
        int len = temperatures.length;
        int[] ans = new int[len];
        Arrays.fill(ans, 0);
        temp.push(new int[]{temperatures[0], 0});

        for(int i = 1; i < len; i++){
            int key = temperatures[i];
            while(!temp.isEmpty() && temp.peek()[0] < key){
                ans[temp.peek()[1]] = i - temp.peek()[1];
                temp.pop();
            }
            temp.push(new int[]{key, i});
        }

        return ans;
    }
}