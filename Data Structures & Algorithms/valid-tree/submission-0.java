class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        if(!dfs(0 , -1 , visited , graph)) return false;
        for(int i=0;i<n;i++){
            if(!visited[i]) return false;
        }
        return true;
    }
    private boolean dfs(int node , int parent , boolean[] visited , List<List<Integer>> graph){
        visited[node] = true;
        for(int nei : graph.get(node)){
            if(nei == parent) continue;
            if(visited[nei]) return false;
            if(!dfs(nei , node , visited , graph)) return false;
        }
        return true;
    }
}
