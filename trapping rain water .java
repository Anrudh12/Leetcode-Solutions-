class Solution {
    public int trap(int[] height) {
        int water=0;
        int left=0;
        int right=height.length-1;
        int leftbar=height[0];
        int rightbar=height[height.length-1];
        while(left<=right){
            if(leftbar<rightbar)  //leftbar is limiting bar 
            {
              if(height[left]>leftbar)
              {
                leftbar=height[left];

              }
              else{
                 water+=leftbar-height[left];
                 left++;
              }

            }
            else{
                if(height[right]>rightbar)
              {
                rightbar=height[right];

              }
              else{
                 water+=rightbar-height[right];
                 right--;
              }

            }
        }
        return water;
    }
}
