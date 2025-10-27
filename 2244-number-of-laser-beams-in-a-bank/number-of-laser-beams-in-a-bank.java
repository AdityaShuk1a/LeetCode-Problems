class Solution {
    public int numberOfBeams(String[] bank) {
        int laser = 0;
        int total = 0;
        for(char i: bank[0].toCharArray()){
            if(i == '1'){
                laser++;
            }
        }

        for(int i = 1; i < bank.length; i++){
            int count = 0;
            int temp = 0;
            for(char j: bank[i].toCharArray()){
                if(j == '1'){
                    temp++;
                }else{
                    count++;
                }
            }

            if(count == bank[i].length()){
                continue;
            }else{
                total+=laser * temp;
                laser = temp;
            }
        }

        return total;
    }
}