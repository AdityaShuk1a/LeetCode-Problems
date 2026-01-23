class Solution {

    public boolean check(int[] nums, int idx, boolean[] visited){
        if(idx >= nums.length || idx < 0 || visited[idx]) return false;
        
        if(idx == nums.length - 1) return true;

        visited[idx] = true;

        int maxJump = nums[idx];
        for(int i = 1; i <= maxJump; i++){
            if(check(nums, idx + i, visited)) return true;
        }

        return false; 
    }

    public boolean canJump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        return check(nums, 0, visited);
    }
}
