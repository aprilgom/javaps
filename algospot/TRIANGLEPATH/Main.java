import java.util.*;
import java.io.*;

public class Main{
	static int[][] tri;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			int N = Integer.parseInt(br.readLine());
			tri = new int[N][N];
			for(int h = 0;h<N;h++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int w = 0;w<h+1;w++){
					tri[h][w] = Integer.parseInt(st.nextToken());
				}
			}
			for(int h = 1;h<N;h++){
				tri[h][0] += tri[h-1][0];
				for(int w = 1;w<h;w++){
					int lu = tri[h][w] + tri[h-1][w-1];
					int u = tri[h][w] + tri[h-1][w];
					tri[h][w] = Math.max(lu,u);
				}
				tri[h][h] += tri[h-1][h-1];
			}
			int ret = 0;
			for(int i = 0;i<N;i++){
				ret = Math.max(ret,tri[N-1][i]);
			}
			System.out.println(ret);
		}
	}
}
