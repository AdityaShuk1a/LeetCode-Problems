class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree, 0);
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        
        for(int i = 0; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] i: pre){
            adj.computeIfAbsent(i[0], k -> new ArrayList<>()).add(i[1]);
            indegree[i[1]]++;
        }
        int[] rersult = new int[numCourses];
        Arrays.fill(rersult, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int l = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            rersult[l++] = node;
            for(int i: adj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        int[] blank = {};
        for(int i: rersult){
            if(i == -1){
                return blank;
            }
        }

        for (int i = 0; i < rersult.length / 2; i++) {
            int temp = rersult[i];
            rersult[i] = rersult[rersult.length - 1 - i];
            rersult[rersult.length - 1 - i] = temp;
        }

        return rersult;
    }
}