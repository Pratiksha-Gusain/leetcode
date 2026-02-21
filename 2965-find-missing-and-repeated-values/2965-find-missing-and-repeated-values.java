class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int res[]=new int[2];
        int n=grid.length;
        int size = n*n;
        int freq[]=new int[size+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                freq[grid[i][j]]++;
            }
        }
        for(int num = 1; num <= size; num++){
            if(freq[num]==2) res[0]=num;
            if(freq[num]==0) res[1]=num;
        }
        return res;

    }
}