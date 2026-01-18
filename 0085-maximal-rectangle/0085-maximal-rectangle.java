class Solution {
     public int largestRectangleArea(int[] heights) {
        Stack <Integer> stack  = new Stack<>();
        int maxArea=0;
        int n=heights.length;

        for(int i=0;i<=n;i++){
            while(!stack.isEmpty()&& (i==n||heights[stack.peek()]>heights[i])){
                int height=heights[stack.pop()];
                int width;
                if(stack.isEmpty())
                    width =i;
                else
                    width=i-stack.peek()-1;
                maxArea=Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n= matrix.length;
        int m=matrix[0].length;
        int[] prefixSum= new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]!=0)
                    prefixSum[j]+=1;
                else
                    prefixSum[j]=0;
            }
            int area = largestRectangleArea(prefixSum);
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
}