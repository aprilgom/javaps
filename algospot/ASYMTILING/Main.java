import java.util.*;
import java.io.*;

public class Main{
	static int n;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			n = Integer.parseInt(br.readLine());
			dp = new int[n+1];
			dp[0] = 1;
			dp[1] = 1;
			for(int i = 2;i<=n;i++){
				dp[i] = (dp[i-1]+dp[i-2])%1000000007;
			}
			int ret = 0;
			if(n%2 == 0){
				ret = (dp[n] - dp[n/2])%1000000007;
				ret = (ret - dp[n/2-1])%1000000007;
			}else{
				ret = (dp[n] - dp[n/2])%1000000007;
			}
			if(ret<0){
				ret += 1000000007;
			}
			System.out.println(ret);
		}
	}
}
