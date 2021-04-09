import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] x = new int[N];
		for(int i = 0;i<N;i++){
			x[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(x);
		int l = 1;
		int r = x[N-1] - x[0];
		int mid = 0;
		while(l<=r){
			mid = (l+r)/2;
			int count = 1;
			int tmp = x[0];
			for(int i = 1;i<N;i++){
				if(x[i] - tmp >= mid){
					count++;
					tmp = x[i];
				}
			}
			if(count >= C){
				l = mid+1;
			}else{
				r = mid-1;
			}
		}
		System.out.println(r);
	}
}
