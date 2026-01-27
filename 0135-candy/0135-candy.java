class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int i=1, sum=n;
        while(i<n){
            if(ratings[i]==ratings[i-1]){
                i++;
                continue;
            }
            int peak=0;
            while(i<n && ratings[i]>ratings[i-1]){
                peak+=1;
                sum+=peak;
                i++;
            }
            int down=0;
            while(i<n && ratings[i]<ratings[i-1]){
                down+=1;
                sum+=down;
                i++;
            }
            sum-=Math.min(peak,down);
        }
        return sum;
    }
}