class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> map = new HashMap<>();


        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);

        }


        int maxVowel = 0;
        int maxConsonant = 0;

        for(Map.Entry<Character, Integer> ent : map.entrySet()){
            char key = ent.getKey();
            int freq = ent.getValue();

            if(key == 'a' || key == 'e' || key == 'i' || key == 'o' || key == 'u'){
                
                if(maxVowel < freq){
                    maxVowel = freq;
                }
            } else {
                if(maxConsonant < freq){
                    maxConsonant = freq;
                }
            }
        }

        return maxVowel + maxConsonant;
    }
}