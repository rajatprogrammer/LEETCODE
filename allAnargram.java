package leetcode;

import java.util.ArrayList;
import java.util.List;

public class allAnargram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ob1 = findAnagrams("abcddbacletcab","abc");
		for(Integer x:ob1) {
			System.out.print("->" + x);
		}
	}
	 public static List<Integer> findAnagrams(String s, String p) {
	        List<Integer> ans = new ArrayList<>();
	        int[] cnt = new int[128];
	        for (char c : p.toCharArray()) cnt[c]--;
	        for (int r = 0, l = 0; r < s.length(); r++) {
	            if (++cnt[s.charAt(r)] > 0) { // If number of characters `s[r]` is more than our expectation
	                while (s.charAt(l) != s.charAt(r)) // Remove until we found char `s[r]`
	                    cnt[s.charAt(l++)]--;
	                cnt[s.charAt(l++)]--; // Remove char `s[r]` so cnt[s[r]] can be 0
	            } else if (r - l + 1 == p.length()) { // If the size of our range == p.length
	                                                // and there are no characters have greater numbers than we expect
	                ans.add(l); // Add `l` to our result
	                cnt[s.charAt(l++)]--; // Go next
	            }
	        }
	        return ans;
	    }


}
