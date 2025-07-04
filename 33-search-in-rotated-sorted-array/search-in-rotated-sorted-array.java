class Solution {
    // public int findPeak(int[] nums){
    //     int start = 0;
    //     int end = nums.length - 1;
    //     while(start != end){
    //         int mid = start + (end - start) / 2;

            
    //         if(nums[mid] > nums[mid + 1]){
    //             end = mid;
    //         }else{
    //             start = mid + 1;
    //         }
    //     }
    //     System.out.println(nums[start]);
    //     return start;
    // }
    public int binarySearch(int[] nums, int target, int start, int end){
        // int start = 0;
        // int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    public int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if(mid > start && nums[mid] < nums[mid - 1]){
                return mid - 1;
            }
            if (nums[mid] <= nums[start]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int ans = -1;
        int pivot = findPivot(nums);
        System.out.println(pivot);
        if(pivot == -1){
            return binarySearch(nums, target, 0, nums.length - 1);
        }else if(nums[pivot] == target){
            return pivot;
        }else if(target >= nums[0]){
            return binarySearch(nums, target, 0, pivot - 1);
        }else{
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        }
        // int peak = findPeak(nums);
        // if(target == nums[peak]){
        //     return peak;
        // }else if(binarySearch(nums, target, 0, peak) != -1){
        //     System.out.println("hi");
        //     return binarySearch(nums, target, 0, peak);
        // }else{
        //     return binarySearch(nums, target, peak + 1, nums.length - 1);
        // }
        
    }
}