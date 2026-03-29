class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int start = 0, end = 0;
        int sum = 0;
        int window = n - k;
        int minSum = Integer.MAX_VALUE;
        int totSum = 0;
        for(int num : cardPoints) {
            totSum += num;
        }
        if(k==n) return totSum;
        while(end < n) {
            sum += cardPoints[end];

            if(end - start + 1 == window) {
                minSum = Math.min(sum, minSum);
                sum = sum - cardPoints[start];
                start++;               
            }
            
            end++;
        }
        return totSum - minSum;
    }
}