class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<String>(), res);
        return res;
    }


    public void backtrack(String s, int start, ArrayList<String> curr, List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int end = start; end < s.length(); end++){
            if(isPalin(s, start, end)){
                curr.add(s.substring(start, end+1));
                backtrack(s, end + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPalin(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}