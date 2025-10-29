class Solution {
    public int smallestNumber(int n) {
        StringBuilder binaryString =new StringBuilder(Integer.toBinaryString(n));
        int ans = -1;
        int power = binaryString.length();
        return (int)(Math.pow(2, power) - 1);
        



       
    }

   
    
}