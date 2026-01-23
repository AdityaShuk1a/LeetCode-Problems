class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int newLen = n + m;

        int[] arr = new int[newLen];
        int k = 0;
        int i = 0;
        int j = 0;

        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                arr[k++] = nums1[i++];
            }else{
                arr[k++] = nums2[j++];
            }
        }

        while(i < n){
            arr[k++] = nums1[i++];
        }

        while(j < m){
            arr[k++] = nums2[j++];
        }

        k = 0;

        int mid = newLen / 2;
        if(newLen % 2 == 0){
            return (arr[mid] + arr[mid - 1]) / 2.0;
        }else{
            return arr[mid];
        }


    }
}