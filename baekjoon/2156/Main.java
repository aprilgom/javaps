import java.io.*;
import java.util.*;

public class Main{
	static int n;
	static int[] wine;
	static int[] dp;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		wine = new int[n+1];
		dp = new int[n+1];
		for(int i = 1;i<=n;i++){
			wine[i] = Integer.parseInt(br.readLine());
		}
		if(n == 2){
			System.out.println(wine[1]+wine[2]);	
			return;
		}
		if(n == 1){
			System.out.println(wine[1]);
			return;
		}
		dp[1] = wine[1];
		dp[2] = wine[2] + wine[1];
		int wa = wine[2] + wine[1];
		int wb = wine[3] + wine[1];
		int wc = wine[3] + wine[2];
		dp[3] =	Math.max(wa,Math.max(wb,wc));
		for(int i = 4;i<=n;i++){
			int a = wine[i] + wine[i-1] + dp[i-3];
			int b = wine[i] + dp[i-2];
			int c = dp[i-1];
			dp[i] = Math.max(a,Math.max(b,c));
		}
		System.out.println(dp[n]);
	}
}
