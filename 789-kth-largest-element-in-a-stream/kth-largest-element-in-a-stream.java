class KthLargest {
    int k;
    PriorityQueue<Integer> check = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i: nums){
            check.offer(i);
        }
    }
    
    public int add(int val) {
        check.add(val);
        while(check.size() > k){
            check.poll();
        }
        return check.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */