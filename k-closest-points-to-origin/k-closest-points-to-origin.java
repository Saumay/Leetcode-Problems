class Solution {
    
    // 2) Using max heap
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((c1, c2) -> getEuclideanDistance(c2) - getEuclideanDistance(c1));
        
        for(int[] point : points) {
            pq.add(point);
            
            if(pq.size() > k)
                pq.poll();
        }
        
        int[][] res = new int[k][2];
        for(int i=0 ; i<k ; i++)
            res[i] = pq.poll();
        
        return res;
    }
    
    private int getEuclideanDistance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
    
    
    // 4) Using quick select
//     public int[][] kClosest(int[][] points, int k) {
        
//         int kthIdx = quickSelect(points, 0, points.length-1, k);
        
//         int[][] res = new int[k][];
//         for(int i=0 ; i<=kthIdx ; i++)
//             res[i] = points[i];
        
//         return res;
//     }
    
//     private int quickSelect(int[][] points, int lo, int hi, int k) {
//         int pivotIdx = partition(points, lo, hi);
        
//         if(k-1 == pivotIdx)
//             return pivotIdx;
//         else if(k-1 < pivotIdx)
//             return quickSelect(points, lo, pivotIdx-1, k);
//         else
//             return quickSelect(points, pivotIdx+1, hi, k);
//     }
    
//     private int partition(int[][] points, int lo, int hi) {
//         int pivot = getEuclideanDistance(points[hi]);
        
//         int j = lo;
//         for(int i=lo ; i<=hi ; i++) {
//             if(getEuclideanDistance(points[i]) <= pivot)
//                 swap(points, i, j++);
//         }
//         return j-1;
//     }
    
//     private int getEuclideanDistance(int[] point) {
//         return point[0]*point[0] + point[1]*point[1];
//     }
    
//     private void swap(int[][] points, int i, int j) {
//         int[] temp = points[i];
//         points[i] = points[j];
//         points[j] = temp;
//     }
}