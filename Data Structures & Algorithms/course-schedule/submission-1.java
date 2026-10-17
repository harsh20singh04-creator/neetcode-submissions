class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int index = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            index++;
            for(int next : graph.get(course)){
                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }
        }
        return (numCourses == index) ? true : false;
    }
}
