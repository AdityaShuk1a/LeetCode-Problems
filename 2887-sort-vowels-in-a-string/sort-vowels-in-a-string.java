class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> arr = new ArrayList<>();

        for(char c: s.toCharArray()){
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
    c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            arr.add(c);
            }
        }

        Collections.sort(arr);
        int j = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
    c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                sb.setCharAt(i, arr.get(j++));
            }
        }


        return sb.toString();
    }
}