class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxBit = maxBitwise(nums);
        return bitwiseSets(nums, 0, 0, maxBit);
    }

    public int bitwiseSets(int[] num, int index, int compare, int maxBit){
        if(index == num.length){
            return compare == maxBit ? 1 : 0;
        }

        int i= bitwiseSets(num, index + 1, compare, maxBit);
        int e= bitwiseSets(num, index + 1, compare | num[index], maxBit);
        



        return i + e;
    }

    public int maxBitwise(int[] num){
        int ans = num[0];

        for(int i = 1; i < num.length; i++){
            ans = ans | num[i];
        }

        return ans;
    }
}