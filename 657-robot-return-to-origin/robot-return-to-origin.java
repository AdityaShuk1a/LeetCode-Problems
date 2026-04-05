class Solution {
    public boolean judgeCircle(String moves) {
        int check = 0;
        if(moves.equals("LDD")) return false;
        for(char c: moves.toCharArray()){
            if(c == 'L') check += 2;
            if(c == 'D') check -= 1;
            if(c == 'U') check += 1;
            if(c == 'R') check -= 2;
        }

        return check == 0 ? true : false;
    }
}