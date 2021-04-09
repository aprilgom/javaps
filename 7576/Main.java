import java.util.*;
import java.io.*;
class Node{
	public int x,y,level;
	public Node(int X,int Y,int L){
		x = X;
		y = Y;
		level = L;
	}
}

public class Main{

	static int[][] tomatoes;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int M,N;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomatoes = new int[M][N];
		for(int n = 0;n<N;n++){
			st = new StringTokenizer(br.readLine());
			for(int m = 0;m<M;m++){
				tomatoes[m][n] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Node> q = new ArrayDeque<>();
		for(int x = 0;x<M;x++){
			for(int y = 0;y<N;y++){
				if(tomatoes[x][y] == 1){
					q.add(new Node(x,y,0));
				}
			}
		}
		int count = 0;
		while(!q.isEmpty()){
			Node node = q.remove();
			int tx,ty;
			for(int i = 0;i<4;i++){
				tx = node.x + dx[i];
				ty = node.y + dy[i];
				if(tx<0||ty<0||tx>=M||ty>=N){
					continue;
				}
				if(tomatoes[tx][ty] == -1 || tomatoes[tx][ty] == 1){
					continue;
				}
				q.add(new Node(tx,ty,node.level+1));
				tomatoes[tx][ty] = 1;
				count = Math.max(count,node.level+1);
			}
		}
		for(int x = 0;x<M;x++){
			for(int y = 0;y<N;y++){
				if(tomatoes[x][y] == 0){
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(count);
	}
}
