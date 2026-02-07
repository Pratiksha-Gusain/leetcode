class Solution {
    public class Pair{
        int i;
        int j;
        int step;
        Pair(int i , int j,int step){
            this.i= i;
            this.j= j;
            this.step = step;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        boolean vis[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,1));
        int dir[][] = { {1,0}, {-1,0}, {0,1}, {0,-1},{1,1}, {1,-1}, {-1,1}, {-1,-1}};
        vis[0][0]=true;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(curr.i==n-1 && curr.j==m-1) return curr.step;
            for(int d[]: dir){
                int row =curr.i+d[0];
                int col=curr.j+d[1];
                if(row>=0 && col>=0 && row<n &&col<m && !vis[row][col]){
                    vis[row][col]=true;
                    if(grid[row][col]==0){
                        q.offer(new Pair(row,col,curr.step+1));
                    }
                }
            }
        }
        return -1;
    }
}