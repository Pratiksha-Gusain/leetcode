class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat ==null) return new int[0][0];
        int n=mat.length;
        int m= mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j,0});
                    vis[i][j] = 1;
                } 
                
            }
        }
        int[][] dist = new int[n][m];
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int steps = curr[2];
            dist[row][col] = steps;
            for(int[] i: dir){
                int r=row+i[0];
                int c=col+i[1];
                if(r >=0 && r < n && c >=0 && c < m && vis[r][c]==0){
                    vis[r][c] = 1;
                    q.offer(new int[]{r,c, steps+1});
                    
                }
            }
        }
        return dist;
    }
}