class Solution {
    public char repeatedCharacter(String s) {
        int[] letters = new int[26];
        Arrays.fill(letters, 0);

        for(char c: s.toCharArray()){
            letters[c - 'a']++;
            if(letters[c - 'a'] > 1){
                return c;
            }
        }
        return 'a';
    }
}