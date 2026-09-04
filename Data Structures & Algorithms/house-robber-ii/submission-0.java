class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(house_robber(0 , n-2 , nums),house_robber(1 , n-1 , nums));
    }
    private int house_robber(int start , int end , int[] nums){
        if(start==end) return nums[start];
        int[] dp = new int[end-start+1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start] , nums[start+1]);
        for(int i=2;i<dp.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[start+i] , dp[i-1]);
        }
        return dp[dp.length-1];
    }
}
