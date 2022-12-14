class Solution {
    
    private int[][] dirs = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    // 1.1) DFS 1
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         if(image[sr][sc]==color)
//             return image;
        
//         int origColor = image[sr][sc];
//         image[sr][sc] = color;
//         dfs(image, sr, sc, origColor, color);
//         return image;
//     }
    
//     private void dfs(int[][] image, int sr, int sc, int origColor, int newColor) {
//         int m = image.length;
//         int n = image[0].length;
        
//         for(int[] dir : dirs) {
//             int nbrI = sr+dir[0];
//             int nbrJ = sc+dir[1];
            
//             if(nbrI>=0 && nbrJ>=0 && nbrI<m && nbrJ<n && image[nbrI][nbrJ]==origColor) {
//                 image[nbrI][nbrJ] = newColor;
//                 dfs(image, nbrI, nbrJ, origColor, newColor);
//             }
//         }
//     }
    
    
    // 1.2) DFS 2
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
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
    
    
    // 2.1) BFS 1
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int origColor = image[sr][sc];
//         if(origColor==color)
//             return image;
        
//         int m = image.length;
//         int n = image[0].length;
//         Queue<int[]> q = new ArrayDeque<>();
//         image[sr][sc] = color;
//         q.add(new int[] {sr,sc});
        
//         while(!q.isEmpty()) {
//             int[] cur = q.remove();
            
//             for(int[] dir : dirs) {
//                 int nbrI = cur[0] + dir[0];
//                 int nbrJ = cur[1] + dir[1];
                
//                 if(nbrI>=0 && nbrJ>=0 && nbrI<m && nbrJ<n && image[nbrI][nbrJ]==origColor) {
//                     image[nbrI][nbrJ] = color;
//                     q.add(new int[] {nbrI, nbrJ});
//                 }
//             }
//         }
//         return image;
//     }
    
    
    // 2.2) BFS 2
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origColor = image[sr][sc];
        if(origColor==color)
            return image;
        
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sr,sc});
        
        while(!q.isEmpty()) {
            int[] cur = q.remove();
            
            image[cur[0]][cur[1]] = color;
            
            for(int[] dir : dirs) {
                int nbrI = dir[0] + cur[0];
                int nbrJ = dir[1] + cur[1];
                
                if(nbrI>=0 && nbrJ>=0 && nbrI<m && nbrJ<n && image[nbrI][nbrJ]==origColor)
                    q.add(new int[] {nbrI, nbrJ});
            }
        }
        return image;
    }
}