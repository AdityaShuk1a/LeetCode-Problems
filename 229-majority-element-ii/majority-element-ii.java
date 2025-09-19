class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();  

        for(int i : nums){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> ent: freq.entrySet()){
            int key = ent.getKey();
            int value = ent.getValue();

            if(value > n/3){
                res.add(key);
            }
        }

        return res;
    }
}