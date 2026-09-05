class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,0}); // {cost , point}
        boolean[] visited = new boolean[points.length];
        int totalCost = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int point = curr[1];
            if(visited[point]) continue;
            visited[point] = true;
            totalCost += cost;

            for(int i=0;i<points.length;i++){
                if(!visited[i]){
                    int distance = Math.abs(points[i][0] - points[point][0]) +
                                   Math.abs(points[i][1] - points[point][1]);
                    pq.offer(new int[]{distance , i});
                }
            }
        }
        return totalCost;
    }
}
