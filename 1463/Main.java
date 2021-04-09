import java.io.*;
import java.util.*;

public class Main{
	static int[] dp;
	public static void sol(int n,int count){
		if(dp[n] <= count){
			return;
		}else{
			dp[n] = count;
		}
		if(n == 1){
			return;
		}
		if(n%3 == 0){
			sol(n/3,count+1);
		}
		if(n%2 == 0){
			sol(n/2,count+1);
		}
		sol(n-1,count+1);
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		sol(N,0);
		System.out.println(dp[1]);
	}
}
