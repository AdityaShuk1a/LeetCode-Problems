class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree, 0);
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] i: prerequisites){
            map.computeIfAbsent(i[0], k -> new ArrayList<>()).add(i[1]);
            indegree[i[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);
            for(int i: map.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }

        if(result.size() != numCourses){
            return false;
        }else{
            return true;
        }
    }
}