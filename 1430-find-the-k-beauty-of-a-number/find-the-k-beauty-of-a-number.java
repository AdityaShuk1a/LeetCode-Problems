class Solution {
    public int divisorSubstrings(int num, int k) {
        String number = String.valueOf(num);
        int len = number.length();
        int count = 0;
        for(int i = 0; i <= len - k; i++){
            // if(i + k >= len){
            //     String sub = number.substring(i, len);
            //     int divisor = Integer.parseInt(sub);
            //     if(divisor != 0 && num % divisor == 0) count++;
            // }else{
            String sub = number.substring(i, i + k);
            int divisor = Integer.parseInt(sub);
            if(divisor != 0 && num % divisor == 0) count++;
            // }
        }   
        return count;
    }
}