class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        for(int i = 0; i < k; i++){
            lsum += cardPoints[i];
        }
        int ans = lsum;

        int r = cardPoints.length-1;
        int rsum = 0;
        for(int i = k-1; i >=0; i--){
            lsum -= cardPoints[i];
            rsum += cardPoints[r];
            r--;
            ans = Math.max(ans, rsum+lsum);
        }
        return ans;

    }
}