class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        ArrayList<Integer> res = new ArrayList<>();
        for(int spell: spells){
            int left = 0;
            int right = potions.length - 1;
            int count = 0;
            while(left <= right){
                int mid = left + (right - left) / 2;
                long check = (long)spell * (long)potions[mid];
                if(check >= success){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
                
            }
            count = potions.length - left;
            System.out.println();
            res.add(count);
        }

        int[] ans = new int[res.size()];
        int k = 0;
        for(int i: res){
            ans[k++] = i;
        }

        return ans;
    }
}