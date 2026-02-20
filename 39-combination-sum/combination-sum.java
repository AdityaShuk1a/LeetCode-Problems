class Solution {
    // int[] dp;
    List<List<Integer>> ans = new ArrayList<>();
    public void check(int[] candidates, int target, ArrayList<Integer> temp, int curr, int i){
        if(curr > target){
            return;
        }
        if(curr == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(i >= candidates.length) return;

        temp.add(candidates[i]);

        check(candidates, target, temp, curr + candidates[i], i);
        temp.remove(temp.size() - 1);   
        check(candidates, target, temp, curr, i + 1);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        check(candidates, target, new ArrayList<>(), 0, 0);
        return ans;
    }
}