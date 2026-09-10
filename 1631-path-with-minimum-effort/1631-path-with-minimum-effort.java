class Solution {
    public int minimumEffortPath(int[][] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[] { 0, 0, 0 });
        int maxEffort = 0;
        int[][] dist = new int[n][m];
        for(int[] d: dist){
            Arrays.fill(d, (int)1e9);
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int effort = curr[0];
            int row = curr[1];
            int col = curr[2];
            if (row == n - 1 && col == m - 1)
                return effort;
            int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            for (int[] d : dir) {
                int newRow = row + d[0];
                int newCol = col + d[1];
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                    int newEffort = Math.max(Math.abs(heights[newRow][newCol] - heights[row][col]), effort);
                    if(newEffort < dist[newRow][newCol]){
                        dist[newRow][newCol] = newEffort;
                        q.offer(new int[] { newEffort, newRow, newCol });
                    }
                        
                }
            }
        }
        return 0;
    }
}