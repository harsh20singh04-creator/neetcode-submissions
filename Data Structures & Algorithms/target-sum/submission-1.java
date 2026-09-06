class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int x : nums) sum += x;
        if((sum+target)%2!=0 || Math.abs(target) > sum) return 0;
        int required = (sum + target)/2;
        int[][] dp = new int[nums.length+1][required+1];
        dp[0][0] = 1;
        for(int i=1;i<nums.length+1;i++){
            for(int j=0;j<required+1;j++){
                // Skip
                dp[i][j] = dp[i-1][j];
                // Take
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i][j] + dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][required];
    }
}
