import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		long[][] dp = new long[N+1][K+1];
		//dp[n][k] k번째 숫자, n만큼 채워지는 방법의 수.
		//0<=i<=N
		//dp[1][2] = dp[0~1][1] : dp[0][2] + dp[1][1]
		//dp[2][2] = dp[0~2][1] : dp[1][2] + dp[2][1]
		//dp[3][2] = dp[0~3][1] : dp[2][2] + dp[3][1]
		//dp[n][k] = dp[0~n][k-1] : dp[n-1][k] + dp[n][k-1]
		//
		//dp[1][3] = dp[0~1][2] : dp[0][3] + dp[1][2]
		//dp[1][4] = dp[0~1][3] : dp[0][4] + dp[1][3]
		for(int k = 0;k<=K;k++){
			dp[0][k] = 1;
		}
		for(int n = 0;n<=N;n++){
			dp[n][1] = 1;
		}
		for(int k = 2;k<=K;k++){
			for(int n = 1;n<=N;n++){
				dp[n][k] = (dp[n-1][k] + dp[n][k-1])%1000000000;
			}
		}
		System.out.println(dp[N][K]);
	}
}
