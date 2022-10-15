class Solution {
    
    // 1) By using Heap of size n
//     public int findKthLargest(int[] nums, int k) {
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2-i1);
        
//         for(int num : nums)
//             pq.add(num);
        
//         for(int i=0 ; i<k-1 ; i++)
//             pq.poll();
        
//         return pq.peek();
//     }
    
    
    // 2) By using Heap of size k
//     public int findKthLargest(int[] nums, int k) {
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
        
//         for(int num : nums) {
//             pq.add(num);
            
//             if(pq.size() > k)
//                 pq.poll();
//         }
//         return pq.peek();
//     }
    
    
    // 3) Using quick select
//     public int findKthLargest(int[] nums, int k) {
//         if(nums==null || k>nums.length)
//             return -1;
        
//         return quickSelect(nums, 0, nums.length-1, k);
//     }
    
//     private int quickSelect(int[] nums, int left, int right, int k) {
//         int n = nums.length;
//         int pivotIdx = partition(nums, left, right);
        
//         if((n-k) == pivotIdx)
//             return nums[pivotIdx];
//         else if((n-k) < pivotIdx)
//             return quickSelect(nums, left, pivotIdx-1, k);
//         else
//             return quickSelect(nums, pivotIdx+1, right, k);
//     }
    
//     private int partition(int[] nums, int left, int right) {
//         int pivot = nums[right];
        
//         int j=left-1;
//         for(int i=left ; i<=right ; i++) {
//             if(nums[i] <= pivot)
//                 swap(nums, i, ++j);
//         }
//         return j;
//     }
    
//     private void swap(int[] nums, int i, int j) {
//         if(nums[i] != nums[j]) {
//             nums[i] = nums[i]^nums[j];
//             nums[j] = nums[i]^nums[j];
//             nums[i] = nums[i]^nums[j];
//         }
//     }
    
//     public int findKthLargest(int[] nums, int k) {
//         if(nums==null || k>nums.length)
//             return -1;
        
//         return quickSelect(nums, 0, nums.length-1, k);
//     }
    
//     private int quickSelect(int[] nums, int left, int right, int k) {
//         int n = nums.length;
//         int pivotIdx = partition(nums, left, right);
        
//         if((n-k) == pivotIdx)
//             return nums[pivotIdx];
//         else if((n-k) < pivotIdx)
//             return quickSelect(nums, left, pivotIdx-1, k);
//         else
//             return quickSelect(nums, pivotIdx+1, right, k);
//     }
    
//     private int partition(int[] nums, int left, int right) {
//         int pivot = nums[right];
        
//         int j=left-1;
//         for(int i=left ; i<=right ; i++) {
//             if(nums[i] <= pivot)
//                 swap(nums, i, ++j);
//         }
//         return j;
//     }
    
//     private void swap(int[] nums, int i, int j) {
//         if(nums[i] != nums[j]) {
//             nums[i] = nums[i]^nums[j];
//             nums[j] = nums[i]^nums[j];
//             nums[i] = nums[i]^nums[j];
//         }
//     }
    
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || k>nums.length)
            return -1;
        
        return quickSelect(nums, 0, nums.length-1, k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        int n = nums.length;
        int pivotIdx = partition(nums, left, right, nums[right]);
        
        if(n-k == pivotIdx)
            return nums[pivotIdx];
        else if(n-k < pivotIdx)
            return quickSelect(nums, left, pivotIdx-1, k);
        else
            return quickSelect(nums, pivotIdx+1, right, k);
    }
    
    private int partition(int[] nums, int left, int right, int pivot) {
        int slow = left-1;
        for(int fast=left ; fast<=right ; fast++) {
            if(nums[fast] <= pivot)
                swap(nums, fast, ++slow);
        }
        return slow;
    }
    
    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}