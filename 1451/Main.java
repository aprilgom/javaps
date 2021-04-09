import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static int M;
	static long[][] sum;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum = new long[N+1][M+1];
		for(int i = 1;i<=N;i++){
			for(int j = 1;j<=M;j++){
				long num = br.read() - '0';
				sum[i][j] = num + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
			}
			br.read();
		}
		
		long ret = 0;
		for(int y = 1;y<=N-1;y++){
			for(int x = 1;x<=M-1;x++){
				// ㅑ
				ret = Math.max(ret,sum(1,x,1,N)*sum(x+1,M,1,y)*sum(x+1,M,y+1,N));
				// ㅕ 
				ret = Math.max(ret,sum(1,x,1,y)*sum(1,x,y+1,N)*sum(x+1,M,1,N));
				// ㅛ
				ret = Math.max(ret,sum(1,x,1,y)*sum(x+1,M,1,y)*sum(1,M,y+1,N));
				// ㅠ
				ret = Math.max(ret,sum(1,M,1,y)*sum(1,x,y+1,N)*sum(x+1,M,y+1,N));
			}
		}
		// |||
		for(int i = 1;i<=M-2;i++){
			for(int j = i+1;j<=M-1;j++){
				ret = Math.max(ret,sum(1,i,1,N)*sum(i+1,j,1,N)*sum(j+1,M,1,N));	
			}
		}
		// 三
		for(int i = 1;i<=N-2;i++){
			for(int j = i+1;j<=N-1;j++){
				ret = Math.max(ret,sum(1,M,1,i)*sum(1,M,i+1,j)*sum(1,M,j+1,N));	
			}
		}
		System.out.println(ret);
	}
	static long sum(int l,int r,int lo,int hi){
		return sum[hi][r] - sum[hi][l-1] - sum[lo-1][r] + sum[lo-1][l-1];
	}
}
