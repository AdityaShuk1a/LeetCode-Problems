class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length;
        int i = 0;
        int j = len - 1;
        int count = 0;
        while(i <= j){
            if(people[i] + people[j] <= limit){
                i++;
            }
            j--;
            count++;
        }

        return count;
    }
}
