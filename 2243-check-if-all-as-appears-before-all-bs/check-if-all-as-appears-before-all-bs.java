class Solution {
    public boolean checkString(String s) {
        boolean isA = false;
        boolean isB = false;
        int len = s.length();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);

            if(c == 'a' && !isB) isA = true;
            else if(c == 'b') isB = true;
            else return false;
        }

        return true;
    }
}