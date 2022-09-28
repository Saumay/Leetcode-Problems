class Solution {
    
    private int[][] dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}, {-1,1}, {1,-1}, {1,1}, {-1,-1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if(grid==null || grid.length==0 || grid[0][0]==1 || grid[n-1][n-1]==1)
            return -1;
        
        Queue<int[]> q = new ArrayDeque<>();
        grid[0][0] = 1;
        q.add(new int[] {0,0});
        
        int pathLen = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            
            pathLen++;
            for(int i=0 ; i<size ; i++) {
                // R - Remove
                int[] cur = q.remove();
                
                // P - Processing
                if(cur[0]==n-1 && cur[1]==n-1)
                    return pathLen;
                
                // A - Add neighbors
                for(int[] dir : getValidNeighbors(grid, cur[0], cur[1])) {
                    grid[dir[0]][dir[1]] = 1;
                    q.add(new int[] {dir[0], dir[1]});
                }
            }
        }
        return -1;
    }
    
    private List<int[]> getValidNeighbors(int[][] grid, int row, int col) {
        int n = grid.length;
        List<int[]> neighbors = new LinkedList<>();
        
        for(int[] dir : dirs) {
            int nbrI = row + dir[0];
            int nbrJ = col + dir[1];

            if(nbrI>=0 && nbrJ>=0 && nbrI<n && nbrJ<n && grid[nbrI][nbrJ]==0) {
                neighbors.add(new int[] {nbrI, nbrJ});
            }
        }
        return neighbors;
    }
}