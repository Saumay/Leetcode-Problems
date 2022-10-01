class Solution {
    
    // 1) HashSet storing coordinates as string. Coordindates are shifted wrt their source cell.
//     private int[][] dirs = new int[][] {{1,0},{0,1},{0,-1},{-1,0}};
    
//     public int numDistinctIslands(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
        
//         Set<String> islands = new HashSet<>();
//         boolean[][] visited = new boolean[m][n];
        
//         for(int i=0 ; i<m ; i++) {
//             for(int j=0 ; j<n ; j++) {
//                 if(grid[i][j] == 1 && !visited[i][j]) {
//                     StringBuilder cells = new StringBuilder();
                    
//                     visited[i][j] = true;
//                     cells.append(0).append("-").append(0).append(",");
//                     dfs(grid, i, j, i, j, cells, visited);
//                     islands.add(cells.toString());
//                 }
//             }
//         }
//         return islands.size();
//     }
    
//     private void dfs(int[][] grid, int srcI, int srcJ, int i, int j, StringBuilder cells, boolean[][] visited) {
        
//         for(int[] dir : dirs) {
//             int nbrI = i+dir[0];
//             int nbrJ = j+dir[1];
            
//             if(nbrI>=0 && nbrJ>=0 && nbrI<grid.length && nbrJ<grid[0].length && grid[nbrI][nbrJ]==1 && !visited[nbrI][nbrJ]) {
//                 visited[nbrI][nbrJ] = true;
//                 cells.append(nbrI-srcI).append("-").append(nbrJ-srcJ).append(",");
                
//                 dfs(grid, srcI, srcJ, nbrI, nbrJ, cells, visited);
//             }
//         }
//     }
    
    
    // 2) HashSet storing directions as string alongwith delimiter for backtracking.
    private int[][] dirs = new int[][] {{1,0,1}, {0,1,2}, {-1,0,3}, {0,-1,4}};
    
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Set<String> islandsDirs = new HashSet<>();
        boolean[][] vis = new boolean[m][n];
        
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(grid[i][j]==1 && !vis[i][j]) {
                    vis[i][j] = true;
                    StringBuilder islandDirs = new StringBuilder();
                    
                    dfs(grid, i, j, islandDirs, vis);
                    islandsDirs.add(islandDirs.toString());
                }
            }
        }
        return islandsDirs.size();
    }
    
    private void dfs(int[][] grid, int i, int j, StringBuilder islandDirs, boolean[][] vis) {
        for(int[] dir : dirs) {
            int nbrI = i+dir[0];
            int nbrJ = j+dir[1];
            
            if(nbrI>=0 && nbrJ>=0 && nbrI<grid.length && nbrJ<grid[0].length && grid[nbrI][nbrJ]==1 && !vis[nbrI][nbrJ]) {
                vis[nbrI][nbrJ] = true;
                islandDirs.append(dir[2]);
                
                dfs(grid, nbrI, nbrJ, islandDirs, vis);
                islandDirs.append(0);
            }
        }
    }
}