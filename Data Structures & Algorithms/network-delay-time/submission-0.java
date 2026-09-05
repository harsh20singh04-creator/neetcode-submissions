class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] time : times){
            graph.get(time[0]).add(new int[]{time[1] , time[2]});
        }
        int dist[] = new int[n+1];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int src_node = curr[0];
            int d = curr[1];
            if(d > dist[src_node]) continue;
            for(int[] nei : graph.get(src_node)){
                int dest_node = nei[0];
                if(dist[src_node] + nei[1] < dist[dest_node]){
                    dist[dest_node] = dist[src_node] + nei[1];
                    pq.offer(new int[]{dest_node , dist[dest_node]});
                }
            }
        }
        int ans = 0;
        for(int i=1;i<n+1;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans , dist[i]);
        }
        return ans;
    }
}
