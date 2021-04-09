import java.util.*;
import java.io.*;
class Fenwick{
	int[] data;
	public Fenwick(int[] p){//p_idx starts from 1
		data = new int[p.length];
		for(int i = 1;i<p.length;i++){
			update(i,p[i]);
		}
	}
	public void update(int idx,int diff){
		while(idx<data.length){
			data[idx] += diff;
			idx += (idx&-idx);
		}
	}
	public int sum(int l,int r){
		return sum(r) - sum(l-1);
	}
	public int sum(int idx){
		int ret = 0;
		while(idx>0){
			ret += data[idx];
			idx -= (idx&-idx);
		}
		return ret;
	}
}

public class Main{
	static int T;
	static int[][] dp;
	static int[] data;
	static Fenwick fw;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++){
			int K = Integer.parseInt(br.readLine());
			data = new int[K+1];
			dp = new int[K+1][K+1];
			for(int i = 0;i<=K;i++){
				Arrays.fill(dp[i],Integer.MAX_VALUE);
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1;i<=K;i++){
				data[i] = Integer.parseInt(st.nextToken());
			}
			fw = new Fenwick(data);
			int ret = minp(1,K);
			System.out.println(ret);
		}
	}
	static int minp(int l,int r){
		if(l == r){
			return 0;
		}
		if(dp[l][r] != Integer.MAX_VALUE){
			return dp[l][r];
		}
		if(l+1==r){
			dp[l][r] = data[l]+data[r];
			return data[l]+data[r];
		}
		for(int i = l;i<r;i++){
			int lmin = minp(l,i);
			int rmin = minp(i+1,r);
			dp[l][r] = Math.min(dp[l][r],(lmin+rmin) + fw.sum(l,r));
		}
		return dp[l][r];
	}
}
