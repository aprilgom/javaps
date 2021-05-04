import java.io.*;
import java.util.*;

public class Main{
	static int n;
	static int[] sq;
	static int[][] dp;
	static int l,r;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			n = Integer.parseInt(br.readLine());
			l = 0;
			r = n-1;
			sq = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0;i<n;i++){
				sq[i] = Integer.parseInt(st.nextToken());
			}
			dp = new int[50][50];
			for(int i = 0;i<50;i++){
				Arrays.fill(dp[i],-987654321);
			}
			System.out.println(play(l,r));
		}
	}
	static int play(int l,int r){
		if(l>r){
			return 0;
		}
		if(dp[l][r] != -987654321){
			return dp[l][r];
		}
		int ret = Math.max(sq[l] - play(l+1,r),sq[r] - play(l,r-1));
		if(r-l+1 >= 2){
			ret = Math.max(ret,-play(l+2,r));
			ret = Math.max(ret,-play(l,r-2));
		}
		dp[l][r] = ret;
		return ret;
	}
}
