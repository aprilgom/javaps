import java.util.*;
import java.io.*;

public class Main{
	static int[][] map;
	static int[][] cost;
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
		cost = new int[N][M];
		for(int y = 0;y<N;y++){
			for(int x = 0;x<M;x++){
				map[y][x] = br.read()-'0';
				cost[y][x] = Integer.MAX_VALUE;
			}	
			br.read();
		}
		cost[0][0] = 0;
		int ret = sol();
		System.out.println(ret);
	}
	static int sol(){
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
		pq.add(new Node(0,0,0));
		while(!pq.isEmpty()){
			Node node = pq.poll();
			for(int i = 0;i<4;i++){
				int ty = node.y+dy[i];
				int tx = node.x+dx[i];
				if(tx<0||tx>=M||ty<0||ty>=N){
					continue;
				}
				int tcost = node.cost+map[ty][tx];
				if(cost[ty][tx] > tcost){
					cost[ty][tx] = tcost;
					pq.add(new Node(tx,ty,tcost));
				}
			}
		}
		return cost[N-1][M-1];
	}
}
class Node{
	public int x,y,cost;
	public Node(int x,int y,int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}
