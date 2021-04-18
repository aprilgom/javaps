import java.util.*;
import java.io.*;

public class Main{
	static int[][] tri;
	static int[][] cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			int n = Integer.parseInt(br.readLine());
			tri = new int[n][n];
			cnt = new int[n][n];
			for(int i = 0;i<n;i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				Arrays.fill(cnt[i],1);
				for(int j = 0;j<=i;j++){
					tri[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i = n-2;i>=0;i--){
				for(int j = 0;j<=i;j++){
					int l = tri[i][j]+tri[i+1][j];
					int r = tri[i][j]+tri[i+1][j+1];
					if(l > r){
						cnt[i][j] = cnt[i+1][j];
					}else if(l<r){
						cnt[i][j] = cnt[i+1][j+1];
					}else{
						cnt[i][j] = cnt[i+1][j] + cnt[i+1][j+1];
					}
					tri[i][j] = Math.max(l,r);
				}
			}
			System.out.println(cnt[0][0]);
		}

	}
}
