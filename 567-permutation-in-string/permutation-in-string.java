class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> freq1 = new HashMap<>();
        for(char i: s1.toCharArray()){
            freq1.put(i, freq1.getOrDefault(i, 0) + 1);
        }
        int temp = 0;
        HashMap<Character, Integer> freq2 = new HashMap<>();
        int left = 0;
        for(int i = 0; i < s2.length();){

            char c = s2.charAt(i);
            if(freq1.containsKey(c) && freq2.getOrDefault(c, 0) < freq1.get(c)){
                temp++;
                freq2.put(c, freq2.getOrDefault(c, 0) + 1);
                
                if(temp == s1.length()){
                    return true;
                }
                i++;
            }else{
                i = left++;
                temp = 0;
                freq2.clear();
            }

        }

        return false;
    }
}