class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums) sum += x;
        if(sum % 2 != 0) return false;
        int target = sum/2;
        boolean[][] dp = new boolean[nums.length+1][target+1];
        dp[0][0] = true;
        for(int i=1;i<nums.length+1;i++){
            for(int j=0;j<target+1;j++){
                //skip
                dp[i][j] = dp[i-1][j];
                //take
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}
