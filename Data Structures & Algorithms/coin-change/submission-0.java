class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 0;
        int INF = amount+1;
        for(int j=1;j<amount+1;j++) dp[0][j] = INF;
        for(int i=1;i<coins.length+1;i++){
            for(int j=0;j<amount+1;j++){
                // skip
                dp[i][j] = dp[i-1][j];
                // take -> Unbounded Knapsack
                if(coins[i-1]<=j){
                    dp[i][j] = Math.min(dp[i][j] , 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        return dp[coins.length][amount] == INF ? -1 : dp[coins.length][amount];
    }
}
