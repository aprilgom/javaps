import java.io.*;
import java.util.*;

public class Main{
	static int[][][] dp;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new int[100000][2][2];
		for(int i = 0;i<T;i++){
			for(int[][] rrow:dp){
				for(int[] row:rrow){
					Arrays.fill(row,-1);
				}
			}
			int n = Integer.parseInt(br.readLine());
			String[] su = br.readLine().split(" ");
			String[] sd = br.readLine().split(" ");
			int[][] lines = new int[n][2];
			for(int j = 0;j<n;j++){
				lines[j][1] = Integer.parseInt(su[j]);
				lines[j][0] = Integer.parseInt(sd[j]);
			}
			dp[0][0][0] = 0;
			dp[0][1][0] = lines[0][1];
			dp[0][0][1] = lines[0][0];
			for(int x = 0;x<n-1;x++){
				dp[x+1][0][0] = Math.max(dp[x][1][0],dp[x][0][1]);
				dp[x+1][1][0] = lines[x+1][1] + Math.max(dp[x][0][0],dp[x][0][1]);
				dp[x+1][0][1] = lines[x+1][0] + Math.max(dp[x][0][0],dp[x][1][0]);
			}
			int m = Math.max(dp[n-1][1][0],dp[n-1][0][1]);
			m = Math.max(m,dp[n-1][0][0]);
			System.out.println(m);
		}
	}
}
