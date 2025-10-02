class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r= 0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(word.charAt(0)== board[r][c]){
                    boolean found = dfs(board,r,c,word,0);
                    if(found) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,int r,int c,String word,int ind){
        if(ind==word.length()) return true;
        int rows=board.length;
        int cols = board[0].length;
        if(r<0||c<0||r>=rows||c>=cols) return false;
        if(board[r][c]== ' '||board[r][c]!=word.charAt(ind)) return false;
        char ch = board[r][c];
        board[r][c]=' ';
        if(dfs(board,r-1,c,word,ind+1)||dfs(board,r+1,c,word,ind+1)||dfs(board,r,c-1,word,ind+1)||dfs(board,r,c+1,word,ind+1))
            return true;
        board[r][c]= ch;
        return false;    
    }
}