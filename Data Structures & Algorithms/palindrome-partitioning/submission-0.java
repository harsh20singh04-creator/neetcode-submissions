class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(new ArrayList<>() , 0 , s);
        return result;
    }
    private void backtrack(List<String> level , int start , String s){
        if(start == s.length()){
            result.add(new ArrayList<>(level));
            return;
        }
        for(int end=start;end<s.length();end++){
            if(isPalindrome(s , start , end)){
                level.add(s.substring(start , end+1));
                backtrack(level , end+1 , s);
                level.remove(level.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s , int start , int end){
        while(start<=end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
