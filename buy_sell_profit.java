package leetcode;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class buy_sell_profit {
	int buyCach[];
	int sellCach[];
	static int dd=0;
	buy_sell_profit(int n){
		buyCach=new int[n];
		sellCach=new int[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,0,2};
		buy_sell_profit ob1 =new buy_sell_profit(arr.length);
		System.out.println(ob1.buycache(arr,0));
		System.out.println(buy(arr,0));
        System.out.print(maxProfitDp(arr));
	}
	public static int buy(int arr[],int i) {
		if(i>=arr.length) {
			return 0;
		}else {
			return Math.max(sell(arr,i+1)-arr[i],buy(arr,i+1));
		}
	}
	public static int sell(int arr[],int i) {
		if(i>=arr.length) {
			return 0;
		}else {
			return Math.max(buy(arr,i+2)+arr[i],sell(arr,i+1));
		}
	}
	public  int buycache(int arr[],int i) {
		if(i>=arr.length) {
			return 0;
		}if(buyCach[i]!= 0) 
            return buyCach[i];
		else {
			buyCach[i]=Math.max(sellcache(arr,i+1)-arr[i],buycache(arr,i+1));
			return buyCach[i];
		}
	}
	public  int sellcache(int arr[],int i) {
		if(i>=arr.length) {
			return 0;
		}if(sellCach[i]!= 0) 
            return sellCach[i];
		else {
			sellCach[i] =Math.max(buycache(arr,i+2)+arr[i],sellcache(arr,i+1));
			return sellCach[i];
		}
	}
	public static int maxProfitDp(int[] a) {
		int[][] dp;
        if (a == null || a.length == 0)
            return 0;
        int n = a.length;
        // 0 - buy, 1 - cool down , 2 - SELL
        // 
        dp = new int[n][3];
    
        dp[0][0] = -a[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for(int i = 1; i < n; i++){
            // yesterday must be cooldown to buy today or could have bot yday and we use it
            // since our aim is to get best price (so compare cool down and buy today or yday price)
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - a[i]);
            // for today to cool down - should have bot or sold yday or cool down yday
            dp[i][1] = Math.max( Math.max(dp[i-1][0],dp[i-1][2]), dp[i-1][1]);
            // for today to sell - could have bought yday or earlier and sold tody OR sold yday or earlier. 
            dp[i][2] = Math.max(dp[i-1][0] + a[i], dp[i-1][2]) ;
            // System.out.println(" i = " + i + " BUY = " + dp[i][0] + " COOL= " + dp[i][1] + "SELL= " + dp[i][2]);
        }
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1],dp[n-1][2]));
    }
	
}
