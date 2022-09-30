class Solution {
    
    /*
    [
    ["O","O","O","O","X","X"],
    ["O","O","O","O","O","O"],
    ["O","X","O","X","O","O"],
    ["O","X","O","O","X","O"],
    ["O","X","O","X","O","O"],
    ["O","X","O","O","O","O"]]
    
    [
    ["O","O","O","O","X","X"],
    ["O","O","O","O","O","O"],
    ["O","X","O","X","O","O"],
    ["O","X","O","X","X","O"],
    ["O","X","O","X","O","O"],
    ["O","X","O","O","O","O"]]
    
    [
    ["O","O","O","O","X","X"],
    ["O","O","O","O","O","O"],
    ["O","X","O","X","O","O"],
    ["O","X","O","O","X","O"],
    ["O","X","O","X","O","O"],
    ["O","X","O","O","O","O"]]
    
    
    [
    ["X","O","O","X","X","X","O","X","O","O"],
    ["X","O","X","X","X","X","X","X","X","X"],
    ["X","X","X","X","X","X","X","X","X","X"],
    ["X","X","X","X","X","X","X","X","X","O"],
    ["O","X","X","X","X","X","X","X","X","X"],
    ["X","X","X","X","X","X","X","X","X","X"],
    ["O","X","X","X","X","X","X","X","X","O"],
    ["O","X","X","X","X","X","X","X","X","X"],
    ["X","X","X","X","X","X","X","X","X","O"],
    ["X","X","X","O","O","X","O","X","X","O"]]
    
    [
    ["X","O","O","X","X","X","O","X","O","O"],
    ["X","O","X","X","X","X","X","X","X","X"],
    ["X","X","X","X","X","X","X","X","X","X"],
    ["X","X","X","X","X","X","X","X","X","O"],
    ["O","X","X","X","X","X","X","X","X","X"],
    ["X","X","X","X","X","X","X","X","X","X"],
    ["O","X","X","X","X","X","X","X","X","O"],
    ["O","X","X","X","X","X","X","X","X","X"],
    ["X","X","X","X","X","X","X","X","O","O"],
    ["X","X","X","O","O","X","O","X","X","O"]]
    */
    
    private int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0 ; i<m ; i++) { 
            flip(board, i, 0);
            flip(board, i, n-1);
        }
        
        for(int j=0 ; j<n ; j++) {
            flip(board, 0, j);
            flip(board, m-1, j);
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
    
    private void flip(char[][] board, int i, int j) {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != 'O')
            return;
        
        board[i][j] = '-';
        for(int[] dir : dirs) {
            flip(board, i+dir[0], j+dir[1]);
        }
    }
    
    
//     public void solve(char[][] board) {
//         int m = board.length;
//         int n = board[0].length;
        
//         for(int i=1 ; i<m-1 ; i++) {
//             for(int j=1 ; j<n-1 ; j++) {
//                 if(board[i][j] == 'O') {
//                     board[i][j] = 'X';
                    
//                     if(!flip(board, i, j)) {
//                         board[i][j] = 'O';
//                     }
//                 }
//             }
//         }
//     }
    
//     private boolean flip(char[][] board, int i, int j) {
//         int m = board.length;
//         int n = board[0].length;
        
//         if(i==0 || j==0 || i==m-1 || j==n-1)
//             return false;
        
//         for(int[] dir : dirs) {
//             int nbrI = i+dir[0];
//             int nbrJ = j+dir[1];
            
//             if(nbrI>=0 && nbrJ>=0 && nbrI<m && nbrJ<n && board[nbrI][nbrJ]=='O') {
//                 board[nbrI][nbrJ] = 'X';
                
//                 if(!flip(board, nbrI, nbrJ)) {
//                     board[nbrI][nbrJ] = 'O';
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
}