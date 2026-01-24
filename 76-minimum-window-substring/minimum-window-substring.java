class Solution {
    public String minWindow(String s, String t) {
        int count = t.length();
        int start = -1;

        int minLen = Integer.MAX_VALUE;

        HashMap<Character, Integer> freq = new HashMap<>();

        for(char c: t.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;

        int n = s.length();

        while(right < n){
            char r = s.charAt(right);

            if(freq.containsKey(r)){
                if(freq.get(r) > 0) { count--; }
                freq.put(r, freq.get(r) - 1);
            }

            while(count == 0){
                if(minLen > (right - left + 1)){
                    minLen = right - left + 1;
                    start = left;
                }

                char l = s.charAt(left);

                if(freq.containsKey(l)){
                    freq.put(l, freq.get(l) + 1);
                    if(freq.get(l) > 0) { count++; }
                }
                left++;
            }
            right++;
        }

        if(start == -1) return "";

        StringBuilder ans = new StringBuilder("");

        for(int i = start; i < start + minLen; i++){
            ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}