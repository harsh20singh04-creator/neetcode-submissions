class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i , j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] point = q.poll();
            int[][] dir = {{1,0} , {-1,0} , {0,1} , {0,-1}};
            for(int[] d : dir){
                int nr = d[0] + point[0];
                int nc = d[1] + point[1];
                if(nr<0 || nc<0 || nr>=m || nc>=n || grid[nr][nc] != Integer.MAX_VALUE) continue;
                grid[nr][nc] = 1 + grid[point[0]][point[1]];
                q.offer(new int[]{nr , nc});
            }
        }
    }
}
