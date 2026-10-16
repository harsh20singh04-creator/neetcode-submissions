class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
                else if (grid[i][j] == 1) fresh++; 
            }
        }
        if(fresh == 0) return 0;
        int minutes = 0;
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] point = q.poll();
                int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
                for(int[] d : dir){
                    int nr = point[0] + d[0];
                    int nc = point[1] + d[1];
                    if(nr<0 || nc<0 || nr>=m || nc>=n || grid[nr][nc] != 1) continue;
                    grid[nr][nc] = 2;
                    fresh--;
                    q.offer(new int[]{nr , nc});
                }
            }
            minutes++;
        }
        return fresh==0 ? minutes : -1;
    }
}
