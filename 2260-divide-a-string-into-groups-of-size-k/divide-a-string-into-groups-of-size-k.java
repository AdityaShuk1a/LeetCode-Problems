class Solution {
    public String[] divideString(String s, int k, char fill) {
        ArrayList<String> ans = new ArrayList<>();
        int len = s.length();
        for(int i = 0; i < len; i = i + k){
            if(i + k >= len){
                StringBuilder sb = new StringBuilder("");
                for(int j = i; j < len; j++){
                    sb.append(s.charAt(j));
                }

                if(sb.length() < k){
                    for(int j = sb.length(); j < k; j++){
                        sb.append(fill);
                    }
                }
                ans.add(sb.toString());
            }else{
                String x = s.substring(i, i + k);
                ans.add(x);
            }

        }

        String[] result = new String[ans.size()];
        int l = 0;
        for(String i: ans){
            result[l++] = i;
        }

        return result;
    }
}