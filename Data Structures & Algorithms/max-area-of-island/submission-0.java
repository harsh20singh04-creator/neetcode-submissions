class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxarea = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    maxarea = Math.max(maxarea , dfs(i , j , grid));
                }
            }
        }
        return maxarea;
    }
    private int dfs(int row , int col , int[][] grid){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] == 0)
        return 0;
        grid[row][col] = 0;
        int area = 1;
        int[][] dir = {{0,1} , {0,-1} , {1,0} , {-1,0}};
        for(int[] d : dir){
            int nr = row + d[0];
            int nc = col + d[1];
            area += dfs(nr , nc , grid);
        }
        return area;
    }
}
