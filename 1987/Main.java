import java.util.*;
import java.io.*;

public class Main{
	static int R;
	static int C;
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[] used;
	static int ret = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		used = new boolean[26];
		map = new int[R][C];
		for(int r = 0;r<R;r++){
			for(int c = 0;c<C;c++){
				map[r][c] = br.read() - 'A';
			}
			br.read();
		}
		used[map[0][0]] = true;
		sol(0,0,1);
		System.out.println(ret);
	}
	static void sol(int x,int y,int n){
		ret = Math.max(ret,n);
		for(int i = 0;i<4;i++){
			int ty = y + dy[i];
			int tx = x + dx[i];
			if(tx<0 || tx>=C ||ty<0 || ty>=R){
				continue;
			}
			if(used[map[ty][tx]]){
				continue;
			}
			used[map[ty][tx]] = true;
			sol(tx,ty,n+1);
			used[map[ty][tx]] = false;
		}
	}
}
