public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk= new Stack();
        for(char c:s.toCharArray()){
            if( c=='(')
                stk.push(')');
            else if(c=='{')
                stk.push('}');
            else if (c=='[')
                stk.push(']');
            else
                {
                    if(stk.size()==0 || stk.pop()-c!=0) return false;
                }
        }
        return stk.size()==0;
        
    }
}