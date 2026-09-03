class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) q.offer(i);
        }
        int index = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            index++;
            for(int course : graph.get(curr)){
                indegree[course]--;
                if(indegree[course] == 0) q.offer(course);
            }
        }
        return numCourses == index;
    }
}
