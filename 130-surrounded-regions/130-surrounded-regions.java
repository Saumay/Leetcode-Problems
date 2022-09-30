class Solution {
    
    // 1) DFS
    private int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0 ; i<m ; i++) { 
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }
        
        for(int j=0 ; j<n ; j++) {
            dfs(board, 0, j);
            dfs(board, m-1, j);
        }
        
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '-')
                    board[i][j] = 'O';
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j) {
        if(board[i][j] != 'O')
            return;
        
        board[i][j] = '-';
        for(int[] dir : dirs) {
            int nbrI = dir[0] + i;
            int nbrJ = dir[1] + j;
            
            if(nbrI>=0 && nbrJ>=0 && nbrI<board.length && nbrJ<board[0].length)
                dfs(board, i+dir[0], j+dir[1]);
        }
    }
    
    
    // 2) BFS
//     private int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    
//     public void solve(char[][] board) {
//         int m = board.length;
//         int n = board[0].length;
        
//         Queue<int[]> q = new ArrayDeque<>();
//         for(int i=0 ; i<m ; i++) {
//             if(board[i][0] == 'O')
//                 q.add(new int[] {i,0});
//             if(board[i][n-1] == 'O')
//                 q.add(new int[] {i,n-1});
//         }
        
//         for(int j=0 ; j<n ; j++) {
//             if(board[0][j] == 'O')
//                 q.add(new int[] {0,j});
//             if(board[m-1][j] == 'O')
//                 q.add(new int[] {m-1,j});
//         }
        
//         bfs(board, q);
        
//         for(int i=0 ; i<m ; i++) {
//             for(int j=0 ; j<n ; j++) {
//                 if(board[i][j] == 'O')
//                     board[i][j] = 'X';
//                 else if(board[i][j] == '-')
//                     board[i][j] = 'O';
//             }
//         }
//     }
    
//     private void bfs(char[][] board, Queue<int[]> q) {
//         while(!q.isEmpty()) {
//             // R
//             int[] cur = q.remove();
            
//             // P
//             board[cur[0]][cur[1]] = '-';
            
//             // A
//             for(int[] dir : dirs) {
//                 int nbrI = cur[0] + dir[0];
//                 int nbrJ = cur[1] + dir[1];
                
//                 if(nbrI>=0 && nbrJ>=0 && nbrI<board.length && nbrJ<board[0].length && board[nbrI][nbrJ]=='O')
//                     q.add(new int[] {nbrI, nbrJ});
//             }
//         }
//     }
    
    
    // 3) Union Find
//     private int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
    
//     public void solve(char[][] board) {
//         int m = board.length;
//         int n = board[0].length;
        
//         DisjointSet ds = new DisjointSet(m*n+1);
//         int boundary = m*n;
        
//         for(int i=0 ; i<m ; i++) {
//             for(int j=0 ; j<n ; j++) {
//                 if(board[i][j] == 'O') {
//                     if(isBorder(i,j,m,n))
//                         ds.union(boundary, getId(i, j, n));
//                     else {
//                         for(int[] dir : dirs) {
//                             int nbrI = i+dir[0];
//                             int nbrJ = j+dir[1];
                            
//                             if(nbrI>=0 && nbrJ>=0 && nbrI<m && nbrJ<n && board[nbrI][nbrJ]=='O')
//                                 ds.union(getId(i,j,n), getId(nbrI,nbrJ,n));
//                         }
//                     }
//                 }
//             }
//         }
        
//         for(int i=0 ; i<m ; i++) {
//             for(int j=0 ; j<n ; j++) {
//                 if(ds.find(boundary) != ds.find(getId(i,j,n)))
//                     board[i][j] = 'X';
//             }
//         }
//     }
    
//     private boolean isBorder(int i, int j, int m, int n) {
//         return i==0 || j==0 || i==m-1 || j==n-1;
//     }
    
//     private int getId(int i, int j, int n) {
//         return n*i + j;
//     }
    
//     class DisjointSet {
//         int[] root;
//         int[] rank;
        
//         public DisjointSet(int n) {
//             root = new int[n];
//             rank = new int[n];
            
//             for(int i=0 ; i<n ; i++) {
//                 root[i] = i;
//                 rank[i] = 1;
//             }
//         }
        
//         public int find(int x) {
//             if(root[x]==x)
//                 return x;
            
//             root[x] = find(root[x]);
//             return root[x];
//         }
        
//         public void union(int x, int y) {
//             int rootX = find(x);
//             int rootY = find(y);
            
//             if(rootX != rootY) {
//                 if(rank[rootX] < rank[rootY])
//                     root[rootX] = rootY;
//                 else if(rank[rootX] > rank[rootY])
//                     root[rootY] = rootX;
//                 else {
//                     root[rootY] = rootX;
//                     rank[rootX]++;
//                 }
//             }
//         }
//     }
}