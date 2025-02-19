class Solution {
    public int diagonalSum(int[][] mat) {
      int  n=mat.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                     sum+=mat[i][j];
               
                if(j==n-i-1)
                  sum+=mat[i][j];

            }
        }
         if(n%2!=0)
                    sum-=mat[n/2][n/2];
            
        return sum;
    }
}