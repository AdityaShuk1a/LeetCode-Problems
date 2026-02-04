class Solution {
    int[] parent;
    int[] size;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        size = new int[edges.length + 1];

        for(int i = 0; i < edges.length; i++){
            parent[i] = i;
            size[i] = 0;
        }

        for(int[] i: edges){
            int pu = find(i[0]);
            int pv = find(i[1]);

            if(pu == pv){
                return i;
            }else if(size[pu] > size[pv]){
                parent[pv] = pu;
                size[pu]++;
            }else{
                parent[pu] = pv;
                size[pv]++;
            }
        }

        return new int[0];
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
}
