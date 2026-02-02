class Solution {
    class Pair {
        int node;
        int disst;
        
        public Pair(int node, int dist){
            this.node = node;
            this.disst = dist;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = (int) 1e8;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.disst - b.disst);
        for(int i = 0; i < n; i++){
            adj.put(i+1, new ArrayList<>());
        }
        for(int []i : times){
            adj.computeIfAbsent(i[0], e -> new ArrayList<>()).add(new Pair(i[1], i[2]));
        }
        dist[k] = 0;
        q.offer(new Pair(k, 0));
        while(!q.isEmpty()){
            Pair item = q.poll();
            int node = item.node;
            int w = item.disst;

            if(w > dist[node]) continue;
            for(Pair i: adj.get(node)){
                int nei = i.node;
                int wt = i.disst;
                if(dist[node] + wt < dist[nei]){
                    dist[nei] = dist[node] + wt;
                    q.offer(i);
                }
            }

        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < dist.length; i++){
            if(dist[i] == (int)1e8) return -1;
            max = Math.max(dist[i], max);
        }

        return max;
    }
}