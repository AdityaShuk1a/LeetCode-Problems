class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int prev = 1;
        int streak = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) == s.charAt(i)){
                streak++;
            }else{
                prev = streak;
                streak = 1;

            }

            if(streak <= prev){
                count++;
            }
            
        }

        return count;
    }
}