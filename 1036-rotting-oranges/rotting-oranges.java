class Solution {
    class Pair {
        int i, j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        // Step 1: Count fresh oranges and enqueue rotten ones
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        // Step 2: BFS traversal
        int[] r = {0, -1, 0, 1};
        int[] c = {-1, 0, 1, 0};

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Pair rotten = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newRow = rotten.i + r[k];
                    int newCol = rotten.j + c[k];

                    if (newRow >= 0 && newRow < grid.length &&
                        newCol >= 0 && newCol < grid[0].length &&
                        grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        fresh--;
                        queue.add(new Pair(newRow, newCol));
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
