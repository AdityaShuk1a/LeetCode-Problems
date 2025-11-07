class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right;
        int maxLen = 0;

        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char check = s.charAt(i);
            freq.put(check, freq.getOrDefault(check, 0) + 1);
            while(freq.get(check) > 1){
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                left++;
                
            }
             maxLen = Math.max(maxLen, i - left + 1);
        }

        return maxLen;
    }
}