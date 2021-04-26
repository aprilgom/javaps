import java.io.*;
import java.util.*;

public class Main{
	static int[] dp;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		Arrays.fill(dp,-1);
		System.out.print(sol(N));
	}
	static int sol(int idx){
		if(dp[idx] != -1){
			return dp[idx];
		}
		if(idx < 1){
			return Integer.MAX_VALUE;
		}
		if(idx == 1){
			return 0;
		}
		int ret = Integer.MAX_VALUE;
		if(idx%3 == 0){
			ret = Math.min(ret,sol(idx/3)+1);
		}
		if(idx%2 == 0){
			ret = Math.min(ret,sol(idx/2)+1);
		}
		ret = Math.min(ret,sol(idx-1)+1);
		dp[idx] = ret;
		return ret;
	}
}
