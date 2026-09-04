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
            for(int i=0;i<size;i++){
                String currword = q.poll();
                if(currword.equals(endWord)) return count;
                char[] array = currword.toCharArray();
                for(int j=0;j<array.length;j++){
                    char original = array[j];
                    for(int letter=0;letter<26;letter++){
                        array[j] = (char)('a'+ letter);
                        String newword = new String(array);

                        if(set.contains(newword)){
                            q.offer(newword);
                            set.remove(newword);
                        }
                    }
                    array[j] = original;
                }
            }
            count++;
        }
        return 0;
    }
}
