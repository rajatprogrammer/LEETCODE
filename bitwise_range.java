///https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/?currentPage=1&orderBy=hot&query=
//https://www.youtube.com/watch?v=-qrpJykY2gE
public class bitwise_range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(rangeBitwiseAnd(19, 29));
		
	}
	public static  int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        if (m == 0) {
            return 0;
        }
        int start = log2(n - m) + 1;
        int end =  log2(m);
        
        int mask = createBitMask(start, end);
        return m & mask & n;
    }
    
    private static int log2(int num) {
        return (int) (Math.log(num) / Math.log(2));
    }
    
    private static int createBitMask(int startPos, int endPos) {
        int m1 = -1 << (endPos + 1);
        int m2 = -1 << startPos;
        int m3 = ~m1;
        return m2 & m3;
    }
    static int rangeBitwiseAnd1(int m, int n) {
        int count=0;
      // simple solution is to do bitwise and and return the sum. 
     //     for(int i=m;i<=n;i++)
     //               sum&=i;        
		 //      return sum;
       while(m!=n)  // see till both numbers are equal
       {   // right shift both numbers by 1
           m>>=1; 
           n>>=1;
           count++;  // increment the count.
       }
		//count gives the number of zero places from the lsb so left shift m by count.
       return m<<count;
   }
    
    

}
