class Solution {
    public int maximum69Number (int num) {
        String number = Integer.toString(num);
        char[] arr = number.toCharArray();
        int maxx = num;
        for(int i = 0; i < arr.length; i++){
            StringBuilder temp = new StringBuilder(number);

            if(arr[i] == '6'){
                temp.setCharAt(i, '9');
            }else{
                temp.setCharAt(i, '6');

            }
            int num2 = Integer.parseInt(temp.toString());
            if(num2 > maxx){
                maxx = num2;
            }

        }
        return maxx;
    }
}