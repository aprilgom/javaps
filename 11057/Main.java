import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][10];
		for(int i = 0;i<10;i++){
			dp[0][i] = 1;
		}
		for(int idx = 1;idx<N;idx++){
			for(int nmb = 0;nmb < 10;nmb++){
				for(int j = 0;j<=nmb;j++){
					dp[idx][nmb] += dp[idx-1][j]%10007;
				}
			}
		}
		int sum = 0;
		for(int i = 0;i<10;i++){
			sum += dp[N-1][i];
		}
		System.out.println(sum%10007);
	}
}
