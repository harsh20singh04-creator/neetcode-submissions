class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length]; 
        backtrack(new ArrayList<>() , nums , visited);
        return result;
    }
    private void backtrack(List<Integer> path , int[] nums , boolean[] visited){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            path.add(nums[i]);
            backtrack(path , nums , visited);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }
}
