class Solution {
    HashMap<String,PriorityQueue<String>> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.putIfAbsent(from , new PriorityQueue<>());
            map.get(from).offer(to);
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
