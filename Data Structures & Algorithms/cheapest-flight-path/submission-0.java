class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            graph.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        int[] cost = new int[n];
        Arrays.fill(cost , Integer.MAX_VALUE);
        cost[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src,cost[src]});
        int stops = 0;
        while(!q.isEmpty() && stops<=k){
            int size = q.size();
            int[] clonecost = cost.clone();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int city = curr[0];
                int city_cost = curr[1];
                for(int[] nei : graph.get(city)){
                    int next_city = nei[0];
                    int next_city_cost = nei[1];
                    if(city_cost + next_city_cost < clonecost[next_city]){
                        clonecost[next_city] = city_cost + next_city_cost;
                        q.offer(new int[]{next_city , clonecost[next_city]});
                    }
                }
            }
            stops++;
            cost = clonecost;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
