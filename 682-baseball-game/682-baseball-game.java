class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String op : ops){
            if(op.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(a + b);
            }else if(op.equals("C")){
                stack.pop();
            }else if(op.equals("D")){
                stack.push(stack.peek() * 2);
            }else{
                stack.push(Integer.parseInt(op));
            }
        }
        
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}