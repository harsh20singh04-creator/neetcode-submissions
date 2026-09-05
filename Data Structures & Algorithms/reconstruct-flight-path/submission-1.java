class Solution {
    HashMap<String,PriorityQueue<String>> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            map.putIfAbsent(ticket.get(0) , new PriorityQueue<>());
            map.get(ticket.get(0)).offer(ticket.get(1));
        }
        dfs("JFK");
        return ans;
    }
    private void dfs(String src_airport){
        PriorityQueue<String> pq = map.get(src_airport);
        while(pq!=null && !pq.isEmpty()){
            String dest_airport = pq.poll();
            dfs(dest_airport);
        }
        ans.addFirst(src_airport);
    }
}
