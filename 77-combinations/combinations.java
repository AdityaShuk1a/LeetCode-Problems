class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void help(int n, int start, int k, List<Integer> curr){
        if(curr.size() == k){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i <= n; i++){
            curr.add(i);
            help(n, i + 1, k, curr);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        // for(int i = 1; i <= n; i++){
        help(n, 1, k, new ArrayList<>());
        // }

        return res;
    }
}