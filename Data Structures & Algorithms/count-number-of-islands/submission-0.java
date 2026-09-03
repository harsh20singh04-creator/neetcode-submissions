class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i , j , grid);
                }
            }
        }
        return count;
    }
    private void dfs(int row , int col , char[][] grid){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]=='0')
        return;
        grid[row][col] = '0';
        int[][] dir = {{0,1} , {0,-1}, {1,0} , {-1,0}};
        for(int[] d : dir){
            int nr = row + d[0];
            int nc = col + d[1];
            dfs(nr , nc , grid);
        }
    }
}
