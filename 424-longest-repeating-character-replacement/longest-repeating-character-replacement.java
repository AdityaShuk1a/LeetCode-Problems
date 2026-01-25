class Solution {
    public int characterReplacement(String s, int k) {
        int right = 0;
        int left = 0;
        int len = s.length();
        int error = 0;
        char key = s.charAt(0);
        int maxLen = Integer.MIN_VALUE;
        int[] character = new int[26];

        while (right < len) {
            character[s.charAt(right) - 'A']++;
            if (character[key - 'A'] < character[s.charAt(right) - 'A']) {
                key = s.charAt(right);
            }

            error = (right - left + 1) - character[key - 'A'];

            while (error > k) {
                character[s.charAt(left) - 'A']--;
                left++;
                for (int i = 0; i < 26; i++) {
                    if (character[i] > character[key - 'A']) {
                        key = (char) (i + 'A');
                    }
                }

                error = (right - left + 1) - character[key - 'A'];
            }

            maxLen = Math.max(right - left + 1, maxLen);
            right++;
        }

        return maxLen;
    }
}
