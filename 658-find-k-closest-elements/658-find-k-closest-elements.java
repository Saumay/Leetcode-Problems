class Solution {
    
    // 1) Approach 1: Sorting using custom comparator, and lambda
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         return IntStream.of(arr)
//             .boxed()
//             .sorted((i1,i2) -> Math.abs(i1-x) - Math.abs(i2-x))
//             .limit(k)
//             .sorted()
//             .collect(Collectors.toList());
        
//     }
    
    
    // 2) Approach 2: Using binary search + sliding window
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        int lo=0;
        int hi=n-1;
        
        while(lo+1 < hi) {
            int mid = lo + (hi-lo)/2;
            
            if(arr[mid] < x)
                lo = mid;
            else
                hi = mid;
        }
        
        List<Integer> res = new LinkedList<>();
        int count=0;
        while(count < k) {
            if(hi>=n)
                res.add(0, arr[lo--]);
            else if(lo<0)
                res.add(arr[hi++]);
            else if(Math.abs(arr[lo]-x)<=Math.abs(arr[hi]-x))
                res.add(0, arr[lo--]);
            else
                res.add(arr[hi++]);
            count++;
        }
        return res;
    }
    
    
    // Approach 3: Binary search to find the left bound
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         int lo = 0;
//         int hi = arr.length-k;
        
//         List<Integer> result = new ArrayList<>();
        
//         while(lo<hi) {
//             int mid = lo + (hi-lo)/2;
            
//             if(arr[mid] == arr[mid+k]) {
//                 if(arr[mid] < x)
//                     lo = mid+1;
//                 else
//                     hi = mid;
//             }
//             else if(Math.abs(arr[mid]-x) <= Math.abs(arr[mid+k]-x))
//                 hi = mid;
//             else
//                 lo = mid+1;
//         }
    
//         for(int i=lo ; i<(lo+k) ; i++)
//             result.add(arr[i]);
    
//         return result;
//     }
}