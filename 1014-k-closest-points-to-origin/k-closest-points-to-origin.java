class Solution {
    class Points{
        int x;
        int y;
        Points(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Points> closest = new PriorityQueue<>((a, b) -> ((b.x * b.x) + (b.y * b.y)) - ((a.x * a.x) + (a.y * a.y)));
        for(int[] i: points){
            
            closest.add(new Points(i[0], i[1]));
            if(closest.size() > k){
                closest.poll();
            }
        }

        int[][] ans = new int[k][2];
        int i = 0;
        while(!closest.isEmpty()){
            Points v = closest.poll();
            ans[i][0] = v.x;
            ans[i][1] = v.y;
            i++;
        }

        return ans;
    }
}