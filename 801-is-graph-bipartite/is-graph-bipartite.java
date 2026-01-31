class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        // HashMap<Integer, ArrayList<Integer>>adj = new HashMap<>();

        // for(int i = 0; i < n; i++){
        //     adj.put(i, new ArrayList<>());
        // }
        Arrays.fill(color, 0);
        for(int i = 0; i < graph.length; i++){
            if(color[i] == 0){
                color[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);

                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int j: graph[node]){
                        if(color[j] == 0){
                            color[j] = -color[node];
                            q.add(j);
                        }else if(color[j] == color[node]) return false;
                    }
                }
            }
        }   
        return true;
    }
}