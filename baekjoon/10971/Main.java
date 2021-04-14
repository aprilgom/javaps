import java.util.stream.*;
import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static int[][] w;
	static boolean[] visited;
	static int ret = Integer.MAX_VALUE;
	static int start;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		w = new int[N][N];
		visited = new boolean[N];
		for(int i = 0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++){
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0;i<N;i++){
			visited[i] = true;
			start = i;
			travel(i,N-1,0);
			visited[i] = false;
		}
		System.out.println(ret);
	}
	static void travel(int s,int n,int fee){
		if(n == 0 && w[s][start] != 0){
			ret = Math.min(ret,fee + w[s][start]);
		}
		for(int e = 0;e<N;e++){
			if(visited[e] || w[s][e] == 0){
				continue;
			}
			visited[e] = true;
			travel(e,n-1,fee+w[s][e]);
			visited[e] = false;
		}
	}
}
