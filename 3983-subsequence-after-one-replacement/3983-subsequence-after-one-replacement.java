class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int  n = s.length();
        int m = t.length();
        if(n>m) return false;
        int[] pref = new int[n+1];
        pref[0] = -1;
        int j = 0;
        for(int i = 0; i < n; i++){
            while(j<m && t.charAt(j) != s.charAt(i)){
                j++;
            }
            if(j == m){
                pref[i+1] = m;
            }
            else{
                pref[i+1] = j;
                j++;
            }
        }

        int[] suff = new int[n+1];
        suff[n] = m;
        j = m-1;
        for(int i = n-1; i >= 0; i--){
            while(j >= 0 && t.charAt(j) != s.charAt(i)){
                j--;
            }
            if(j == 0){
                suff[i] = -1;
            }
            else{
                suff[i] = j;
                j--;
            }
        }
        for(int i = 0; i<n; i++){
            if(pref[i]<suff[i+1]-1){
                return true;
            }
        }
        return false;
        
    }
}