class Solution {
    
    // Similar to Surrounded Regions -> https://leetcode.com/problems/surrounded-regions
    // Check that
    
    private int[][] dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int enclaves = 0;
        
        for(int i=0 ; i<m ; i++) {
            if(grid[i][0] == 1)
                dfs(grid, i, 0);
            if(grid[i][n-1] == 1)
                dfs(grid, i, n-1);
        }
        
        for(int j=0 ; j<n ; j++) {
            if(grid[0][j] == 1)
                dfs(grid, 0, j);
            if(grid[m-1][j] == 1)
                dfs(grid, m-1, j);
        }
        
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(grid[i][j] == 1)
                    enclaves++;
            }
        }
        return enclaves;
    }
    
    private void dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        
        for(int[] dir : dirs) {
            int nbrI = dir[0] + i;
            int nbrJ = dir[1] + j;
            
            if(nbrI>=0 && nbrJ>=0 && nbrI<grid.length && nbrJ<grid[0].length && grid[nbrI][nbrJ]==1)
                dfs(grid, nbrI, nbrJ);
        }
    }
}