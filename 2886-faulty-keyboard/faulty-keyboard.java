class Solution {


    public String finalString(String s) {
        String ans = "";
        StringBuilder result = new StringBuilder(ans);
        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) == 'i'){
                result.reverse();
            }else{
                result.append(s.charAt(i));
            }
        }    
        return result.toString();
    }
}