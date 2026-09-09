class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(0 , new ArrayList<>() , target , nums);
        return result;
    }
    private void backtrack(int index , List<Integer> path , int target , int[] nums){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || index==nums.length) return;
        path.add(nums[index]);
        backtrack(index , path , target-nums[index] , nums);
        path.remove(path.size()-1);
        backtrack(index+1 , path , target , nums);
    }
}
