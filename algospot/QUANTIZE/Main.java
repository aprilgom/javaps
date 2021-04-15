import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static int S;
	static int[] A;
	static int[] p_sum;
	static int[] p_sqsum;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			A = new int[N];
			p_sum = new int[N];
			p_sqsum = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<N;i++){
				A[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(A);
			p_sum[0] = A[0];
			p_sqsum[0] = A[0]*A[0];
			for(int i = 0;i<N-1;i++){
				p_sum[i+1] = p_sum[i]+A[i+1];
				p_sqsum[i+1] = p_sqsum[i]+A[i+1]*A[i+1];
			}
			dp = new int[N][S+1];
			for(int i = 0;i<N;i++){
				Arrays.fill(dp[i],-1);
			}
			System.out.println(sol(0,S));
		}
	}
	static int sol(int idx,int s){
		if(idx == N){
			return 0;
		}
		if(s == 1){
			dp[idx][s] = err_sq_sum(idx,N-1);
			return dp[idx][s];
		}
		if(dp[idx][s] != -1){
			return dp[idx][s];
		}
		int ret = 987654321;
		for(int i = idx;i<N;i++){
			ret = Math.min(ret,err_sq_sum(idx,i) + sol(i+1,s-1));
		}
		dp[idx][s] = ret;
		return ret;
	}
	static int err_sq_sum(int l,int r){
		int len = r-l+1;
		int q = (int)Math.round((double)sum(l,r)/len);
		return len * q*q - 2*sum(l,r)*q + sq_sum(l,r); 
	}

	static int sum(int l,int r){
		if(l == 0){
			return p_sum[r];
		}
		return p_sum[r] - p_sum[l-1];
	}

	static int sq_sum(int l,int r){
		if(l == 0){
			return p_sqsum[r];
		}
		return p_sqsum[r] - p_sqsum[l-1];
	}
}
