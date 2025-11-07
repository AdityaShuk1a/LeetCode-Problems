class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int[] freq = new int[26];
        int maxO = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            maxO = Math.max(maxO, ++freq[s.charAt(i) - 'A']);
            if((i - left - maxO + 1) > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            

            maxLen = Math.max(maxLen, i- left + 1 );
        }

        return maxLen;
    }
}