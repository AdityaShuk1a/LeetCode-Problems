class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> index = new HashMap<>();

        for(String i: strs){
            char[] c = i.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if(index.containsKey(key)){
                index.get(key).add(i);
            }else{
                index.put(key, new ArrayList<String>());
                index.get(key).add(i);
            }
        } 

        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<String, ArrayList<String>> ent: index.entrySet()){
            ans.add(ent.getValue());
        }

        return ans;
    }
}