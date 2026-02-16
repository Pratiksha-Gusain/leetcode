class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;  
        }
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i-1];  
            String word2 = words[i]; 
            int len = Math.min(word1.length(),word2.length());
            boolean smaller=false;
            for(int j=0;j<len;j++){
                int rank1=map[word1.charAt(j)-'a'];
                int rank2=map[word2.charAt(j)-'a'];
                if(rank1<rank2){
                    smaller=true;
                    break;
                }
                if(rank1>rank2) return false;
            }
            if (!smaller && word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }
}