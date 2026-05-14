class Solution {
    public boolean isGood(int[] nums) {
        int max = 0;

        for (int x : nums) {
            max = Math.max(max, x);
        }

        if (nums.length != max + 1)
            return false;

        int[] freq = new int[max + 1];

        for (int x : nums) {
            if (x < 1 || x > max)
                return false;

            freq[x]++;
        }
        for (int i = 1; i < max; i++) {

            if (freq[i] != 1)
                return false;
        }
        return freq[max] == 2;
    }

}