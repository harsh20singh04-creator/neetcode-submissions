class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int[] sequence = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            sequence[index++] = course;
            for(int next : graph.get(course)){
                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }
        }
        return numCourses == index ? sequence : new int[0];
    }
}
