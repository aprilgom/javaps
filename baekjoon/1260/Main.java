import java.util.*;
import java.io.*;
class Node{
	public List<Integer> conn;
	public Node(){
		conn = new ArrayList<>();
	}
}
public class Main{
	static Node[] graph;
	static int N;
	static int M;
	static int V;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		V = Integer.parseInt(s[2]);
		graph = new Node[N+1];
		for(int i = 1;i<=N;i++){
			graph[i] = new Node();
		}
		for(int i = 0;i<M;i++){
			String[] ln = br.readLine().split(" ");
			int a = Integer.parseInt(ln[0]);
			int b = Integer.parseInt(ln[1]);
			graph[a].conn.add(b);
			graph[b].conn.add(a);
		}
		for(int i = 1;i<=N;i++){
			Collections.sort(graph[i].conn,Collections.reverseOrder());
		}
		List<Integer> d_ret = dfs();
		for(int i = 1;i<=N;i++){
			Collections.sort(graph[i].conn);
		}
		List<Integer> b_ret = bfs();
		StringBuilder sb = new StringBuilder();
		for(int i:d_ret){
			sb.append(i).append(" ");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("\n");
		for(int i:b_ret){
			sb.append(i).append(" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}
	static List<Integer> dfs(){
		Stack<Integer> stk = new Stack<>();
		List<Integer> ret = new ArrayList<>();
		boolean[] visited = new boolean[N+1];
		stk.push(V);
		while(!stk.isEmpty()){
			int p = stk.pop();
			if(visited[p])continue;
			ret.add(p);
			visited[p] = true;
			for(int i:graph[p].conn){
				if(!visited[i]){
					stk.push(i);
				}
			}
		}
		return ret;
	}
	static List<Integer> bfs(){
		Queue<Integer> q = new ArrayDeque<>();
		List<Integer> ret = new ArrayList<>();
		boolean[] visited = new boolean[N+1];
		q.offer(V);
		while(!q.isEmpty()){
			int p = q.poll();
			if(visited[p])continue;
			ret.add(p);
			visited[p] = true;
			for(int i:graph[p].conn){
				if(!visited[i]){
					q.offer(i);
				}
			}
		}
		return ret;
	}
}
