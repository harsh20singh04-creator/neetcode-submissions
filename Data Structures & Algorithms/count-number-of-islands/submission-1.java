class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    island++;
                    dfs(i, j, grid);
                }
            }
        }
        return island;
    }
    private void dfs (int row , int col , char[][] grid){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] != '1') return;
        grid[row][col] = '0';
        int[][] dir = {{1,0} , {-1,0} , {0,1} , {0,-1}};
        for(int[] d : dir){
            int nr = d[0] + row;
            int nc = d[1] + col;
            dfs(nr , nc , grid);
        }
    }
}
