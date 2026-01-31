class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        HashMap<Integer, ArrayList<Integer>>adj = new HashMap<>();

        for(int i = 1; i < n + 1; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int i[]: dislikes){
            adj.computeIfAbsent(i[0], k -> new ArrayList<>()).add(i[1]);
            adj.computeIfAbsent(i[1], k -> new ArrayList<>()).add(i[0]);
        }
        Arrays.fill(color, 0);
        for(int i = 1; i < n + 1; i++){
            if(color[i] == 0){
                color[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);

                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int j: adj.get(node)){
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