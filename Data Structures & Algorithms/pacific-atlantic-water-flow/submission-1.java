class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> list = new ArrayList<>();
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];
        for(int i=0;i<m;i++) dfs(pacific , heights , i , 0);
        for(int j=0;j<n;j++) dfs(pacific , heights , 0 , j);
        for(int i=0;i<m;i++) dfs(atlantic , heights , i , n-1);
        for(int j=0;j<n;j++) dfs(atlantic , heights , m-1 , j);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]) list.add(Arrays.asList(i,j));
            }
        }
        return list;
    }
    private void dfs(boolean[][] visited , int[][] heights , int row , int col){
        if(visited[row][col]) return;
        visited[row][col] = true;
        int[][] dir = {{1,0} , {-1,0} , {0,-1} , {0,1}};
        for(int[] d : dir){
            int nr = row + d[0];
            int nc = col + d[1];
            if(nr<0 || nc<0 || nr>=heights.length || nc>=heights[0].length || heights[nr][nc] < heights[row][col]) continue;
            dfs(visited , heights , nr , nc);
        }
    }
}
