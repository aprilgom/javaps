import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] P = Arrays.stream(s)
			.mapToInt(i->Integer.parseInt(i))
			.toArray();
		int[] dp = new int[N];
		dp[0] = P[0];
		for(int i = 1;i<N;i++){
			int max = P[i];
			for(int j = 0;j<=(i-1)/2;j++){
				max = Math.max(max,dp[j]+dp[i-1-j]);
			}
			dp[i] = max;
		}
		System.out.println(dp[N-1]);
	}
}
