class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (checkPossible(words[i], words[j]) && 1 + dp[j] > dp[i]){
                    dp[i] = 1+ dp[j];
                }
            }
            if (dp[i] > maxi){
                maxi = dp[i];
            }
        }
        return maxi;
    }
     private static boolean checkPossible(String s, String s1) {
        if (s.length() != s1.length()+1){
            return false;
        }
        int first = 0;
        int second = 0;

        while (first < s.length()){
            if (second < s1.length() && s.charAt(first) == s1.charAt(second)){
                first++;
                second++;
            }
            else {
                first++;
            }
        }
        if (first == s.length() && second == s1.length()){
            return true;
        }
        else return false;
    }
}