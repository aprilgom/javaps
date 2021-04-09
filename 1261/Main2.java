import java.util.*;
import java.io.*;

public class Main{
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int M;
	static int N;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int y = 0;y<N;y++){
			for(int x = 0;x<M;x++){
				map[y][x] = br.read()-'0';
			}	
			br.read();
		}
		int ret = sol();
		System.out.println(ret);
	}
	static int sol(){
		int[][] visited = new int[N][M];
		Deque<Integer> q = new ArrayDeque<>();
		q.add(0);
		q.add(0);
		visited[0][0] = 1;
		while(!q.isEmpty()){
			int y = q.remove();
			int x = q.remove();
			for(int i = 0;i<4;i++){
				int ty = y + dy[i];
				int tx = x + dx[i];
				if(tx<0 || tx>=M || ty<0 || ty>=N){
					continue;
				}
				if(visited[ty][tx] != 0){
					continue;
				}
				if(map[ty][tx] == 1){
					visited[ty][tx] = visited[y][x]+1;
					q.addLast(ty);
					q.addLast(tx);
					continue;
				}
				visited[ty][tx] = visited[y][x];
				q.addFirst(tx);
				q.addFirst(ty);
			}
		}
		return visited[N-1][M-1]-1;
	}
}
