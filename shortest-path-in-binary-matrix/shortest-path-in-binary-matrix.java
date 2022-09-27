class Solution {
    
    private int[][] dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}, {-1,1}, {1,-1}, {1,1}, {-1,-1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if(grid==null || grid.length==0 || grid[0][0]==1 || grid[n-1][n-1]==1)
            return -1;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0});
        
        int pathLen = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            
            System.out.println(size + " " + pathLen);
            pathLen++;
            for(int i=0 ; i<size ; i++) {
                int[] cur = q.remove();
                
                if(cur[0]==n-1 && cur[1]==n-1)
                    return pathLen;
                
                for(int[] dir : dirs) {
                    int nbrI = cur[0] + dir[0];
                    int nbrJ = cur[1] + dir[1];
                    
                    if(nbrI>=0 && nbrJ>=0 && nbrI<n && nbrJ<n && grid[nbrI][nbrJ]==0) {
                        grid[nbrI][nbrJ] = 1;
                        q.add(new int[] {nbrI, nbrJ});
                    }
                }
            }
            // pathLen++;
        }
        return -1;
    }
}