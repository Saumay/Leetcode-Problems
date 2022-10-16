class Solution {
    
    // 1) Recursion
//     public int cherryPickup(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
        
//         return rec(grid, 0, 0, n-1);
//     }
    
//     private int rec(int[][] grid, int i, int j1, int j2) {
//         int m = grid.length;
//         int n = grid[0].length;
        
//         if(i==m || j1<0 || j1>=n || j2<0 || j2>=n)
//             return 0;
        
//         int max = Integer.MIN_VALUE;
//         for(int dj1=-1 ; dj1<=1 ; dj1++) {
//             for(int dj2=-1 ; dj2<=1 ; dj2++) {
//                 int newJ1 = j1 + dj1;
//                 int newJ2 = j2 + dj2;
                
//                 int cherries = grid[i][j1] + rec(grid, i+1, newJ1, newJ2);
//                 if(j1 != j2)
//                     cherries += grid[i][j2];
                
//                 max = Math.max(max, cherries);
//             }
//         }
//         return max;
//     }
    
    
    // 2) Recursion + Memoization
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        return rec(grid, 0, 0, n-1, new Integer[m][n][n]);
    }
    
    private int rec(int[][] grid, int i, int j1, int j2, Integer[][][] dp) {
        int m = grid.length;
        int n = grid[0].length;
        
        if(i==m || j1<0 || j1>=n || j2<0 || j2>=n)
            return 0;
        if(dp[i][j1][j2] != null)
            return dp[i][j1][j2];
        
        int max = Integer.MIN_VALUE;
        for(int dj1=-1 ; dj1<=1 ; dj1++) {
            for(int dj2=-1 ; dj2<=1 ; dj2++) {
                int newJ1 = j1 + dj1;
                int newJ2 = j2 + dj2;
                
                int cherries = grid[i][j1] + rec(grid, i+1, newJ1, newJ2, dp);
                if(j1 != j2)
                    cherries += grid[i][j2];
                
                max = Math.max(max, cherries);
            }
        }
        dp[i][j1][j2] = max;
        return max;
    }
}