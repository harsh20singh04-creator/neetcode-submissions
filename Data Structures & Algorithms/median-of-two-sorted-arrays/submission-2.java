class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2 , nums1);
        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        while(low <= high){
            int mid1 = low + (high-low)/2;
            int mid2 = (m+n+1)/2 - mid1;
            int leftA = mid1==0 ? Integer.MIN_VALUE : nums1[mid1-1];
            int rightA = mid1==m ? Integer.MAX_VALUE : nums1[mid1];
            int leftB = mid2==0 ? Integer.MIN_VALUE : nums2[mid2-1];
            int rightB = mid2==n ? Integer.MAX_VALUE : nums2[mid2];
            if(leftA <= rightB && leftB <= rightA){
                if((m+n)%2!=0){
                    return Math.max(leftA , leftB);
                }else{
                    return (Math.max(leftA , leftB) + Math.min(rightA , rightB)) / 2.0;
                }
            }else if(leftA > rightB) high = mid1-1;
            else low = mid1+1;
        }
        return 0;
    }
}
