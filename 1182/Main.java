import java.util.*;
import java.io.*;

public class Main{
	static int[] sq;
	static int ret = 0;
	static int N,S;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		sq = new int[N+1];
		for(int i = 1;i<=N;i++){
			sq[i] = Integer.parseInt(st.nextToken());
		}
		sol(0,0);
		System.out.println(ret);
	}
	static void sol(int idx,int sum){
		for(int i = idx+1;i<=N;i++){
			sol(i,sum+sq[i]);
			if(sum+sq[i] == S){
				ret++;
			}
		}
	}
}
