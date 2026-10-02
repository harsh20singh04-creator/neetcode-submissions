class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        for(int i=0;i<nums.length;i++){
            // remove smaller element from front
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.removeLast();
            }
            // remove the element which does not belong to the window
            while(!deque.isEmpty() && deque.peekFirst() <= i-k){
                deque.removeFirst();
            }
            deque.addLast(i);
            if(i >= k-1){
                result[index++] = nums[deque.peekFirst()];
            }
        } 
        return result;
    }
}
