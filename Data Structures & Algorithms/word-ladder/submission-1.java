class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordList) set.add(word);
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int count = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0;j<size;j++){
                String word = q.poll();
                if(word.equals(endWord)) return count;
                for (int i = 0; i < word.length(); i++) {
                    char[] arr = word.toCharArray();
                    char original = arr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;
                        String newWord = new String(arr);
                        if (set.contains(newWord)){
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    arr[i] = original;
                }
            }
            count++;
        }
        return 0;
    }
}
