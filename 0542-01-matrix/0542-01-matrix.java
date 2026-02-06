class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat ==null) return new int[0][0];
        int n=mat.length;
        int m= mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int max = m*n;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0) q.offer(new int[]{i,j});
                else mat[i][j]=max;
            }
        }
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] i: dir){
                int r=curr[0]+i[0];
                int c=curr[1]+i[1];
                if(r<0||c<0||r>=n||c>=m||mat[r][c]<mat[curr[0]][curr[1]]+1) continue;
                q.offer(new int[]{r,c});
                mat[r][c]=mat[curr[0]][curr[1]]+1;

            }
        }
        return mat;
    }
}