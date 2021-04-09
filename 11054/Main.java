import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][2];
		String[] s = br.readLine().split(" ");
		int[] sq = Arrays.stream(s)
			.mapToInt(i -> Integer.parseInt(i))
			.toArray();
		dp[0][0] = 1;
		for(int i = 1;i<n;i++){
			int max = 0;
			for(int j = 0;j<i;j++){
				if(sq[i]>sq[j]){
					max = Math.max(max,dp[j][0]);
				}
			}
			dp[i][0] = max+1;
		}
		dp[n-1][1] = 1;
		for(int i = n-2;i>=0;i--){
			int max = 0;
			for(int j = n-1;j>i;j--){
				if(sq[i]>sq[j]){
					max = Math.max(max,dp[j][1]);
				}
			}
			dp[i][1] = max+1;
		}
		int max = 0;
		for(int i = 0;i<n;i++){
			max = Math.max(max,dp[i][0]+dp[i][1]-1);
		}
		System.out.println(max);
	}
}
