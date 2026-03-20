class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> num = new PriorityQueue<>((a, b) -> a - b);

        for(int i: nums){
            num.add(i);
            if(num.size() > k){
                num.poll();
            }
        }

        int ans = -1;
        // while(!num.isEmpty()){
        //     ans = num.poll();
        // }
        return num.poll();
    }
}