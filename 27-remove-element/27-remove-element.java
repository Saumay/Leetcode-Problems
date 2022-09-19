class Solution {
    
/*
    Solution 1:

    a) if order of elements doesn't matter
    b) if elements to remove are rare or are towards the end
    c) if it matters what we store after the boundary index
    */
    //     public int removeElement(int[] nums, int val) {
    //         if(nums==null || nums.length==0)
    //             return 0;

    //         int front=0;
    //         int rear=nums.length-1;

    //         while(front<rear) {
    //             if(nums[front]==val && nums[rear]!=val)
    //                 swap(nums, front, rear);

    //             if(nums[front]!=val)
    //                 front++;
    //             if(nums[rear]==val)
    //                 rear--;
    //         }
    //         return nums[front]==val ? front : front+1;
    //     }

    //     private void swap(int[] nums, int i, int j) {
    //         nums[i] = nums[i] + nums[j];
    //         nums[j] = nums[i] - nums[j];
    //         nums[i] = nums[i] - nums[j];
    //     }


    /*
    Solution 2:

    a) if order of elements doesn't matter
    b) if elements to remove are rare or are towards the end
    c) if it doesn't matter what we store after the boundary index
    */
    public int removeElement(int[] nums, int val) {
        int boundary=nums.length-1;
        int i=0;

        while(i <= boundary) {
            if(nums[i] == val) {
                nums[i] = nums[boundary--];
            } else {
                i++;
            }
        }
        return i;
    }

    /*
    Solution 3:

    a) if order matters
    b) if elements to remove are abundant
    c) if it doesn't matter what we store after the boundary index
    */
    //     public int removeElement(int[] nums, int val) {
    //         int slow=0;
    //         for(int fast=0 ; fast<nums.length ; fast++) {
    //             if(nums[fast] != val)
    //                 nums[slow++] = nums[fast];
    //         }
    //         return slow;
    //     }
}