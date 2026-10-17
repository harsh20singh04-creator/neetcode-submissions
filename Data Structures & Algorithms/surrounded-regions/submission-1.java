class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            dfs(board , i , 0);
            dfs(board , i , n-1);
        }
        for(int j=0;j<n;j++){
            dfs(board , 0 , j);
            dfs(board , m-1 , j);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'T') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
    private void dfs(char[][] board , int row , int col){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col] != 'O') return;
        board[row][col] = 'T';
        int[][] dir = {{1,0} , {-1,0} , {0,1} , {0,-1}};
        for(int[] d : dir){
            int nr = row + d[0];
            int nc = col + d[1];
            dfs(board , nr , nc);
        }
    }
}
