class Solution {

    // public boolean check(int[] nums, int idx, boolean[] visited){
    //     if(idx >= nums.length || idx < 0 || visited[idx]) return false;
        
    //     if(idx == nums.length - 1) return true;

    //     visited[idx] = true;

    //     int maxJump = nums[idx];
    //     for(int i = 1; i <= maxJump; i++){
    //         if(check(nums, idx + i, visited)) return true;
    //     }

    //     return false; 
    // }

    // public boolean bfs(int[] nums, int idx, boolean[] vis){
    //     if(idx >= nums.length || idx < 0 || visited[idx]) return false;

    //     if(idx == nums.length - 1) return true;

    //     visited[idx] = true;

        
    // }

    public boolean canJump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        
        Queue<Integer> items = new LinkedList<>();
        int idx = 0;
        visited[0] = true;
        items.add(0);

        while(!items.isEmpty()){

            idx =  items.poll();
            if(idx >= nums.length) continue;
            visited[idx] = true;
            if(idx == nums.length - 1) return true;

            int maxItem = nums[idx];

            visited[idx] = true;
            for(int i = 1; i <= maxItem; i++){
                int next = idx + i;
                if (next < nums.length && !visited[next]) {
                    visited[next] = true;
                    items.add(idx + i);
                }
            }
        }

        return false;

    }
}
