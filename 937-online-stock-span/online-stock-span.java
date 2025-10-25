class StockSpanner {
    List<Integer> list;
    public StockSpanner() {
        this.list=new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        int count =0;
        for(int i=list.size()-1;i>=0;i--){
            if(list.get(i)>price) break;
            count++;
        }
        return count;
    }
    public int[] spans(int[] prices){
        int res[]= new int[prices.length];
        res[0]=1;
        Stack<Integer> Stack = new Stack<>();
        Stack.push(0);
        for(int i=1;i<prices.length;i++){
            while(!Stack.isEmpty() && prices[Stack.peek()]<prices[i]) 
                Stack.pop();
            if(Stack.isEmpty()) 
                res[i]=i+1;
            else
                res[i]=i-Stack.peek();
            Stack.push(i);
        }
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */