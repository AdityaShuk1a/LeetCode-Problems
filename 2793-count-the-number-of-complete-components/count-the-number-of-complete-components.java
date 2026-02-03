class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x){
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int u, int v){
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return;
            if(rank[pu] > rank[pv]){
                parent[pv] = pu;
                // rank[pu]++;
            }else if(rank[pu] < rank[pv]){
                parent[pu] = pv;
                // rank[pv]++;
            }else{
                parent[pv] = pu;
                rank[pu]++;
            }
        }

        public int connection(int[][] edge){
            HashMap<Integer, HashSet<Integer>> uni = new HashMap<>();
            HashMap<Integer, Integer> ege = new HashMap<>();
            for(int i = 0; i < parent.length; i++){
                int root = find(i);
                uni.computeIfAbsent(root, k -> new HashSet<>()).add(i);
            }

            for(int[] i: edge){
                int root = find(i[0]);
                ege.put(root, ege.getOrDefault(root, 0) + 1);
            }

            int complete = 0;

            for (int root : uni.keySet()) {
                int ver = uni.get(root).size();
                int eg = ver * ( ver - 1 ) / 2;
                if(ege.getOrDefault(root, 0) == eg){
                    complete++;
                }
            }

            return complete;
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        DSU d = new DSU(n);
        for(int[] i: edges){
            d.union(i[0], i[1]);
        }        
        return d.connection(edges);
    }
}