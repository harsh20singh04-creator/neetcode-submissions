class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = m;
        while(low <= high){
            int partitionA = low + (high - low) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;
            int leftA = partitionA == 0 ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int rightA = partitionA == m ? Integer.MAX_VALUE : nums1[partitionA];
            int leftB = partitionB == 0 ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int rightB = partitionB == n ? Integer.MAX_VALUE : nums2[partitionB];
            if(leftA <= rightB && leftB <= rightA){
                if((m+n)%2 == 0) return (Math.max(leftA , leftB) + Math.min(rightA , rightB)) / 2.0;
                else return Math.max(leftA , leftB);
            }else if(leftA > rightB){
                high = partitionA - 1;
            }else{
                low = partitionA + 1;
            }
        }
        return 0.0;
    }
}
