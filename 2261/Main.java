import java.util.*;
import java.util.stream.*;
import java.io.*;

class Point{
	int x,y;
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o){
		Point p = (Point)o;
		return x == p.x && y == p.y;
	}
	@Override
	public int hashCode(){
		return 100000*(10000 + x) + y+10000;
	}
}

public class Main{
	static Point[] nodes;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		nodes = new Point[n];
		StringTokenizer st;
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodes[i] = new Point(x,y);
		}
		nodes = Arrays.stream(nodes)
			.distinct()
			.sorted((a,b)->a.x-b.x)
			.toArray(Point[]::new);
		if(nodes.length != n){
			System.out.println(0);
			return;
		}
		System.out.println(sol(0,n));
	}
	static int sol(int l,int r){
		if(l == r){
			return Integer.MAX_VALUE;
		}

		int mid = (l+r)/2;
		int ld = sol(l,mid);
		int rd = sol(mid+1,r);
		int d = Math.min(ld,rd);
		int ret = d;

		int[] in_d = IntStream.range(l,r)
			.filter(i->{
				int dx = (nodes[mid].x-nodes[i].x);
				return dx*dx<=d;
			})
			.boxed()
			.sorted((a,b)->nodes[a].y-nodes[b].y)
			.mapToInt(i->i)
			.toArray();

		for(int i = 0;i<in_d.length;i++){
			Point node = nodes[in_d[i]];
			for(int j = i+1;j<in_d.length;j++){
				Point u_node = nodes[in_d[j]];
				int dy = u_node.y-node.y;
				if(dy*dy > d){
					break;
				}
				int dist = getDist(u_node,node);
				ret = Math.min(ret,dist);
			}
		}

		return ret;
	}
	static int getDist(Point a,Point b){
		int dx = a.x - b.x;
		int dy = a.y - b.y;
		return dx*dx + dy*dy;
	}
}
