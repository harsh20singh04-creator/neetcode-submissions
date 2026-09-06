class Solution {
    public String foreignDictionary(String[] words) {
        boolean[] present = new boolean[26];
        int[] indegree = new int[26];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<26;i++) graph.add(new ArrayList<>());
        for(String word : words){
            for(int i=0;i<word.length();i++) present[word.charAt(i)-'a'] = true;
        }
        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];
            if(w1.length()>w2.length() && w1.startsWith(w2)) return "";
            int len = Math.min(w1.length() , w2.length());
            for(int j=0;j<len;j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    if(!graph.get(w1.charAt(j)-'a').contains(w2.charAt(j)-'a')){
                        graph.get(w1.charAt(j)-'a').add(w2.charAt(j)-'a');
                        indegree[w2.charAt(j)-'a']++;
                    }
                    break;
                }
            }
        }
        int total = 0;
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<26;i++){
            if(present[i]){
                total++;
                if(indegree[i]==0) q.offer((char)('a' + i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char curr = q.poll();
            sb.append(curr);
            for(int nei : graph.get(curr - 'a')){
                indegree[nei]--;
                if(indegree[nei] == 0) q.offer((char)(nei + 'a'));
            }
        }
        return sb.length()==total ? sb.toString() : "";
    }
}
