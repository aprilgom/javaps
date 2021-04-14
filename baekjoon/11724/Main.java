import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static int M;
	static int[][] conn;
	static int[] visited;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		conn = new int[N+1][N+1];
		visited = new int[N+1];

		for(int i = 0;i<M;i++){
			String[] l = br.readLine().split(" ");
			int x = Integer.parseInt(l[0]);
			int y = Integer.parseInt(l[1]);
			conn[x][y] = 1;
			conn[y][x] = 1;
		}
		Stack<Integer> stk = new Stack<>();
		int count = 0;
		for(int i = 1;i<=N;i++){
			if(visited[i] != 0)continue;
			count++;
			stk.push(i);
			while(!stk.isEmpty()){
				int x = stk.pop();
				visited[x] = count;
				for(int y = 1;y<=N;y++){
					if(visited[y] == 0 && conn[x][y] == 1){
						stk.push(y);
					}
				}
			}
		}
		System.out.println(count);
	}
}
