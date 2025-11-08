class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int maxShips = n * n;

        int maxShipsNeeded = maxWeight / w;
        if(maxShips < maxShipsNeeded){
            return  maxShipsNeeded - (maxShipsNeeded - maxShips);
        }else{
            return maxShipsNeeded;
        }
    }
}