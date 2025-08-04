class Solution {
    public int totalFruit(int[] fruits) {

        int n = fruits.length; 
        if (n <= 2) return n;

        int max_window = 0;
        int window = 0;
        int l = 0;

        int first = -1;
        int second = -1;
        for (int r=0; r<n; r++) {
            if (fruits[r] == first || fruits[r] == second) {
                window++;
            } else if (first == -1) {
                first = fruits[r];
                window++;
            } else if (second == -1) {
                second = fruits[r];
                window++;
            } else {
                
                l = r-1;
                max_window = Math.max(window, max_window);
                window = 1;
                int old = first == fruits[r-1]? first : second ;

                while (fruits[l] == old) {
                    window++;
                    l--;
                }
                first = old;
                second = fruits[r];
            }

        }
        max_window = Math.max(window, max_window);
        return max_window;

    }
}