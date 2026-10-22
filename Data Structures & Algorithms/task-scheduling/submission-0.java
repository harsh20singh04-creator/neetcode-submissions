class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks) freq[ch-'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int i=0;i<freq.length;i++){
            if(freq[i] > 0) pq.offer(freq[i]);
        }
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int remain = pq.poll()-1;
                if(remain > 0) q.offer(new int[]{remain,time+n});
            }
            if(!q.isEmpty() && q.peek()[1] == time) pq.offer(q.poll()[0]);
        }
        return time;
    }
}
