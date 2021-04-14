import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("");
		int[] sq = Arrays.stream(s)
			.mapToInt(i->Integer.parseInt(i))
			.toArray();
		if(sq[0] == 0){
			System.out.println(0);
			return;
		}
		int n = sq.length;
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2;i<=n;i++){
			if(sq[i-1] == 0){
				if(sq[i-2] != 1 && sq[i-2] != 2){
					System.out.println(0);
					return;
				}
				dp[i] = dp[i-2];
				continue;
			}
			dp[i] = dp[i-1];
			int x = sq[i-2]*10 + sq[i-1];
			if(x>=10 && x<=26){
				dp[i] = (dp[i-2] + dp[i-1])%1000000;
			}
		}
		System.out.println(dp[n]%1000000);
	}
}
