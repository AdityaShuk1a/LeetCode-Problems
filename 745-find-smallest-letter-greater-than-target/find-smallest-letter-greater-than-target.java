class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        int mid;
        while(start <= end){
            mid = start + (end - start) / 2;
            
            if(letters[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(end + " " + start);
        return letters[start % letters.length];
    }
}