class Solution {
    public int lengthOfLastWord(String s) {
        String finall = s.trim();
        
        int len = 0;
        for(char c: finall.toCharArray()){
            if(c == ' '){
                len = 0;
            }else{
                len++;
            }

        }

        return len;
    }
}