class Solution {
    public String removeStars(String s) {
        Stack<Character> c = new Stack<>();

        for(char cc: s.toCharArray()){
            if(cc == '*'){
                if(!c.isEmpty()){
                    c.pop();
                }
            }else{
                c.add(cc);
            }
        }

        StringBuilder result = new StringBuilder("");

        while(!c.isEmpty()){
            result.append(c.pop());
        }
        result.reverse();

        return result.toString();
    }
}