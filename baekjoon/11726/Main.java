import java.io.*;

public class Main{
	static int[] dp;
	static int N;
	static int sol(int l){
		if(l>N){
			return 0;
		}
		if(dp[l]>0){
			return dp[l];
		}
		if(l==N){
			return 1;
		}
		int ret = 0;
		ret += sol(l+1);
		ret += sol(l+2)*2;
		dp[l] = ret%10007;
		return ret%10007;
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		int ret = sol(0);
		System.out.println(ret);
	}
}
