class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temp = new Stack<>();
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, 0);
        temp.add(temperatures[0]);
        for(int i = 1; i < temperatures.length; i++){
            int count = 1;
            if(temp.peek() < temperatures[i]){
                ans[i - 1] = count;
                temp.pop();
                count++;
                int left = i - 2;
                while(!temp.isEmpty() && temp.peek() < temperatures[i]){
                    if(ans[left] == 0){
                        ans[left] = count;
                        temp.pop();
                    }
                    count++;
                    left--;
                }
            }
            temp.push(temperatures[i]);
        }

        return ans;
    }
}