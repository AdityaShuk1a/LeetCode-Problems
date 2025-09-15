class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        //HashSet to fetch the value in O(1)
        HashSet<Character> ch = new HashSet<>();
        String[] words = text.split(" ");

        int type = 0;

        for(char c: brokenLetters.toCharArray()){
            //Adding in HashSet
            ch.add(c);
        }

        for(String i: words){
            //flag variable to check whether we can type the word or not
            boolean flag = false;
            for(char c: i.toCharArray()){
                //checking for the character whether it is broken or not
                if(ch.contains(c) && !flag){
                    flag = true;
                    break;
                }
            }
            //incrementing type with the flag condition
            if(!flag){
                type++;
            }
        }

        return type;
    }
}