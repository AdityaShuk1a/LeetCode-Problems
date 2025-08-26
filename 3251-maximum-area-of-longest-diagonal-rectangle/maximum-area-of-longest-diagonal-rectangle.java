class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiag = -1;
        int index = 0;
        for(int i = 0; i < dimensions.length; i++){
            int length = dimensions[i][0];
            int width = dimensions[i][1];
            double diagonal = Math.sqrt((length * length) + (width * width));
            if(diagonal > maxDiag){
                maxDiag = diagonal;
                index = i;
            }else if(diagonal == maxDiag){
                int currentArea = length * width;
                int storedArea = dimensions[index][0] * dimensions[index][1];
                if(currentArea > storedArea){
                    index = i;
                }
            }
        }

        return dimensions[index][0] * dimensions[index][1];
    }
}