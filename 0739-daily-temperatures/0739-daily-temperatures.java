class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack<Integer> st = new Stack<>();
        // int[] ans = new int[temperatures.length];
        // for(int i=0;i<temperatures.length;i++){
        //     while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
        //         int idx = st.pop();
        //         ans[idx] = i - idx;
        //     }
        //     st.push(i);
        // }
        // return ans;
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
                result[i] = 0;
            }
            else{
                result[i] = st.peek()-i;
            }
            st.push(i);
        }
        return result;
        
    }
}