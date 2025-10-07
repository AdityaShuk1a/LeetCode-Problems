import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int[] result = new int[n];

        Map<Integer, Integer> lastRainDay = new HashMap<>();

        for (int day = 0; day < n; day++) {
            int lake = rains[day];

            if (lake == 0) {
                result[day] = 1;
                continue;
            }

            Integer lastDay = lastRainDay.get(lake);
            if (lastDay != null) {
                int dryDay = findNextAvailableDay(lastDay + 1, parent);

                if (dryDay >= day) {
                    return new int[]{};
                }

                result[dryDay] = lake;

                parent[dryDay] = findNextAvailableDay(dryDay + 1, parent);
            }

            result[day] = -1;

            parent[day] = day + 1;

            lastRainDay.put(lake, day);
        }

        return result;
    }

    private int findNextAvailableDay(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = findNextAvailableDay(parent[x], parent);
        }
        return parent[x];
    }
}