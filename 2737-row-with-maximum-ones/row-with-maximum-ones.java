class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int c=0;
        int r=0;
        int max=0;
        for(int i=0;i<mat.length;i++){
            c=0;
            for(int j=0;j<mat[0].length;j++){
                c+=mat[i][j];
                if(c>max){
                    max=c;
                    r=i;
                }
            }
        }
        
        int[]ans={r,max};
        
       return ans;
    }
}