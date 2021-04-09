import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static int[][] map,c_map,l_map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};

	static boolean paint(int x,int y,int c){
		if(c_map[x][y] != 0||map[x][y]==0){
			return false;
		}
		Stack<int[]> stk = new Stack<>();
		c_map[x][y] = c;
		stk.push(new int[]{x,y});
		while(!stk.isEmpty()){
			int[] node = stk.pop();
			for(int i = 0;i<4;i++){
				int tx = node[0]+dx[i];
				int ty = node[1]+dy[i];
				if(tx<0||ty<0||tx>=N||ty>=N){
					continue;
				}
				if(c_map[tx][ty] != 0||map[tx][ty]==0){
					continue;
				}
				c_map[tx][ty] = c;
				stk.push(new int[]{tx,ty});
			}
		}
		return true;
	}
	static int probe(){
		int ret = Integer.MAX_VALUE;
		Queue<int[]> q = new ArrayDeque<>();
		for(int w = 0;w<N;w++){
			for(int h=0;h<N;h++){
				if(c_map[w][h] != 0){
					q.add(new int[]{w,h,c_map[w][h]});
				}
			}
		}
		int x,y,c,tx,ty;
		while(!q.isEmpty()){
			int[] node = q.remove();
			for(int i = 0;i<4;i++){
				x = node[0];
				y = node[1];
				c = node[2];
				tx = x+dx[i];
				ty = y+dy[i];
				if(tx<0||ty<0||tx>=N||ty>=N||c_map[tx][ty] == c){
					continue;
				}
				if(c_map[tx][ty] == 0){
					l_map[tx][ty] = l_map[x][y]+1;
					c_map[tx][ty] = c;
					q.add(new int[]{tx,ty,c});
				}else{
					ret = Math.min(ret,l_map[x][y]+l_map[tx][ty]);
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		c_map = new int[N][N];
		l_map = new int[N][N];
		for(int i = 0;i<N;i++){
			map[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(k->Integer.parseInt(k))
				.toArray();
		}
		int count = 1;
		for(int x = 0;x<N;x++){
			for(int y = 0;y<N;y++){
				if(paint(x,y,count)){
					count++;
				}
			}
		}
		System.out.println(probe());
	}
}
