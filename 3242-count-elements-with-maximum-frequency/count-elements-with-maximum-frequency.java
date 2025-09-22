class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i: nums){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        int max = -1;
        int count = 0;
        for(Map.Entry<Integer, Integer> ent : freq.entrySet()){
            int value = ent.getValue();
            if(max < value){
                max = value;

            }
        }
        int ans = 0;
        for(Map.Entry<Integer, Integer> ent : freq.entrySet()){
            int value = ent.getValue();
            if(max == value){
                ans += value;

            }
        }

        return ans;
    }
}