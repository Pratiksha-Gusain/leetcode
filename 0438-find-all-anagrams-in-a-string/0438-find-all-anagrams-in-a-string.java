class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length(), m = p.length();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0; i < m; i++){
            freq1[p.charAt(i)-'a']++;
        }
        int l = 0;
        for(int r = 0; r < n; r++){
            freq2[s.charAt(r)-'a']++;
            if(r-l+1>m){
                freq2[s.charAt(l)-'a']--;
                l++;
            }
            if(r-l+1 == m && Arrays.equals(freq1,freq2)){
                ans.add(l);
            }
        }
        return ans;
    }
}