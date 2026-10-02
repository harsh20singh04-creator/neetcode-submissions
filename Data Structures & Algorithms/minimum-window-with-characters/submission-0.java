class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int[] freq = new int[128];
        int count = 0;
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)]++;
            count++;
        }
        int left = 0;
        int start = 0;
        int minlen = Integer.MAX_VALUE;
        for(int right=0;right<s.length();right++){
            if(freq[s.charAt(right)] > 0) count--;
            freq[s.charAt(right)]--;
            while(count == 0){
                // Current window is VALID
                if(right - left + 1 < minlen){
                    minlen = right - left + 1;
                    start = left;
                }
                // Remove left character
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)] > 0) count++;
                left++;
            } 
        }           
        return (minlen == Integer.MAX_VALUE) ? "" : s.substring(start, start + minlen);
    }
}
