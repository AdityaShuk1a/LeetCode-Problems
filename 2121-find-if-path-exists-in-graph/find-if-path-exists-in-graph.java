class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Queue<Integer> q  = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for(int[] i: edges){
            adj.computeIfAbsent(i[0], k -> new ArrayList<>()).add(i[1]);
            adj.computeIfAbsent(i[1], k -> new ArrayList<>()).add(i[0]);
        }
        boolean[] vis = new boolean[n];

        vis[source] = true;

        q.add(source);

        while(!q.isEmpty()){
            int node = q.poll();
            if(node == destination) return true;
            
            ArrayList<Integer> nei = adj.get(node);

            for(int ne: nei){
                if(!vis[ne]){
                    vis[ne] = true;
                    q.add(ne);
                }
            }
        }

        return false;

    }
}