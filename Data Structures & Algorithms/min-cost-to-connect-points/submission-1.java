class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0] , b[0]));
        int n = points.length;
        boolean[] visited = new boolean[n];
        pq.offer(new int[]{0 , 0}); // cost , points_index
        int total_cost = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int point = curr[1];
            if(visited[point]) continue;
            visited[point] = true;
            total_cost += cost;
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    int distance_cost = Math.abs(points[point][0] - points[i][0]) + 
                        Math.abs(points[point][1] - points[i][1]);
                    pq.offer(new int[]{distance_cost , i});
                }
            }
        }
        return total_cost;
    }
}
