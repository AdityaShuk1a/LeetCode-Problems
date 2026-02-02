class Solution {
    class Pair{
        int node;
        int cost;
        int wt;
        public Pair(int node, int cost, int wt){
            this.node = node;
            this.cost = cost;
            this.wt = wt;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] i: flights){
            adj.computeIfAbsent(i[0], e -> new ArrayList<>()).add(new Pair(i[1], i[2], 0));
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(src, 0, 0));
        dist[src] = 0;
        // int cheap = -1;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int cost = p.cost;
            int wt = p.wt;
            if(wt > k) continue;
            
            for(Pair i: adj.get(node)){
                int nei = i.node;
                int c = i.cost + cost;
                if(c < dist[nei] ){
                    dist[nei] = c;
                    q.offer(new Pair(nei, c, wt + 1));
                }
            }
        } 
        return dist[dst] == Integer.MAX_VALUE ? -1: dist[dst];
    }
}