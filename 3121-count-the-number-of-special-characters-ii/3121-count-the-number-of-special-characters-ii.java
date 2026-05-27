class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        java.util.Arrays.fill(lower, -1);
        java.util.Arrays.fill(upper, -1);
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char a = word.charAt(i);
            if (Character.isLowerCase(a)) {
                lower[a - 'a'] = i ;
            } else {
                int idx = a - 'A';
                if (upper[idx] == -1)
                    upper[idx] = i;
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] != -1 && upper[i] != -1 && lower[i] < upper[i])
                ans++ ;
        }
        return ans;
    }
}