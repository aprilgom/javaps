import java.util.*;
import java.io.*;

public class Main{
	static int[] A;
	static int[] B;
	static int[][] dp;
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			A = new int[n];
			B = new int[m];
			dp = new int[n+1][m+1];
			for(int i = 0;i<n+1;i++){
				Arrays.fill(dp[i],-1);
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<n;i++){
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<m;i++){
				B[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(jlis(-1,-1)-2);
		}
	}
	static int jlis(int a_idx,int b_idx){
		if(dp[a_idx+1][b_idx+1] != -1){
			return dp[a_idx+1][b_idx+1];
		}
		int ret = 2;
		long a = (a_idx == -1 ? Long.MIN_VALUE : A[a_idx]);
		long b = (b_idx == -1 ? Long.MIN_VALUE : B[b_idx]);
		long bigger = Math.max(a,b);

		for(int i = a_idx+1;i<n;i++){
			if(bigger < A[i]){
				ret = Math.max(ret,jlis(i,b_idx)+1);
			}
		}
		for(int i = b_idx+1;i<m;i++){
			if(bigger < B[i]){
				ret = Math.max(ret,jlis(a_idx,i)+1);
			}
		}
		dp[a_idx+1][b_idx+1] = ret;
		return ret;
	} 
}
