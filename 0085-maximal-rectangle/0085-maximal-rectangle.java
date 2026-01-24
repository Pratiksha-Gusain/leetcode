
class Solution {
    private int largestRectangle(int[] heights) {
        Stack <Integer> stack  = new Stack<>();
        int maxArea=0;
        int n=heights.length;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&& (heights[stack.peek()]>=heights[i])){
                int height=heights[stack.pop()];
                int nse = i;
                int pse = stack.isEmpty()? -1:stack.peek();
                int width=nse-pse-1;
                maxArea=Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int nse = n;
            int height = heights[stack.pop()];
            int pse= stack.isEmpty()? -1:stack.peek();
            int width=nse-pse-1;
            maxArea=Math.max(maxArea,height*width);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int arr[] = new int[matrix[0].length];
        int maxArea=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
               
                if (matrix[i][j] == '1') {
                    arr[j]++;
                } else {
                    arr[j] = 0;
                }
            }
           
            maxArea = Math.max(maxArea, largestRectangle(arr));
        }
        return maxArea;
    }
}

