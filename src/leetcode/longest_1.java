package leetcode;
//https://leetcode.com/problems/number-of-substrings-with-only-1s/
public class longest_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(numSub("1000000001111111010101001011101001"));
	}
	public static int numSub(String s) {
        int res = 0, count = 0, mod =(int)Math.pow(10,9)+7;
        for (int i = 0; i < s.length(); ++i) {
            count = s.charAt(i) == '1' ? count + 1 : 0;
            res = (res + count) % mod;
        }
        return res;
    }
}
