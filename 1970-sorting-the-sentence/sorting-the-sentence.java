class Solution {
    public String sortSentence(String s) {
        ArrayList<String> ans = new ArrayList<>();

        String[] arr = s.split(" ");
        for(int i = 0; i < arr.length; i++){
            ans.add("");
        }
        for(int i = 0; i < arr.length; i++){
            int num = arr[i].charAt(arr[i].length() - 1) - '0';
            // System.out.println(num);
            ans.set(num - 1, arr[i].substring(0, arr[i].length() - 1));
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < ans.size(); i++){
            if(i < ans.size() - 1){

                sb.append(ans.get(i));
                sb.append(" ");
            }else{
                sb.append(ans.get(i));

            }
        }


        return sb.toString();


    }
}