class Solution {
    public boolean isSafe(int row, int col, char[][] board){
        int r = row;
        int c = col;
        while(row >=0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = r;
        col = c;
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        row = r;
        col = c;
        while(row < board.length && col >= 0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
    public void helper(char[][] board, List<List<String>> ans, int col){
        if(col==board.length){
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int row = 0; row<board.length; row++){
            if(isSafe(row,col,board)){
                board[row][col]='Q';
                helper(board,ans,col+1);
                board[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char [n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        helper(board, ans, 0);
        return ans;
    }
}