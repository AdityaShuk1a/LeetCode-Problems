class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int num = prices[0];

        for(int i = 1; i < prices.length; i++){
            if(num > prices[i]){
                num = prices[i];
            }else{

                maxP = Math.max(maxP, prices[i] - num);
            }

        }

        return maxP;
    }
}