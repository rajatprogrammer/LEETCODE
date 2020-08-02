package leetcode;
//https://leetcode.com/problems/counting-bits/
//concept used when we right shift the even number then no bit is lost as the lsb is 0 in the last bit
//when we do right shift in odd number 1 bit is lost because lsb is 1 in the last bit
//let say number is x so  x=x/2 bits in case of even and if x is odd the x=x/2 +1 are the  1 bit so we get 
//the bit value of number on basis of lower number bit value
//https://www.youtube.com/watch?v=iuqr5hHk2MI
public class counting_bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countBits(15);
		countBits(19);
		countBits(20);
	}
	public static int[] countBits(int num) {
		int arr[] = new int[num+1];
        arr[0]=0;
        if(num>=1){
         arr[1]=1;
		for(int i=2;i<=num;i++) {
			if(i%2==0) {
				arr[i] = arr[i/2];
			}else {
				arr[i] = arr[i/2]+1;
			}
		}   
        }
		return arr;
    }

}
