import java.util.*;
import java.io.*;

public class Main{
	static boolean[] visited;
	static int[][] pairs;
	static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			visited = new boolean[N];
			pairs = new int[M][2];
			st = new StringTokenizer(br.readLine());
			for(int m = 0;m<M;m++){
				pairs[m][0] = Integer.parseInt(st.nextToken());
				pairs[m][1] = Integer.parseInt(st.nextToken());
			}
			System.out.println(count(0));
		}
	}
	static int count(int idx){
		boolean tmp = true;
		for(int i = 0;i<N;i++){
			tmp &= visited[i];
		}
		if(tmp){
			return 1;
		}

		int ret = 0;
		for(int i = idx;i<M;i++){
			int a_idx = pairs[i][0];
			int b_idx = pairs[i][1];
			if(visited[a_idx] || visited[b_idx]){
				continue;
			}
			visited[a_idx] = true;
			visited[b_idx] = true;
			ret += count(i+1);
			visited[a_idx] = false;
			visited[b_idx] = false;
		}
		return ret;
	}
}
