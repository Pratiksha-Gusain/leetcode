class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org = image[sr][sc];
        if(org==color) return image;
        dfs(sr,sc,image,org,color);
        return image;
    }
    void dfs(int i, int j,int[][] image, int org, int color){
        if(i<0||i>=image.length||j<0||j>=image[0].length||image[i][j]!=org) 
            return;
        image[i][j]=color;
        dfs(i-1,j,image,org,color);
        dfs(i+1,j,image,org,color);
        dfs(i,j-1,image,org,color);
        dfs(i,j+1,image,org,color);

    }
}