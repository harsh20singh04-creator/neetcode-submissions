class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max_island = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    max_island = Math.max(max_island , dfs(i, j, grid));
                }
            }
        }
        return max_island;
    }
    private int dfs (int row , int col , int[][] grid){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] != 1) return 0;
        int island = 1;
        grid[row][col] = 0;
        int[][] dir = {{1,0} , {-1,0} , {0,1} , {0,-1}};
        for(int[] d : dir){
            int nr = d[0] + row;
            int nc = d[1] + col;
            island += dfs(nr , nc , grid);
        }
        return island;
    }
}
