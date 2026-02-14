class Solution {
    class Pair {
        int node;
        int dist;

        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int len = routes.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < routes[i].length; j++){
                adj.computeIfAbsent(routes[i][j], k -> new ArrayList<>()).add(i);
            }
        }
        HashSet<Integer> visitedBus = new HashSet<>();
        HashSet<Integer> vis = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(source, 0));
        vis.add(source);
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int dist = p.dist;

            if(node == target) return dist;
            
            for(int bus : adj.getOrDefault(node, new ArrayList<>())){
                if(visitedBus.contains(bus)) continue;

                visitedBus.add(bus);
                for(int station: routes[bus]){
                    if(!vis.contains(station)){
                        vis.add(station);
                        q.add(new Pair(station, dist + 1));
                    }
                }
            }
        }

        return -1;
    }
}