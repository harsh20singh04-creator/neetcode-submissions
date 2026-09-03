class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(heights , i , 0 , pacific);
        }
        for(int j=0;j<n;j++){
            dfs(heights , 0 , j , pacific);
        }
        for(int i=0;i<m;i++){
            dfs(heights , i , n-1 , atlantic);
        }
        for(int j=0;j<n;j++){
            dfs(heights , m-1 , j , atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]) result.add(Arrays.asList(i,j));
            }
        }
        return result;
    }
    private void dfs(int[][] heights , int row , int col , boolean[][] visited){
        visited[row][col] = true;
        int[][] dir = {{1,0} , {-1,0} , {0,1} , {0,-1}};
        for(int[] d : dir){
            int nr = row + d[0];
            int nc = col + d[1];
            if(nr<0 || nc<0 || nr>=heights.length || nc>=heights[0].length || visited[nr][nc])
            continue;
            if(heights[nr][nc] >= heights[row][col]) dfs(heights , nr , nc , visited);
        }
    }
}
