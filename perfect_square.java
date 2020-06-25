
public class perfect_square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPerfectSquare(681));
		System.out.println(isPerfectSquareOptimise(681));
	}

	public static boolean isPerfectSquare(int num) {
		String x1 = String.valueOf(Math.sqrt(num));
		int len = x1.length();
		for (int i = (x1.indexOf(".") + 1); i < len; i++) {
			if (x1.charAt(i) != '0') {
				return false;
			}
		}
		return true;

	}
	 public static boolean isPerfectSquareOptimise(int num) {
	        int left = 1, right = num;
	        while (left <= right) {
	            int mid = left + (right - left) / 2; // to avoid overflow incase (left+right)>2147483647
	            int res = num / mid, remain = num % mid;
	            if (res == mid && remain == 0) return true; // check if mid * mid == num
	            if (res > mid) { // mid is small -> go right to increase mid
	                left = mid + 1;
	            } else {
	                right = mid - 1; // mid is large -> to left to decrease mid
	            }
	        }
	        return false;
	    }

}
