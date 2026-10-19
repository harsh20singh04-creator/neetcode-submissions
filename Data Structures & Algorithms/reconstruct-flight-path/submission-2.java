class Solution {
    HashMap<String , PriorityQueue<String>> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            map.computeIfAbsent(ticket.get(0) , x -> new PriorityQueue<>()).offer(ticket.get(1));
        }
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }
    private void dfs(String airport){
        PriorityQueue<String> pq = map.get(airport);
        while(pq!=null && !pq.isEmpty()){
            String next_airport = pq.poll();
            dfs(next_airport);
        }
        ans.add(airport);
    }
}
