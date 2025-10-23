class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder("");
        StringBuilder temp = new StringBuilder(s);
        int i = 0;
        while(temp.length() != 2){
            
            if(i < temp.length() - 1){

                int num = ((temp.charAt(i) - '0') + (temp.charAt(i + 1) - '0')) % 10;
                sb.append(Integer.toString(num));
                System.out.print(num + " ");
                i++;
            }else{
                s = temp.toString();
                temp = sb;
                sb = new StringBuilder();
                i = 0;
                System.out.println();
            }

        }
        sb = temp;
        if(sb.charAt(0) == sb.charAt(1)){
            return true;
        }else{
            return false;
        }
    }
}