class Solution {    
    public int evalRPN(String[] tokens) {
        HashSet<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<String> stack = new Stack<>();
        
        for(String token : tokens){
            if(operators.contains(token)){
                stack.push(operate(stack.pop(), stack.pop(), token));
            }else{
                stack.push(token);
            }
        }
        
        return Integer.parseInt(stack.pop());
    }
    
    public String operate(String b, String a, String token){
        int num1 = Integer.parseInt(b);
        int num2 = Integer.parseInt(a);
        
        String res = "";
        if(token.equals("+")){
            res = (num2 + num1) + "";
        }else if(token.equals("-")){
            res = (num2 - num1) + "";
        }else if(token.equals("*")){
            res = (num2 * num1) + "";
        }else{
            res = (num2 / num1) + "";
        }
        
        return res;
    }
}