class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] placed = new boolean[baskets.length];
        int unplaced = 0;
        for(int i: fruits){
            boolean check = false;
            for(int j = 0; j < baskets.length; j++){
                if(i <= baskets[j] && !placed[j]){
                    placed[j] = true;
                    check = true;
                    break;
                }
            }
            if(check == false){
                unplaced++;
            }
        }
        return unplaced;
    }
}