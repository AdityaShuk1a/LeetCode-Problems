class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()){
            return ans;
        }
        ans = Combinations("", digits);
        return ans; 
    }

    public List<String> Combinations(String p, String digit){
        if(digit.isEmpty()){
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        List<String> result = new ArrayList<>();

        char ch = digit.charAt(0);

        if(ch == '2'){
            for(char c : "abc".toCharArray()){
                result.addAll(Combinations(p + c, digit.substring(1)));
            }
        }else if(ch == '3'){
            for(char c : "def".toCharArray()){
                result.addAll(Combinations(p + c, digit.substring(1)));
            }
        }else if(ch == '4'){
            for(char c : "ghi".toCharArray()){
                result.addAll(Combinations(p + c, digit.substring(1)));
            }
        }else if(ch == '5'){
            for(char c : "jkl".toCharArray()){
                result.addAll(Combinations(p + c, digit.substring(1)));
            }
        }else if(ch == '6'){
            for(char c : "mno".toCharArray()){
                result.addAll(Combinations(p + c, digit.substring(1)));
            }
        }else if(ch == '7'){
            for(char c : "pqrs".toCharArray()){
                result.addAll(Combinations(p + c, digit.substring(1)));
            }
        }else if(ch == '8'){
            for(char c : "tuv".toCharArray()){
                result.addAll(Combinations(p + c, digit.substring(1)));
            }
        }else if(ch == '9'){
            for(char c : "wxyz".toCharArray()){
                result.addAll(Combinations(p + c, digit.substring(1)));
            }
        }
        return result;
    }
}