class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length,m = nums2.length ; // why not -1 : doing partitioning not indexing 
        if(n>m) return findMedianSortedArrays(nums2,nums1);//reduce search space in future
 
        int low = 0 , high = n, size = n+m;

        while(low<=high){

            int cut1 = (low+high)/2;
            int cut2 = (n+m+1)/2 - cut1; // arr1 + arr2 = (n+m+1)/2 work for both even and odd length

            int l1 = (cut1==0)? Integer.MIN_VALUE : nums1[cut1-1];
            int l2 = (cut2==0)? Integer.MIN_VALUE : nums2[cut2-1];
            int r1 = (cut1==n)? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2==m)? Integer.MAX_VALUE : nums2[cut2];

            if(l1>r2) high = cut1-1;
            else if(l2>r1) low = cut1+1;

            else{
                if (size % 2 == 0) return (double)(Math.max(l1, l2) + Math.min(r1, r2))/2; 
                else return Math.max(l1, l2);   
            }
        }
        return 0.0; //unable to reach input
    }
}