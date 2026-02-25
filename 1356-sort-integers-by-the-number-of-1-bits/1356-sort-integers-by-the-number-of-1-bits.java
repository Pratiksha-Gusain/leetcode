class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxed = new Integer[arr.length];
        for(int i = 0; i< arr.length; i++){
            boxed[i] = arr[i];
        }
        Arrays.sort(boxed, (a,b)->{
            int counta = Integer.bitCount(a);
            int countb = Integer.bitCount(b);
            if(counta == countb){
                return a.compareTo(b);
            }
            return Integer.compare(counta,countb);
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }
        return arr;
    }
}