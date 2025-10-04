class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;

        while(left < right){
            int minH = Math.min(height[left], height[right]);
            int breadth = right - left;

            int area = minH * breadth;

            maxArea = Math.max(area, maxArea);
            if(height[left] == height[right]){
                left++;
            }else if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }


        }

        return maxArea;

    }
}