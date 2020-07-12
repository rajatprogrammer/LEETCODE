package leetcode;

import java.util.HashMap;
import java.util.List;

public class repeatedSequence {
	HashMap<Integer, List<Integer>> hs = new HashMap<>();
	int Alphabet = 26;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		repeatedSequence ob1= new repeatedSequence();
		ob1.rollingHashing(pattern,10);
	}
	
	public void rollingHashing(String s,int length) {
		int primeNumber=10000007;
		for(int i=0;i<s.length();i++) {
			int hash=0;
			int tempLen=length-1;
			int pow=0;
			while(tempLen>-1) {
				//hash = hash*Alphabet + int(Math.pow(Alphabet,pow));
			}
		}
	}

}
