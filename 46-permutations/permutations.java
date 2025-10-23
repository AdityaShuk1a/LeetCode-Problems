class Solution {

    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();

        ArrayList<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        backtrack(arr, curr, res, used);
        return res;

    }


    public void backtrack(int[] arr, ArrayList<Integer> curr, List<List<Integer>> res, boolean[] used){
        if(curr.size() == arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(!used[i]){
                used[i] = true;
                curr.add(arr[i]);
                backtrack(arr, curr, res, used);
                used[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}
