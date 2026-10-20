class Solution {
    public String foreignDictionary(String[] words) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<26;i++){
            graph.add(new ArrayList<>());
        }
        boolean[] present = new boolean[26];
        for(String word : words){
            for(char ch : word.toCharArray()){
                present[ch-'a'] = true;
            }
        }
        int[] indegree = new int[26];
        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];
            if(w1.length() > w2.length() && w1.startsWith(w2)) return "";
            int len = Math.min(w1.length() , w2.length());
            for(int j=0;j<len;j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    graph.get(w1.charAt(j)-'a').add(w2.charAt(j)-'a');
                    indegree[w2.charAt(j)-'a']++;
                    break;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<26;i++){
            if(present[i] && indegree[i]==0) q.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        int processed_char = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            sb.append((char)(u + 'a'));
            processed_char++;
            for(int v : graph.get(u)){
                indegree[v]--;
                if(indegree[v] == 0) q.offer(v); 
            }
        }
        int total_char = 0;
        for(boolean exist : present){
            if(exist) total_char++;
        }
        return total_char == processed_char ? sb.toString() : "";
    }
}
