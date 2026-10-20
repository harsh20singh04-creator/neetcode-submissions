class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] flight : flights){
            graph.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        int[] cost = new int[n];
        Arrays.fill(cost , Integer.MAX_VALUE);
        cost[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src , 0}); // airport , cost
        int stops = 0;
        while(!q.isEmpty() && stops <= k){
            int size = q.size();
            int[] temp_cost = cost.clone();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int curr_airport = curr[0];
                int curr_cost = curr[1];
                for(int[] next : graph.get(curr_airport)){
                    int next_airport = next[0];
                    int next_cost = next[1];
                    if(next_cost > temp_cost[next_airport]) continue;
                    if(curr_cost + next_cost < temp_cost[next_airport]){
                        temp_cost[next_airport] = curr_cost + next_cost;
                        q.offer(new int[]{next_airport , temp_cost[next_airport]});
                    }
                }
            }
            stops++;
            cost = temp_cost;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
