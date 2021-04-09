import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] sq = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++){
			sq[i] = Integer.parseInt(st.nextToken());
		}
		int l = 0;
		int r = 0;
		int sum = 0;
		int ret = Integer.MAX_VALUE;
		while(true){
			if(sum >= S){
				ret = Math.min(ret,r-l);
				sum -= sq[l++];
			}else if (r == N){
				break;
			}else{
				sum += sq[r++];
			}
		}
		if(ret == Integer.MAX_VALUE){
			System.out.println(0);
		}else{
			System.out.println(ret);
		}
	}
}
