class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        for(int i=right;i<prices.length;i++){
            if(prices[i] > prices[left]){
                int profit = prices[i] - prices[left];
                maxProfit = Math.max(maxProfit , profit);
            }else{
                left = i;
            }
        }
        return maxProfit;
    }
}
