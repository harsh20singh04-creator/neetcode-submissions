class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0 , new ArrayList<>() , nums);
        return result;
    }
    private void backtrack(int index , List<Integer>path , int[] nums){
        result.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            backtrack(i+1 , path , nums);
            path.remove(path.size()-1);
        }
    }
}
