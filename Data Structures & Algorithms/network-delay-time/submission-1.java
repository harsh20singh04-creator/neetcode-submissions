class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] time : times){
            graph.get(time[0]).add(new int[]{time[1] , time[2]});
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance , Integer.MAX_VALUE);
        distance[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1] , b[1]));
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int dist = curr[1];

            if(dist > distance[node]) continue;
            for(int[] edge : graph.get(node)){
                int nei = edge[0];
                int weight = edge[1];

                if(dist + weight < distance[nei]){
                    distance[nei] = dist + weight;
                    pq.offer(new int[]{nei , distance[nei]});
                } 
            }
        }
        int ans = 0;
        for(int i=1;i<distance.length;i++){
            if(distance[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans , distance[i]);
        }
        return ans;
    }
}
