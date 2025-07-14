class Solution {
    public int numberOfSteps(int num) {
        return step(num, 0);
    }
    public int step(int num, int steps){
        if(num == 0) return steps;

        if((num & 1) == 1){
            return step(num - 1, steps + 1 );
        }else{
            return step(num/2, steps + 1 );

        }
    }
}