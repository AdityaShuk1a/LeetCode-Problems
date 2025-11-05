class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        HashSet<ArrayList<Integer>> temp2 = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
           
            HashSet<Integer> set = new HashSet<>();
            

            for (int j = i + 1; j < nums.length; j++) {
                int key = -(nums[i] + nums[j]);

                if (set.contains(key)) {

                ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], key));
                    Collections.sort(temp);
                    temp2.add(temp); 

                }else{
                    set.add(nums[j]);

                }

            }


        }
            res.addAll(temp2);
        return res;
    }

}