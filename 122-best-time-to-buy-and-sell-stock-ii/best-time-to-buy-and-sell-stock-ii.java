class Solution {
    public int maxProfit(int[] prices) {
        ArrayList<Integer> profit = new ArrayList<>();
        int num = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < prices[i - 1]){

                profit.add(maxProfit);
                num = prices[i];
                maxProfit = 0;
            }else{

                maxProfit = Math.max(maxProfit, prices[i] - num);
            }
            
        }
        profit.add(maxProfit);
        int ans = 0;
        for(int i : profit){
            System.out.print(i + " ");
            ans += i;
        }

        return ans;
    }
}