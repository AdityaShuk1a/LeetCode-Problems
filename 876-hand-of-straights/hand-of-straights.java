class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        if(hand.length % groupSize != 0) return false;
        // else return false;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i: hand){
            arr.add(i);
        }
        int prev = -1;
        int count = 0;
        
        while(!arr.isEmpty()){
            prev = arr.get(0);
            count = 1;
            arr.remove(0);
            for(int i = 0; i < arr.size() && count < groupSize; i++){
                if(prev + 1== arr.get(i)){
                    prev = arr.get(i);
                    arr.remove(i);
                    i--;
                    count++;    
                }
            }

            if(count != groupSize) return false;
        }
        return true;
    }
}