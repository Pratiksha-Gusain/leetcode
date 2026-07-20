class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int total = m * n;
        k %= total;

        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++)
                row.add(0);
            ans.add(row);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int oldIndex = i * m + j;
                int newIndex = (oldIndex + k) % total;

                int newRow = newIndex / m;
                int newCol = newIndex % m;

                ans.get(newRow).set(newCol, grid[i][j]);
            }
        }
        return ans;


    }
}