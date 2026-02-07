class Solution {
    public int minimumEffortPath(int[][] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[]{0, 0, 0});
        int maxEffort = 0;
        int[][] visited = new int[n][m];
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int effort = curr[0];
            int row = curr[1];
            int col = curr[2];
            maxEffort = Math.max(maxEffort, effort);
            if(row==n-1 && col==m-1) return maxEffort;
            visited[row][col]=1;
            int [][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for(int[] d : dir){
                int newRow = row+d[0];
                int newCol = col+d[1];
                if(newRow>=0 && newCol>=0 && newRow<n && newCol<m && visited[newRow][newCol]==0){
                    int newEffort= Math.abs(heights[newRow][newCol]-heights[row][col]);
                    q.offer(new int[]{newEffort,newRow,newCol});
                }
            }
        }
        return maxEffort;
    }
}