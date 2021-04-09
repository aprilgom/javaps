import java.util.*;
import java.io.*;

public class Main{
	static int N,M,K;
	static char[][] map;
	static int[] dx,dy;
	static String target;
	static int target_n;
	static int ret;
	static int[][] node_map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		dx = new int[4*K+1];
		dy = new int[4*K+1];
		for(int i = 1;i<=K;i++){
			dx[i] = i;
			dy[K+i] = i;
			dx[2*K+i] = -i;
			dy[3*K+i] = -i;
		}
		for(int y = 0;y<N;y++){
			for(int x = 0;x<M;x++){
				map[y][x] = (char)br.read();
			}
			br.read();
		}
		target = br.readLine();
		target_n = target.length();

		node_map = new int[2][10000];
		int[] zero = new int[10000];

		for(int y = 0;y<N;y++){
			for(int x = 0;x<M;x++){
				if(map[y][x] == target.charAt(0)){
					node_map[0][100*y+x] = 1;
				}
			}
		}

		for(int i = 0;i<target_n-1;i++){
			for(int key = 0;key < 10000;key++){
				if(node_map[i%2][key] == 0){
					continue;
				}
				for(int j = 1;j<=4*K;j++){
					int tx = key%100 + dx[j];
					int ty = key/100 + dy[j];
					if(tx<0||ty<0||tx>=M||ty>=N){
						continue;
					}
					if(map[ty][tx] != target.charAt(i+1)){
						continue;
					}
					int tkey = ty*100+tx;
					node_map[(i+1)%2][tkey] += node_map[i%2][key];
				}
			}
			System.arraycopy(zero,0,node_map[i%2],0,zero.length);
		}
		int ret = 0;
		int last = (target_n+1)%2;
		for(int i = 0;i<10000;i++){
			ret += node_map[last][i];
		}
		System.out.println(ret);
	}
}
