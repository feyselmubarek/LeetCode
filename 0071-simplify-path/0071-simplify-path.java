class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for(String p : paths){
            if(!p.equals("") && !p.equals(".")){
                if(p.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }else{
                    stack.push(p);
                }
            }
        }
        
        
        Stack<String> q = new Stack<>();
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
        
        StringBuilder builder = new StringBuilder("/");
        while(!q.isEmpty()){
            builder.append(q.pop());
            if(!q.isEmpty()){
                builder.append("/");
            }
        }
        
        return builder.toString();
    }
}