class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0] , b[0]));
        pq.offer(new int[]{grid[0][0] , 0, 0});
        int[][] dir = {{1,0} , {-1,0} , {0,1} , {0,-1}};
        int time = grid[0][0];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int i = curr[1];
            int j = curr[2];
            if(visited[i][j]) continue;
            visited[i][j] = true;
            time = Math.max(time , cost);
            if(i==n-1 && j==n-1) return time;
            for(int[] d : dir){
                int nr = i + d[0];
                int nc = j + d[1];
                if(nr<0 || nc<0 || nr>=grid.length || nc>=grid.length || visited[nr][nc]) continue;
                pq.offer(new int[]{grid[nr][nc] , nr , nc});
            }
        }
        return -1;
    }
}
