package leetcode;

import java.util.Stack;

// https://leetcode.com/problems/remove-k-digits/
public class remoke_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeKdigits("1432219",3));
	}
	static String removeKdigits(String num, int k) {
        if(k==num.length()) {
        	return "0";
        }else {
        	Stack<Character> stk = new Stack<Character>();
        	String ans = "";
        	//check if number is greater then number
        	for(int i=0;i<num.length();i++) {
        		while(!stk.isEmpty() && k>0 && stk.peek()>num.charAt(i)) {
        			k--;
        			stk.pop();
        		}
        		stk.push(num.charAt(i));
        	}
        	 //remove element all element in sorted order
            while(!stk.isEmpty() && k>0) {
    			k--;
    			stk.pop();
    		}
            // build the answer by reversing stack
            while (!stk.isEmpty()) {
                ans =  ans + stk.pop();
            }
            num="";
            for(int i=ans.length()-1;i>=0;i--) {
            	num = num + ans.charAt(i);
            }
            return removeZeros(num);
        }
        
    }
	private static String removeZeros(String reverse) {
        int start = 0;
        while (start < reverse.length() && reverse.charAt(start) == '0') {
            start++;
        }
        return start >= reverse.length() ? "0" : reverse.substring(start); 
    }
}
