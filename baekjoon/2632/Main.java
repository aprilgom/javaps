import java.util.*;
import java.io.*;

public class Main{
	static int m,n;
	static int[] A,B,a_psum,b_psum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int order = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		A = new int[m];
		B = new int[n];
		a_psum = new int[2*m+1];
		b_psum = new int[2*n+1];

		for(int i = 0;i<m;i++){
			A[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1;i<=m;i++){
			a_psum[i] = a_psum[i-1] + A[i-1];
		}
		for(int i = m+1;i<=2*m;i++){
			a_psum[i] = a_psum[i-m] + a_psum[m];
		}

		for(int i = 0;i<n;i++){
			B[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1;i<=n;i++){
			b_psum[i] = b_psum[i-1] + B[i-1];
		}
		for(int i = n+1;i<=2*n;i++){
			b_psum[i] = b_psum[i-n] + b_psum[n];
		}

		List<Integer> a_psums = new ArrayList<>();
		for(int i = 0;i<m;i++){
			for(int j = i;j<i+m-1;j++){
				a_psums.add(psum(a_psum,m,i,j));
			}
		}
		a_psums.add(a_psum[0]);
		a_psums.add(a_psum[m]);

		List<Integer> b_psums = new ArrayList<>();
		for(int i = 0;i<n;i++){
			for(int j = i;j<i+n-1;j++){
				b_psums.add(psum(b_psum,n,i,j));
			}
		}
		b_psums.add(b_psum[0]);
		b_psums.add(b_psum[n]);

		int ret = 0;
		for(int ai:a_psums){
			for(int bi:b_psums){
				int sum = ai+bi;
				if(sum == order){
					ret++;
				}
			}
		}
		System.out.println(ret);
	}
	static int psum(int[] arr,int max,int l,int r){
		return arr[r+1] - arr[l];
	}
}
