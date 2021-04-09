import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long[] tree = new long[N];
		long r = 0;
		for(int i = 0;i<N;i++){
			tree[i] = Long.parseLong(st.nextToken());
			r = Math.max(r,tree[i]);
		}
		long l = 0;
		long mid = 0;
		long sum = 0;
		while(l<=r){
			mid = (l+r)/2;
			sum = 0;
			for(int i = 0;i<N;i++){
				if(tree[i]>mid){
					sum += tree[i] - mid;
				}
			}
			if(sum >= M){
				l = mid+1;
			}else{
				r = mid-1;
			}
		}
		System.out.print(r);
	}
}
