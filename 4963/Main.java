import java.util.*;
import java.io.*;

class Node{
	public int x,y;
	public Node(int X,int Y){
		x = X;
		y = Y;
	}
}
public class Main{
	static int count;
	static int W,H;
	static int[][] map;
	static boolean[][] searched;
	static int[] dx = {-1, 0, 1,-1, 1,-1, 0, 1};
	static int[] dy = {-1,-1,-1, 0, 0, 1, 1, 1}; 
	static boolean probe(int s_x,int s_y){
		if(map[s_x][s_y] == 0){
			return false;
		}
		if(searched[s_x][s_y]){
			return false;
		}
		Queue<Node> q = new ArrayDeque<>();
		Node s_node = new Node(s_x,s_y);
		searched[s_x][s_y] = true;
		q.add(s_node);
		while(!q.isEmpty()){
			Node node = q.remove();
			int tx,ty;
			for(int i = 0;i<8;i++){
				tx = node.x + dx[i];
				ty = node.y + dy[i];
				if(tx<0||ty<0||tx>=W||ty>=H){
					continue;
				}
				if(searched[tx][ty]||map[tx][ty]==0){
					continue;
				}
				Node tnode = new Node(tx,ty);
				searched[tx][ty] = true;
				q.add(tnode);
			}
		}
		return true;
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		while(true){
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W == 0 && H == 0){
				break;
			}
			searched = new boolean[W][H];
			map = new int[W][H];
			for(int h = 0;h<H;h++){
				st = new StringTokenizer(br.readLine());
				for(int w = 0;w<W;w++){
					map[w][h] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			for(int x = 0;x<W;x++){
				for(int y = 0;y<H;y++){
					if(probe(x,y)){
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}
