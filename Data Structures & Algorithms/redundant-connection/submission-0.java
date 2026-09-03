class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        for(int i=1;i<parent.length;i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(find(u) == find(v)) return edge;
            else union(u,v);
        }
        return new int[0];
    }
    private int find(int x){
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
    private void union(int x , int y){
        int px = find(x);
        int py = find(y);
        parent[px] = py;
    }
}
