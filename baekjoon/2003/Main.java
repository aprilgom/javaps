import java.util.*;
import java.io.*;
public class Main{
	static int[] sq;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		sq = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++){
			sq[i] = Integer.parseInt(st.nextToken());
		}
		int ret = 0;
		int l = 0;
		int r = 0;
		int sum = 0;
		while(true){
			if(sum > M){
				sum -= sq[l++];
			}else{
				if(r == N){
					break;
				}
				sum += sq[r++];
			}
			if(sum == M){
				ret++;
			}
		}
		System.out.println(ret);
	}
}
