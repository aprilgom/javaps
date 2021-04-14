import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-- > 0){
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] sq = new int[n+1];
			for(int i = 1;i<=n;i++){
				sq[i] = Integer.parseInt(st.nextToken());
			}
			int ret = 0;
			boolean[] visited = new boolean[n+1];
			for(int i = 1;i<=n;i++){
				if(visited[i])continue;
				int j = i;
				while(!visited[j]){
					visited[j] = true;
					j = sq[j];
				}
				int k = i;
				while(k != j){
					ret++;
					k = sq[k];
				}
			}
			System.out.println(ret);
		}
	}
}
