class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0, ten=0, twenty=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]==10){
               if(five>0){
                five--;
                ten++;
               }
               else return false;
            }
            else{
                if(five>0&&ten>0){
                    five--;
                    ten--;
                    twenty++;
                }
                else if(five>=3){
                    five=five-3;
                    twenty++;
                }
                else return false;
            }
        }
        return true;
    }
}