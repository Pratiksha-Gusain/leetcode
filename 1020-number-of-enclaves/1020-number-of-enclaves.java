class Solution {
    public int numEnclaves(int[][] grid) {
        int count=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[i][0]==1) dfs(grid,i,0);
            if(grid[i][m-1]==1) dfs(grid,i,m-1);
        }
        for(int j=0;j<m;j++){
            if(grid[0][j]==1) dfs(grid,0,j);
            if(grid[n-1][j]==1) dfs(grid,n-1,j);
        }
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]==1) count++;
            }
        }
        return count;
    }
    void dfs(int[][] board, int i, int j){
        if(i>=0 && j>=0 && j<board[0].length && i<board.length && board[i][j]==1){
            board[i][j]=-1;
            dfs(board,i-1,j);
            dfs(board,i+1,j);
            dfs(board,i,j-1);
            dfs(board,i,j+1);
        }
    }
}