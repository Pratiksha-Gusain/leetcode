class Solution {
    public int[][] generateMatrix(int n) {
        int ans[][]=new int [n][n];
    int rowBegin = 0;
    int rowEnd = n- 1;
    int colBegin = 0;
    int colEnd = n - 1;
    int c=1;

    while (rowBegin <= rowEnd && colBegin <= colEnd) {
      for (int j = colBegin; j <= colEnd; j++) {
        ans[rowBegin][j]=c;
        c++;
      }
      rowBegin++;
      for (int j = rowBegin; j <= rowEnd; j++) {
        ans[j][colEnd]=c;
        c++;
      }
      colEnd--;

      if (rowBegin <= rowEnd) {
        for (int j = colEnd; j >= colBegin; j--) {
            ans[rowEnd][j]=c;
            c++;
        }
      }
      rowEnd--;

      if (colBegin <= colEnd) {
        for (int j = rowEnd; j >= rowBegin; j--) {
            ans[j][colBegin]=c;
            c++;
        }
      }
      colBegin++;
    }

    return ans;
    }
}