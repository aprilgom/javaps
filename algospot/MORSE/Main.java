import java.util.*;
import java.io.*;

public class Main{
	static int TC,k;
	static int[][] bino;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		bino = new int[201][201];
		sb = new StringBuilder();
		calc_bino();
		for(int tc = 0;tc<TC;tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			morse(n,m);
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
	static void morse(int n,int m){
		if(n == 0){
			for(int i = 0;i<m;i++){
				sb.append("o");
			}
			return;
		}
		if(m == 0){
			for(int i = 0;i<n;i++){
				sb.append("-");
			}
			return;
		}
		if(k <= bino[n+m-1][n-1]){
			sb.append("-");
			morse(n-1,m);
		}else{
			sb.append("o");
			k -= bino[n+m-1][n-1];
			morse(n,m-1);
		}
	}
	static void calc_bino(){
		bino[0][0] = 0;
		for(int i = 1;i<=200;i++){
			bino[i][0] = 1;
			for(int j = 1;j<=i-1;j++){
				bino[i][j] = bino[i-1][j-1] + bino[i-1][j];
				bino[i][j] = Math.min(bino[i][j],1000000000);
			}
			bino[i][i] = 1;
		}
	}
}
