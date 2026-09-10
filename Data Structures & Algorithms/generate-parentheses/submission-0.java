class Solution {
    List<String> path = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        helper(n , 0 , 0 , sb);
        return path;
    }
    private void helper(int n , int open , int close , StringBuilder sb){
        if(sb.length() == 2*n){
            path.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append("(");
            helper(n , open+1 , close , sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append(")");
            helper(n , open , close+1 , sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
