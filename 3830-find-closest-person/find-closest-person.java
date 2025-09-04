class Solution {
    public int findClosest(int x, int y, int z) {
        int step1 = Math.abs(z - x);
        int step2 = Math.abs(z - y);

        if(step1 == step2){
            return 0;
        }else if(step1 > step2){
            return 2;

        }else{
            return 1;
        }
    }
}