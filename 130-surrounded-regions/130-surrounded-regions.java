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
        if(board[i][j] != 'O')
            return;
        
        board[i][j] = '-';
        for(int[] dir : dirs) {
            int nbrI = dir[0] + i;
            int nbrJ = dir[1] + j;
            
            if(nbrI>=0 && nbrJ>=0 && nbrI<board.length && nbrJ<board[0].length)
                flip(board, i+dir[0], j+dir[1]);
        }
    }
}