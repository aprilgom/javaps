import java.util.*;
import java.io.*;

public class Main{
	static int n,m;
	static double[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			dp = new double[m+1][n+1];
			for(int i = 0;i<m;i++){
				Arrays.fill(dp[i],-1);
			}
			System.out.println(count(0,0));
		}
	}
	static double count(int day,int h){
		if(day>m){
			return 0;
		}
		if(h>=n){
			return 1;
		}
		if(dp[day][h] != -1){
			return dp[day][h];
		}
		double ret = 0.25*count(day+1,h+1) + 0.75*count(day+1,h+2);
		dp[day][h] = ret;
		return ret;
	}
}
