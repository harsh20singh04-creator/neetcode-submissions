class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{grid[0][0] , 0 ,0});
        boolean[][] visited = new boolean[m][n];
        int maxCost = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int r = curr[1];
            int c = curr[2];
            if(visited[r][c]) continue;
            visited[r][c] = true;
            maxCost = Math.max(maxCost , cost);
            if(r==m-1 && c==n-1) return maxCost;
            int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr<0 || nc<0 || nr>=m || nc>=n) continue;
                pq.offer(new int[]{grid[nr][nc] , nr , nc});
            }
        }
        return maxCost;
    }
}
