class Solution {
    class Pair{
        int idx;
        int count;
        Pair(int idx, int count){
            this.idx = idx;
            this.count = count;
        }
    }
    public int jump(int[] nums) {
        int minJump = Integer.MAX_VALUE;
        boolean vis[] = new boolean[nums.length];
        
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, 0));
        vis[0] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int maxItem = p.idx;
            int count = p.count;
            // if(maxItem >= nums.length) continue;
            if(maxItem == nums.length - 1){
                return count;
            }
            minJump = Math.min(minJump, count); 

            for(int i = 1; i <= nums[maxItem]; i++){
                int newIdx = maxItem + i;
                if(newIdx < nums.length && !vis[newIdx]){
                    vis[newIdx] = true;
                    q.add(new Pair(newIdx, count + 1));
                }

            }
        }

        return -1;
    }
}