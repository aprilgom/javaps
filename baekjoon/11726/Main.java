import java.io.*;

public class Main{
	static int[] dp;
	static int N;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		System.out.println(sol(0));
	}
	static int sol(int idx){
		if(idx > N){
			return 0;
		}
		if(idx == N){
			return 1;
		}
		if(dp[idx] != 0){
			return dp[idx];
		}
		int ret = (sol(idx+1) + sol(idx+2))%10007;
		dp[idx] = ret;
		return ret;
	}
}
