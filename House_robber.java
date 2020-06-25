// https://leetcode.com/problems/house-robber/
// DP SOLUTION	
public class House_robber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length <= 2) return Math.max(nums[0], nums[nums.length - 1]);
        if (nums.length == 3) return Math.max(nums[0] + nums[2], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + nums[0];
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            dp[i] = Math.max(dp[i - 3] + nums[i], dp[i]);
        }
        return dp[nums.length - 1];


    }

}
