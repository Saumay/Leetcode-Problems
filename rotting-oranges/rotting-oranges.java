class Solution {
    
    private int[][] dirs = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0)
            return -1;
        
        int m = grid.length;
        int n = grid[0].length;
        
        Set<String> fresh = new HashSet<>();
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(grid[i][j] == 2)
                    q.add(new int[] {i,j});
                else if(grid[i][j] == 1)
                    fresh.add(stringify(i,j));
            }
        }
        if(fresh.isEmpty())
            return 0;
        
        int time=0;
        while(!q.isEmpty()) {
            int size = q.size();
                                    
            for(int i=0 ; i<size ; i++) {
                int[] cell = q.remove();
                
                fresh.remove(stringify(cell[0], cell[1]));
                
                if(fresh.isEmpty())
                    return time;
                
                for(int[] dir : dirs) {
                    int nbrI = cell[0] + dir[0];
                    int nbrJ = cell[1] + dir[1];
                    
                    if(nbrI>=0 && nbrJ>=0 && nbrI<m && nbrJ<n && grid[nbrI][nbrJ]==1) {
                        grid[nbrI][nbrJ] = 2;
                        q.add(new int[] {nbrI, nbrJ});
                    }
                }
            }
            time++;
        }
        return -1;
    }
    
    private String stringify(int x, int y) {
        return String.valueOf(x) + "," + String.valueOf(y);
    }
}