class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        StringBuilder result = new StringBuilder();
        int i = 0;

        for (int j = 0; j < haystack.length(); j++) {
            if (haystack.charAt(j) == needle.charAt(i)) {
                result.append(haystack.charAt(j));
                i++;

                if (result.toString().equals(needle)) {
                    return j - needle.length() + 1;
                }
            } else {
               
                j = j - i;
                result.setLength(0);
                i = 0;
            }
        }
        return -1;
    }
}
