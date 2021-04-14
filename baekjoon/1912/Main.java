import java.io.*;
import java.util.*;


public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] sq = Arrays.stream(s)
			.mapToInt(i->Integer.parseInt(i))
			.toArray();
		int[] dp = new int[sq.length];
		int max = sq[0];
		dp[0] = sq[0];
		for(int i = 1;i<sq.length;i++){
			if(dp[i-1]>0){
				dp[i] = sq[i] + dp[i-1];
			}else{
				dp[i] = sq[i];
			}
			max = Math.max(max,dp[i]);
		}
		System.out.println(max);
	}
}
