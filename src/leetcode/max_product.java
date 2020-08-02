package leetcode;
//https://leetcode.com/problems/max-dot-product-of-two-subsequences/
public class max_product {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,1,-2,5};
		int b[] = {3,0,-6};
		System.out.print(maxDotProduct(a,b));
	}
	public static int maxDotProduct(int[] A, int[] B) {
        int n = A.length, m = B.length, dp[][] = new int[n][m];
        for (int i = 0; i < n; ++i) {
            // dp[i] = new int[m];
            for (int j = 0; j < m; ++j) {
                dp[i][j] = A[i] * B[j];
                if (i > 0 && j > 0) dp[i][j] += Math.max(dp[i-1][j-1], 0);
                if (i > 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                if (j > 0) dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }
        return dp[n-1][m-1];
    }

}
