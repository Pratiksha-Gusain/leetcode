class Solution {
    public int maxRepeating(String sequence, String word) {
        String toFind = word;
        int ans =0;
        while(sequence.contains(toFind)){
            toFind += word;
            ans++;
        }
        return ans;
    }
}