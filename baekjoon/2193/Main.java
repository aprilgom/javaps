import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static long[][] dp;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long[N+1][2];
		dp[1][0] = 1;
		dp[1][1] = 1;
		for(int i = 1;i<N;i++){
			dp[i+1][0] = dp[i][0] + dp[i][1];
			dp[i+1][1] = dp[i][0];
		}
		System.out.println(dp[N][1]);
	}
}
