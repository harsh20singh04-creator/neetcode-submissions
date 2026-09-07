class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return helper(0 , 1 , prices);
    }
    private int helper(int index , int canBuy , int[] prices){
        if(index >= prices.length) return 0;
        if(dp[index][canBuy] != null) return dp[index][canBuy];
        if(canBuy == 1){
            int buy = - prices[index] + helper(index+1 , 0 , prices);
            int skip = helper(index+1 , 1 , prices);
            return dp[index][canBuy] = Math.max(buy , skip);
        }else{
            int sell = prices[index] + helper(index+2 , 1 , prices);
            int hold = helper(index+1 , 0 , prices);
            return dp[index][canBuy] = Math.max(sell , hold);
        }
    }
}
