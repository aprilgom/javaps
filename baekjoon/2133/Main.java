import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N==1){
			System.out.println(0);
			return;
		}
		int[][] dp = new int[N+1][2];
		dp[0][0] = 1;//A
		dp[2][0] = 3;
		dp[0][1] = 1;//Sum
		for(int i = 2;i<=N-2;i+=2){
			dp[i+2][0] = 3*dp[i][0]+2*dp[i-2][1];
			dp[i][1] = dp[i-2][1] + dp[i][0];
		}
		System.out.println(dp[N][0]);
	}
}
