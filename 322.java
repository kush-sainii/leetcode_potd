class Solution {    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int t = 0; t<=amount; t++) {
            if(t % coins[0] == 0) dp[0][t] = t/coins[0];
            else dp[0][t] = Integer.MAX_VALUE;
        }

        for(int ind = 1; ind<n; ind++) {
            for(int t = 0; t<=amount; t++) {
                int notTake = 0 + dp[ind-1][t];
                int take = Integer.MAX_VALUE;
                if(coins[ind] <= t  && dp[ind][t-coins[ind]] != Integer.MAX_VALUE) {
                    take = 1 + dp[ind][t-coins[ind]];
                }
                dp[ind][t] = Math.min(take, notTake);
            }
        }
        int ans = dp[n-1][amount];
        if(ans >= Integer.MAX_VALUE) return -1;
        return ans;
    }
}