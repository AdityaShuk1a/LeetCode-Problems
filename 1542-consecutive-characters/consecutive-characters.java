class Solution {
    public int maxPower(String s) {
        int max = 1;
        int temp = 1;
        if(s.length() == 1){
            return 1;
        }
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                temp++;
            }else{
                max = max > temp ? max : temp;
                temp = 1;
            }
        }
        return Math.max(max, temp);
    }   
}