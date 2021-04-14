//dfs로 풀어보자!
//권장하지 않음.
//이런 짓을 하고 있으면 모두 미쳐버린다..!

import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static int K;
	static int lim;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[100001];
		Arrays.fill(dp,Integer.MAX_VALUE); 

		if(K <= N){
			System.out.println(N-K);
			return;
		}

		int l = 0;
		int r = 1;
		lim = r;
		while(!move(N,0)){
			l = r;
			r*=2;
			lim = r;
		}
		
		while(l+1<r){
			int mid = (l+r)/2;
			lim = mid;
			if(move(N,0)){
				r = mid;
			}else{
				l = mid;
			}
		}
		System.out.println(l+1);
	}
	static boolean move(int n,int step){
		if(n == K){
			return true;
		}
		if(step==lim){
			return false;
		}
		if(n>100000 || n<0){
			return false;
		}
		if(dp[n] < step){
			return false;
		}
		dp[n] = step;
		step++;
		boolean ret = false;
		if(n < K){
			ret |= move(n*2,step);
			if(ret)return ret;
			ret |= move(n+1,step);
			if(ret)return ret;
		}
		ret |= move(n-1,step);
		return ret;
	}
}
