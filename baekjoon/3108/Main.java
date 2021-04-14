import java.util.*;
import java.io.*;

public class Main{
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] map; 
	static boolean[][] visited; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map	= new int[2001][2001];
		visited	= new boolean[2001][2001];
		for(int t = 0;t<N;t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) + 500;
			int lo = Integer.parseInt(st.nextToken()) + 500;
			int r = Integer.parseInt(st.nextToken()) + 500;
			int hi = Integer.parseInt(st.nextToken()) + 500;
			l *= 2;
			lo *= 2;
			r *= 2;
			hi *= 2;
			for(int i = l;i<=r;i++){
				map[lo][i] = 1;
				map[hi][i] = 1;
			}
			for(int i = lo;i<=hi;i++){
				map[i][l] = 1;
				map[i][r] = 1;
			}
		}
		int ret = 0;
		Stack<Integer> stk = new Stack<>();
		for(int y = 0;y<=2000;y++){
			for(int x = 0;x<=2000;x++){
				if(map[y][x] == 0 || visited[y][x]){
					continue;
				}
				ret++;
				stk.add(y);
				stk.add(x);
				while(!stk.isEmpty()){
					int qx = stk.pop();
					int qy = stk.pop();
					for(int i = 0;i<4;i++){
						int tx = qx + dx[i];
						int ty = qy + dy[i];
						if(tx<0 || tx>2000 || ty<0 ||ty > 2000){
							continue;
						}
						if(map[ty][tx] == 0 || visited[ty][tx]){
							continue; }
						visited[ty][tx] = true;
						stk.add(ty);
						stk.add(tx);
					}
				}
			}
		}
		if(visited[1000][1000]){
			ret--;
		}
		System.out.println(ret);
	}
}
