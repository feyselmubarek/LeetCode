class StockSpanner {
    Stack<Pair> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int days = 1;
        while(!stack.isEmpty() && stack.peek().price <= price){
            days += stack.peek().day;
            stack.pop();
        }
        
        stack.push(new Pair(days, price));
        return days;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
class Pair{
    int day, price;
    Pair(int day, int price){
        this.day = day;
        this.price = price;
    }
}