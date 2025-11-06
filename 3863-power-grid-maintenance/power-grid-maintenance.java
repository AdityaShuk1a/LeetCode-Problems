class Solution 
{
    static class DSU 
    {
        int[] parent;

        DSU(int n) 
        {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++)
            {
                parent[i] = i;
            }
        }

        int find(int x) 
        {
            if (parent[x] != x)
            {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) 
        {
            int px = find(x);
            int py = find(y);

            if (px != py)
            {
                parent[py] = px;
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) 
    {
        DSU dsu = new DSU(c);

        for (int[] conn : connections)
        {
            dsu.union(conn[0], conn[1]);
        }

        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 1; i <= c; i++) 
        {
            int root = dsu.find(i);
            map.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        boolean[] isOffline = new boolean[c + 1];
        ArrayList<Integer> res = new ArrayList<>();

        for (int[] query : queries) 
        {
            int type = query[0];
            int node = query[1];

            if (type == 1) 
            {
                if (!isOffline[node]) 
                {
                    res.add(node);
                } 
                else 
                {
                    int root = dsu.find(node);
                    TreeSet<Integer> online = map.get(root);
                    Integer min = (online == null || online.isEmpty()) ? null : online.first();
                    res.add(min == null ? -1 : min);
                }
            } 
            else 
            {
                if (!isOffline[node]) 
                {
                    isOffline[node] = true;
                    int root = dsu.find(node);
                    TreeSet<Integer> online = map.get(root);
                    if (online != null)
                    {
                        online.remove(node);
                    }
                }
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
        {
            ans[i] = res.get(i);
        }

        return ans;
    }
}