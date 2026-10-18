class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=edges.length;i++) graph.add(new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(graph , 0 , visited);
        for(boolean node : visited){
            if(!node) return false;
        }
        return true;
    }
    private void dfs (List<List<Integer>> graph , int node , boolean[] visited){
        visited[node] = true;
        for(int next : graph.get(node)){
            if(!visited[next]) dfs(graph , next , visited);
        }
    }
}
