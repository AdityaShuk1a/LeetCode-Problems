class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for(List<Integer> i: edges){
            adj.computeIfAbsent(i.get(0), k -> new ArrayList<>()).add(i.get(1));
        }

        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        int node = 0;
        Arrays.fill(vis, false);
        int[] degree = new int[n];
        Arrays.fill(degree, 0);
        for(int i = 0; i < n; i++){
            if(vis[i]){
                continue;
                // degree[i]++;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            vis[i] = true;
            while(!q.isEmpty()){
                int item = q.poll();
                ArrayList<Integer> neig = adj.get(item);
                if(neig == null) continue;
                for(int j: neig){
                    degree[j]++;
                    if(!vis[j]){
                        vis[j] = true;
                        q.add(j);
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(degree[i] == 0){
                ans.add(i);
            }
        }

        return ans;
    }
}