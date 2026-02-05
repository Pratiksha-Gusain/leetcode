class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int time=0;
        int fresh=0;
        Queue<int[]> q =new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)
                    q.offer(new int[]{i,j});
                else if(grid[i][j]==1)
                    fresh++;
            }
        }
        int[] drow={0,1,0,-1};
        int[] dcol={-1,0,1,0};
        while(!q.isEmpty() && fresh>0){
            int size = q.size();
            time++;
            while(size!=0){
                int[] arr = q.poll();
                int i=arr[0];
                int j= arr[1];
                for(int k=0;k<4;k++){
                    int row =i+drow[k];
                    int col=j+dcol[k];
                    if(row<0||col<0||row>=n||col>=m||grid[row][col]==0||grid[row][col]==2) continue;
                    q.offer(new int[]{row,col});
                    fresh--;
                    grid[row][col]=2;

                }
                size--;
            }
            
        }
        if(fresh==0) return time;
        else return -1;
    }
}