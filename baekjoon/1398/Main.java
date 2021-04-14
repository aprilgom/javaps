import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[100];
		Arrays.fill(dp,Integer.MAX_VALUE);
		int[] coins = new int[]{1,10,25};

		dp[0] = 0;
		for(int i = 1;i<100;i++){
			for(int j:coins){
				if(i - j >= 0){
					dp[i] = Math.min(dp[i-j]+1,dp[i]);
				}
			}
		}
		for(int t = 0;t<T;t++){
			long n = Long.parseLong(br.readLine());
			int ret = 0;
			while(n>0){
				int idx = (int)(n%100);
				ret += dp[idx];
				n /= 100;
			}
			System.out.println(ret);
		}
	}
}
