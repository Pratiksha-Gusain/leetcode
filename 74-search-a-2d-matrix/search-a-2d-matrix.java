class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowidx = potentialRow(matrix,target);
        if(rowidx!=-1) return BinarySearch(rowidx, matrix, target);
        else return false;
    }
    public int potentialRow(int[][] matrix, int target){
        int low =0;
        int high = matrix.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][matrix[0].length-1]) return mid;
            else if (target>matrix[mid][0]) low=mid+1;
            else if (target<matrix[mid][0]) high=mid-1;
        }
        return -1;
    }
    public boolean BinarySearch(int rowidx, int[][]matrix, int target){
            int low=0;
            int high=matrix[rowidx].length-1;
            while(low<=high){
                int mid = low+(high-low)/2;
                if(matrix[rowidx][mid]==target) return true;
                else if(matrix[rowidx][mid]<target) low=mid+1;
                else high=mid-1;
            }
            return false;
    }
}