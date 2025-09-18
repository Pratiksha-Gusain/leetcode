class Solution {
    public boolean isSafe(int row, int col, char[][] board){
        for(int i=0;i<board.length;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int j=0;j<board.length;j++){
            if(board[row][j]=='Q'){
                return false;
            }
        }
        int r=row;
        for(int c=col;c>=0 && r>=0;r--, c--){
            if(board[r][c] =='Q'){
                return false;
            }
        }
        r=row;
        for(int c=col;c<board.length && r>=0;r--, c++){
            if(board[r][c] =='Q'){
                return false;
            }
        }
        r=row;
        for(int c=col;c>=0 && r<board.length;r++, c--){
            if(board[r][c] =='Q'){
                return false;
            }
        }
        r=row;
        for(int c=col;c<board.length && r<board.length;r++, c++){
            if(board[r][c] =='Q'){
                return false;
            }
        }
        return true;
    }
    public void saveBoard(char[][] board, List<List<String>> allboards){
        String row ="";
        List<String> newboard = new ArrayList<>();
        for(int i = 0;i<board.length;i++){
            row="";
            for(int j =0 ; j<board[0].length;j++){
                if(board[i][j]=='Q')
                    row+= 'Q';
                else 
                    row+='.';
            }
            newboard.add(row);
        }
        allboards.add(newboard);
    }
    public void helper(char[][] board, List<List<String>> allboards, int col){
        if(col==board.length){
            saveBoard(board, allboards);
            return;
        }
        for(int row = 0; row<board.length; row++){
            if(isSafe(row,col,board)){
                board[row][col]='Q';
                helper(board,allboards,col+1);
                board[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allboards = new ArrayList<>();
        char[][] board = new char [n][n];
        helper(board, allboards, 0);
        return allboards;
    }
}