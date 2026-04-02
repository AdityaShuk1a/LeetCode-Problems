class Solution {
    class Pair{
        int node;
        int dist;

        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int ans = -1;
        HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();

        int[] dist = new int[n + 1];
        for(int[] i: times){
            adj.computeIfAbsent(i[0], l -> new ArrayList<>()).add(new Pair(i[1], i[2]));
        }
        for(int i = 0; i <= n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        boolean[] vis = new boolean[n];
        pq.add(new Pair(k, 0));
        dist[k] = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int dis = p.dist;
            if (dis > dist[node]) continue;
            if(!adj.containsKey(node)){
                continue;
            }
            ArrayList<Pair> nei = adj.get(node);

            for(Pair l: nei){
                if(dist[l.node] > dis + l.dist){
                    dist[l.node] = dis + l.dist;
                    pq.add(new Pair(l.node, dist[l.node]));
                }
            }

        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;

    }
}