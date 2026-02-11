class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low=grid[0][0];
        int high =0;
        for (int[] row : grid){
            for (int val : row)
                high = Math.max(high, val);
        }
        while(low<high){
            int mid= low+(high-low)/2;
            int[][] vis = new int[n][n];
            if(dfs(grid,n,mid,0,0,vis)) high = mid;
            else low=mid+1;
        }
        return low;
    } 
    boolean dfs(int[][] grid,int n, int mid,int i, int j, int[][] vis){
        if(i==n-1 && j==n-1) return true;
        vis[i][j]=1;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] d : dir){
            int nr = i+d[0];
            int nc = j+d[1];
            if(nr>=0 && nr<n && nc>=0 && nc<n && vis[nr][nc]==0 && grid[i][j]<=mid && grid[nr][nc]<=mid){
               if(dfs(grid,n,mid,nr,nc,vis)) return true;
            }
        }
        return false;

    }
}