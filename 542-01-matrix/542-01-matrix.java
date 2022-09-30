class Solution {
    // BFS
    private int[][] dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] dist = new int[m][n];        
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(mat[i][j]==0) {
                    dist[i][j] = 0;
                    q.add(new int[]{i,j});
                } else {
                    dist[i][j] = -1;
                }
            }
        }
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0 ; i<size ; i++) {
                int[] cell = q.remove();
                
                for(int[] dir : dirs) {
                    int nbrI = cell[0] + dir[0];
                    int nbrJ = cell[1] + dir[1];
                    
                    if(nbrI>=0 && nbrJ>=0 && nbrI<m && nbrJ<n && dist[nbrI][nbrJ]==-1) {
                        dist[nbrI][nbrJ] = dist[cell[0]][cell[1]] + 1;
                        q.add(new int[] {nbrI, nbrJ});
                    }
                }
            }
        }
        return dist;
    }
}