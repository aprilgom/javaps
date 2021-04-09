import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String[] s = br.readLine().split(" ");
		int[] conn = Arrays.stream(s)
			.mapToInt(i->Integer.parseInt(i))
			.toArray();
		int n = conn.length;
		int k = Integer.parseInt(br.readLine());
		
		boolean[][] joints = new boolean[n+1][n+1];
		for(int i = 0;i<n-1;i++){
			for(int j = i+1;j<n;j++){
				if(conn[i] > conn[j]){
					joints[n-i][n-j] = true;
					joints[n-j][n-i] = true;
				}	
			}
		}
		int[] dp = new int[n+1];
		int count = 1;
		int lbn = 1;
		dp[1] = 1;
		count += dp[1];
		for(int i = 2;i<=n;i++){
			if(count>=k){
				break;
			}
			dp[i] = 1;
			for(int j = 1;j<i;j++){
				if(!joints[i][j]){
					dp[i] += dp[j];
				}
			}
			count += dp[i];
			lbn = i;
		}
		if(k>count){
			System.out.println(-1);
			return;
		}

		int ret = 1<<lbn-1;
		for(int i = lbn-1;i>=1;i--){
			if(!joints[i][lbn]){
				if(count-dp[i] < k){
					ret |= 1<<i-1;
					lbn = i;
				}else{
					count-=dp[i];
				}
			}
		}
		System.out.println(ret);
	}
}
