import java.util.*;
import java.io.*;

public class Main{
	static int[] sq;
	static int[] dp;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			N = Integer.parseInt(br.readLine());
			sq = new int[N];
			dp = new int[N+1];
			Arrays.fill(dp,-1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0;i<N;i++){
				sq[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(lis(-1)-1);
		}
	}
	static int lis(int idx){
		if(dp[idx+1] != -1){
			return dp[idx+1];
		}
		int ret = 1;
		int now_v = (idx == -1 ? Integer.MIN_VALUE : sq[idx]);
		for(int i = idx+1;i<N;i++){
			if(now_v < sq[i]){
				ret = Math.max(ret,lis(i)+1);
			}
		}
		dp[idx+1] = ret;
		return ret;
	}
}
