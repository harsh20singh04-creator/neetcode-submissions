class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0 , new ArrayList<>() , nums);
        return result;
    }
    private void backtrack(int index , List<Integer> path , int[] nums){
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        backtrack(index+1 , path , nums);
        path.remove(path.size()-1);
        backtrack(index+1, path , nums);
    }
}
