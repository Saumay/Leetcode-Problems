class Solution {
    
    private int[][] dirs = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
        // 1.1) DFS 1
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // DFS
        if(image[sr][sc]==color)
            return image;
        
        dfs(image, sr, sc, image[sr][sc], color);
        image[sr][sc] = color;
        return image;
    }
    
    
    private void dfs(int[][] image, int sr, int sc, int origColor, int newColor) {
        int m = image.length;
        int n = image[0].length;
        
        for(int[] dir : dirs) {
            int nbrI = sr+dir[0];
            int nbrJ = sc+dir[1];
            
            if(nbrI>=0 && nbrJ>=0 && nbrI<m && nbrJ<n && image[nbrI][nbrJ]==origColor) {
                image[nbrI][nbrJ] = newColor;
                dfs(image, nbrI, nbrJ, origColor, newColor);
            }
        }
    }
    
    
    // 1.2) DFS 2
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         // DFS
//         if(image[sr][sc]==color)
//             return image;
        
//         dfs(image, sr, sc, image[sr][sc], color);
//         return image;
//     }
    
//     private void dfs(int[][] image, int sr, int sc, int origColor, int newColor) {
//         if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=origColor)
//             return;
        
//         image[sr][sc] = newColor;
//         for(int[] dir : dirs) {
//             dfs(image, sr+dir[0], sc+dir[1], origColor, newColor);
//         }
//     }
}