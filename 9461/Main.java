import java.util.*;
import java.io.*;

public class Main{
	static long[] dp;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		for(int i = 0;i<T;i++){
			int N = Integer.parseInt(br.readLine());
			if(dp[N]==0){
				for(int j = 6;j<=N;j++){
					dp[j] = dp[j-1] + dp[j-5];
				}
			}
			System.out.println(dp[N]);
		}
	}
}
