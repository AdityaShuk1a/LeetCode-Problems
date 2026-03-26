class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        boolean a = false;
        boolean b = false;
        boolean c = false;

        for(int[] i: triplets){
            if(i[0] <= target[0] && i[1] <= target[1] && i[2] <= target[2]){
                if(i[0] == target[0]) a = true;
                if(i[1] == target[1]) b = true;
                if(i[2] == target[2]) c = true;
            }
        }

        return a && b && c;
    }
}