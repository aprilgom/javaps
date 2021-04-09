import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int[] A_psum = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=n;i++){
			int A = Integer.parseInt(st.nextToken()); 
			A_psum[i] = A_psum[i-1]+A;
		}

		int m = Integer.parseInt(br.readLine());
		int[] B_psum = new int[m+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=m;i++){
			int B = Integer.parseInt(st.nextToken());
			B_psum[i] = B_psum[i-1]+B;
		}
		
		List<Integer> A_psum_list = new ArrayList<>();
		for(int i = 1;i<=n;i++){
			for(int j = i;j<=n;j++){
				int psum = A_psum[j]-A_psum[i-1];
				A_psum_list.add(psum);
			}
		}
		
		List<Integer> B_psum_list = new ArrayList<>();
		for(int i = 1;i<=m;i++){
			for(int j = i;j<=m;j++){
				int psum = B_psum[j]-B_psum[i-1];
				B_psum_list.add(psum);
			}
		}

		Collections.sort(A_psum_list);
		Collections.sort(B_psum_list);

		int l = 0;
		int r = B_psum_list.size()-1;
		int sum = 0;
		long ret = 0;
		while(l<A_psum_list.size() && r>=0){
			int lsum = A_psum_list.get(l);
			int rsum = B_psum_list.get(r);
			sum = lsum + rsum;
			if(sum>T){
				r--;
			}else if(sum<T){
				l++;
			}else{
				long lc = 0;
				long rc = 0;
				while(
						l < A_psum_list.size() 
					&&	A_psum_list.get(l) == lsum
					){
					l++;
					lc++;
				}
				while(
						r >= 0
					&&	B_psum_list.get(r) == rsum
					){
					r--;
					rc++;
				}
				ret += lc*rc;
			}
		}
		System.out.println(ret);
	}
}
