import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void check(int[] arr, int start, int target, List<Integer> temp){
        
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i < arr.length; i++){
            
            if(i > start && arr[i] == arr[i - 1]) continue;

            if(arr[i] > target) break;

            temp.add(arr[i]);
            check(arr, i + 1, target - arr[i], temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates); 
        
        check(candidates, 0, target, new ArrayList<>());
        
        return ans;
    }
}