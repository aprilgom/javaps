import java.util.*;
import java.io.*;

public class Main{
	static int N,K;
	static int[] seq;
	static int[] dp;
	static long[] count_dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0;tc<TC;tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());	

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			seq = new int[N+1];
			dp = new int[N+1];
			count_dp = new long[N+1];
			Arrays.fill(dp,-1);
			Arrays.fill(count_dp,-1);
			for(int i = 1;i<=N;i++){
				seq[i] = Integer.parseInt(st.nextToken());
			}
			sb.append(lis(0)-1)
				.append("\n");
			List<Integer> ret = new ArrayList<>();
			recon(0,K-1,ret);
			for(int i:ret){
				sb.append(i).append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
	static int lis(int idx){
		if(dp[idx] != -1){
			return dp[idx];
		}
		int ret = 1;
		for(int i = idx+1;i<=N;i++){
			if(seq[idx] < seq[i]){
				ret = Math.max(ret,1+lis(i));
			}
		}
		dp[idx] = ret;
		return ret;
	}
	static long count(int idx){
		if(lis(idx) == 1){
			return 1;
		}
		if(count_dp[idx] != -1){
			return count_dp[idx];
		}
		long ret = 0;
		for(int i = idx+1;i<=N;i++){
			if(seq[idx] < seq[i] && lis(idx) == lis(i)+1){
				ret = Math.min(Integer.MAX_VALUE,ret + count(i));
			}
		}
		count_dp[idx] = ret;
		return ret;
	}
	static void recon(int idx,int skip,List<Integer> ret){
		if(idx != 0){
			ret.add(seq[idx]);
		}
		for(int i = N;i>=idx+1;i--){
			if(seq[idx]<seq[i] && lis(idx) == lis(i)+1){
				if(count(i) <= skip){
					skip -= count(i);
				}else{
					recon(i,skip,ret);
					break;
				}
			}
		}
	}
}
