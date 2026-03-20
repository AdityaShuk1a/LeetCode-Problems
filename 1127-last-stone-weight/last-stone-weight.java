class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> destroy = new PriorityQueue<>((a, b) -> b - a);
        if(stones.length == 1) return stones[0];
        for(int i: stones){
            destroy.add(i);
        }

        while(destroy.size() != 1){
            if(destroy.size() == 0) break;
            int x = destroy.poll();
            int y = destroy.poll();
            if(x  == y){
                continue;
            }else{
                destroy.add(x - y);
            }
        }

        if(destroy.isEmpty()) return 0;
        return destroy.poll();
    }
}