class Solution {
    public int largestRectangleArea(int[] heights) {
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
}