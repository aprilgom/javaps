import java.util.*;
import java.io.*;

public class Main{

	static int[] sq;
	static int[] dp;
	static int N;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			String s = br.readLine();
			N = s.length();

			dp = new int[N];
			Arrays.fill(dp,-1);

			sq = new int[N];
			for(int i = 0;i<s.length();i++){
				sq[i] = s.charAt(i) - '0';
			}
			System.out.println(sol(0));
		}
	}
	static int classify(int l,int r){
		//[l,r]의 난이도 분류.
		int first = sq[l];
		boolean	all_same = true;
		for(int i = l+1;i<=r;i++){
			if(first != sq[i]){
				all_same = false;
				break;
			}
		}
		if(all_same){
			return 1;
		}
		boolean ap = true;
		int d = sq[l+1] - sq[l]; 
		for(int i = l+1;i<=r-1;i++){
			if(sq[i+1] - sq[i] != d){
				ap = false;
				break;
			}
		}
		if(ap && Math.abs(d) == 1){
			return 2;
		}
		boolean cross = true;
		for(int i = l;i<=r;i++){
			if(sq[i] != sq[l+(i-l)%2]){
				cross = false;
				break;
			}
		}
		if(cross){
			return 4;
		}
		if(ap){
			return 5;
		}
		return 10;
	}
	static int sol(int idx){
		//구간 [idx,N-1]의 난이도.
		if(idx == N){
			return 0;
		}
		if(dp[idx] != -1){
			return dp[idx];
		}
		int ret = 987654321;
		for(int i = 3;i<=5;i++){
			if(idx+i <= N){
				ret = Math.min(ret,classify(idx,idx+i-1)+sol(idx+i));
			}
		}
		dp[idx] = ret;
		return ret;
	}
}
