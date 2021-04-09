import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] sq = Arrays.stream(s)
			.mapToInt(i->Integer.parseInt(i))
			.toArray();
		int[] dp = new int[n];
		dp[0] = 1;
		for(int i = 0;i<n;i++){
			int max = 0;
			for(int j = 0;j<i;j++){
				if(sq[i]<sq[j]){
					max = Math.max(max,dp[j]);
				}
			}
			max++;
			dp[i] = max;
		}
		int max = 0;
		for(int i = 0;i<n;i++){
			max = Math.max(dp[i],max);
		k
		System.out.println(max);
	}
}
