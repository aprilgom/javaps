import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++){
			int N = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int[] sq = new int[N+1];
			boolean[] visited = new boolean[N+1];
			for(int i = 1;i<=N;i++){
				sq[i] = Integer.parseInt(s[i-1]);
			}
			int count = 0;
			for(int i = 1;i<=N;i++){
				if(!visited[i]){
					count++;
				}
				int j = i;
				while(!visited[j]){
					visited[j] = true;
					j = sq[j];
				}
			}
			System.out.println(count);
		}
	}
}
