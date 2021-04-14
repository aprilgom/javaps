import java.util.*;
import java.io.*;

public class Main{
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1,0};
	static int[] dy = {0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){

			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n][n];

			for(int i = 0;i<n;i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0;j<n;j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if(jump()){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
	static boolean jump(){
		Queue<Integer> q = new ArrayDeque<>();
		q.add(0);
		q.add(0);
		visited[0][0] = true;
		boolean ret = false;
		while(!q.isEmpty()){
			int y = q.remove();
			int x = q.remove();
			int d = map[y][x];
			for(int i = 0;i<2;i++){
				int ty = y + dy[i]*d;
				int tx = x + dx[i]*d;
				if(ty<0 || ty>=n || tx<0 || tx>=n){
					continue;
				}
				if(visited[ty][tx]){
					continue;
				}
				if(ty == n-1 && tx == n-1){
					ret = true;
					break;
				}
				visited[ty][tx] = true;
				q.add(ty);
				q.add(tx);
			}
		}
		return ret;
	} 
}
