import java.util.*;
import java.io.*;

public class Main{
	static int[] sq;
	static int[] psum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		for(int c = 0;c<C;c++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			sq = new int[N+1];
			psum = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1;i<=N;i++){
				sq[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 1;i<=N;i++){
				psum[i] = psum[i-1] + sq[i];
			}
			double ret = Double.MAX_VALUE;
			for(int l = 1;l<=N-L+1;l++){
				for(int r = l+L-1;r<=N;r++){
					ret = Math.min(ret,getAverage(l,r));	
				}
			}
			System.out.println(ret);
		}
	}
	static double getAverage(int l, int r){
		int sum = psum[r] - psum[l-1];
		return (double)sum / (r-l+1);
	}
}
