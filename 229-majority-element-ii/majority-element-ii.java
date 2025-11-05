class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1=Integer.MIN_VALUE;
        int num2=Integer.MIN_VALUE;
        int count1=0;
        int count2=0;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(count1==0&&nums[i]!=num2){
                num1=nums[i];
                count1++;
            }
            else if(count2==0&&nums[i]!=num1){
                num2=nums[i];
                count2++;
             }
            else if(num1==nums[i])  
                count1++;
            else if(num2==nums[i])  
                count2++;
            else{
                count1--; 
                count2--;
            }   
        }
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num1) count1++;
            if(nums[i]==num2) count2++;
        }
        int min=nums.length/3+1;
        if(count1>=min) list.add(num1);
        if(count2>=min) list.add(num2);
        return list;
    }
}