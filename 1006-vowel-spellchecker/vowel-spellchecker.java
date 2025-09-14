class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = queries.length;
        String[] res = new String[n];
        int j = 0;
        Set<String> set = new HashSet<>();
        Map<String, String> lowerCase = new HashMap<>();
        Map<String, String> vowels = new HashMap<>();
        for (String s : wordlist){
            set.add(s);
            String lower = s.toLowerCase();
            lowerCase.putIfAbsent(lower, s);
            vowels.putIfAbsent(toWildCard(lower), s);
        }
        for (String query : queries){
            if (set.contains(query)){
                res[j++] = query;
                continue;
            }
            String lower = query.toLowerCase();
            if (lowerCase.containsKey(lower)){
                res[j++] = lowerCase.get(lower);
            }
            else{
                res[j++] = vowels.getOrDefault(toWildCard(lower), "");
            }
        }
        return res;
    }
    private String toWildCard(String s){
        char[] arr = s.toCharArray();
        for (int i=0; i<arr.length; i++){
            char ch = arr[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                arr[i] = '*';
            }
        }
        return new String(arr);
    }
}