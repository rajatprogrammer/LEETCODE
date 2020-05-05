import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-string-chain/submissions/
public class longestStringchain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestStringchain ob1 = new longestStringchain();
		String arr[] = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
		String inp1[] = {"cdhpvxzzz","chpvzzz","chpvxzzz","chpvzz","chvzz"};
		System.out.print(ob1.longestStrChain(inp1));
	}
	 public int longestStrChain(String[] words) {
		 Map<String,Integer> h1 = new HashMap<String,Integer>();
      	 int maxCharlen=1;
		 Arrays.sort(words,(a, b) ->a.length()-b.length());
		 for(int i=0;i<words.length;i++) {
			 h1.put(new String(words[i]),1);
		 }
//		 for(int j=words.length-1;j>=0;j--) {
//			 String temp = words[j];
//			 temp = temp.substring(0,temp.length()-1);
//			 int count=1;
//			 while(h1.containsKey(temp)) {
//				 ++count;
//				 temp=temp.substring(0,temp.length()-1);
//			 }
//			 if(count>maxCharlen) {
//				 maxCharlen=count;
//			 }
//		 }
		 for(int i=0;i<words.length;i++) {
			 for(int k=i+1;k<words.length;k++) {
				String s1 = words[i];
				String s2 = words[k];
				if(s1.length()==s2.length())
					continue;
				if(s2.length()-s1.length()>1)
					break;
				if(!oneCharDiff(s1,s2)) continue;
				 h1.put(new String(words[k]),Math.max(h1.get(s2), h1.get(s1)+1));
				 maxCharlen =Math.max(maxCharlen, h1.get(s2));
			 }
		 }
	    return maxCharlen;
    }
	 public  boolean oneCharDiff(String small, String big) {
	        for(int i=0; i<small.length(); i++) {
	            if(small.charAt(i)!=big.charAt(i)) {
	            	return small.substring(i).equals(big.substring(i+1));
	            }
	        }
	        
	        return true;
	    }
}
