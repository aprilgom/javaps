import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[4][N];
		for(int i = 0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j<4;j++){
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		int[] sum_l = new int[N*N];
		int[] sum_r = new int[N*N];
		int sum_c = 0;
		for(int i = 0;i<N;i++){
			for(int j = 0;j<N;j++){
				int lsum = arr[0][i] + arr[1][j];
				int rsum = arr[2][i] + arr[3][j];
				sum_l[sum_c] = lsum;
				sum_r[sum_c] = rsum;
				sum_c++;
			}
		}
		Arrays.sort(sum_l);
		Arrays.sort(sum_r);

		int l = 0;
		int r = sum_r.length-1;
		long ret = 0;
		while(l<sum_l.length && r>=0){
			int sum = sum_l[l] + sum_r[r];
			if(sum > 0){
				r--;
			}else if(sum < 0){
				l++;
			}else{
				long rc = 1;
				long lc = 1;
				r--;
				l++;
				while(r >=0 && sum_r[r] == sum_r[r+1]){
					rc++;
					r--;
				}
				while(l < sum_l.length && sum_l[l] == sum_l[l-1]){
					lc++;
					l++;
				}
				ret += rc*lc;
			}
		}
		System.out.println(ret);
	}
}
