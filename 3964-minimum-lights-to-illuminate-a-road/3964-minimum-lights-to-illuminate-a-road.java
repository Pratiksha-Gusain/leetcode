class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        int[] diff = new int[n];
        for(int i = 0; i < n; i ++){
            if(lights[i] > 0){
                int l = Math.max(0, i-lights[i]);
                int r = Math.min(n-1, i+lights[i]);
                diff[l]++;
                if(r+1 < n) diff[r+1]--;
            }
        }
        int cover = 0;
        int ans = 0;
        int darkLen = 0;
        for(int i = 0; i < n; i++){
            cover += diff[i];
            if(cover == 0){
                darkLen ++;
            }
            else{
                ans += (darkLen + 2)/3;
                darkLen = 0;
            }
        } 
        ans += (darkLen + 2)/3;
        return ans;
    }
}