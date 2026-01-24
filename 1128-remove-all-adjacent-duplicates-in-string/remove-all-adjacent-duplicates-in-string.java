class Solution {
    public String removeDuplicates(String s) {

        int len = s.length();
        
        boolean[] present = new boolean[len];
        Arrays.fill(present, true);

        for(int i = 0; i < len - 1; i++){

            if(i < 0) i = 0;

            char key;

            if(present[i]){

                key = s.charAt(i);
            }else{

                continue;
            }
            int j = i + 1;

            while(j < len && !present[j]){
                j++;
            }

            if(j < len){
                char next = s.charAt(j);

                if(key == next){
                    present[i] = false;
                    present[j] = false;
                    while( i > -1 && !present[i]){
                        i--;
                    }
                    i--;
                }
            }
        }

        StringBuilder res = new StringBuilder("");

        for(int i = 0; i < len; i++){

            if(present[i]){
                res.append(s.charAt(i));
            }
        }

        return res.toString();

    }
}