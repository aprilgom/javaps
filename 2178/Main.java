import java.util.*;
import java.io.*;

public class Main{

	static int[][] map; 
	static boolean[][] searched; 
	static int M;
	static int N;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static void probe(){
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{0,0,1});
		while(!q.isEmpty()){
			int[] node = q.remove();
			int x = node[0];
			int y = node[1];
			int len = node[2];
			if(x == M-1 && y == N-1){
				System.out.println(len);
				return;
			}
			for(int i = 0;i<4;i++){
				int tx = x+dx[i];
				int ty = y+dy[i];
				if(tx<0||ty<0||tx>=M||ty>=N){
					continue;
				}
				if(searched[tx][ty]||map[x][y] == 0){
					continue;
				}
				searched[tx][ty] = true;
				q.add(new int[]{tx,ty,len+1});
			}
		}
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[M][N];
		searched = new boolean[M][N];
		for(int y = 0;y<N;y++){
			for(int x = 0;x<M;x++){
				map[x][y] = br.read() - '0';
			}
			br.read();
		}
		probe();
		return;
	}
}
