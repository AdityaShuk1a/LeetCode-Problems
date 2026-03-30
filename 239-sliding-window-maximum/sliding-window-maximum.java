class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int w = n - k + 1;

        if(n == 0 || k == 0){
            return new int[0];
        }

        int ans[] = new int[w];

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < n; i++){

            while(!deque.isEmpty() && deque.peekFirst() <= i - k){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            deque.offerLast(i);
            if(i - k + 1 >= 0){
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }
}