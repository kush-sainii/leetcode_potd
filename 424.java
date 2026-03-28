class Solution {
    private int getMaxFrequency(int[] freq) {
        int max = 0;
        for (int count : freq) {
            max = Math.max(max, count);
        }
        return max;
    }

    public int characterReplacement(String s, int k) {
        int[] fm = new int[26];
        int start = 0, end = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int n = s.length();

        while(end<n) {
            char current = s.charAt(end);
            fm[current - 'A']++;
            maxFreq = Math.max(maxFreq, fm[current - 'A']);

            int windowLength = (end - start + 1);
            while(windowLength - maxFreq > k){
                fm[s.charAt(start) - 'A']--;
                start++;
                windowLength = end - start + 1;
                maxFreq = getMaxFrequency(fm);
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}