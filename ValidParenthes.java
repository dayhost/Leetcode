import java.util.*;
public class ValidParenthes {
	public static void main(String[] args){
		System.out.println(isValid(" )"));
		System.out.println(isValid(""));
		System.out.println(isValid(""));
	}
	
    public static boolean isValid(String s) {
    	Stack<Character> stack = new Stack<Character>();
    	for(int i=0; i<s.length(); i++){
    		if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
    			stack.push(s.charAt(i));
    		}else if(s.charAt(i)==')'&&!stack.isEmpty()){
    			if(stack.pop()=='('){
    				continue;
    			}else{
    				return false;
    			}
    		}else if(s.charAt(i)==']'&&!stack.isEmpty()){
    			if(stack.pop()=='['){
    				continue;
    			}else{
    				return false;
    			}
    		}else if(s.charAt(i)=='}'&&!stack.isEmpty()){
    			if(stack.pop()=='{'){
    				continue;
    			}else{
    				return false;
    			}
    		}else{
    			return false;
    		}
    	}
    	if(stack.isEmpty()){
    		return true;
    	}else{
    		return false;
    	}
    }
}