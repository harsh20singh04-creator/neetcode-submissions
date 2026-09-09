class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0 , new ArrayList<>() , target , candidates);
        return result;
    }
    private void backtrack(int index , List<Integer> path , int target , int[] candidates){
        if(target==0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(index == candidates.length || candidates[index] > target) return;
        for(int i=index;i<candidates.length;i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;
            path.add(candidates[i]);
            backtrack(i+1 , path , target-candidates[i] , candidates);
            path.remove(path.size()-1);
        }
    }
}
