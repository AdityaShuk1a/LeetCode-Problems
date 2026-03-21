class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        help(0, 0, "", n);
        return ans;
    }

    public void help(int left, int right, String s, int n){
        if(s.length() == n * 2){
            ans.add(s);
            return;
        }

        if(left < n){
            help(left + 1, right, s + "(", n);
        }

        if(right < left){
            help(left, right + 1, s + ")", n);
        }

    }
}