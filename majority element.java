class Solution {
    public int majorityElement(int[] nums) //reutrning the midddle element
    {   //majority element will be present @ [n/2](mid index) index but after sorting.
        Arrays.sort(nums);
        int n=nums.length;
        return (nums[n/2]);
    }
}
