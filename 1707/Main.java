import java.util.*;
import java.io.*;

class Node{
	List<Integer> conn;
	public Node(){
		conn = new ArrayList<>();
	}
}
public class Main{
	static int[] visited;
	static int V;
	static int E;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new int[20001];
		for(int i = 0;i<N;i++){
			String[] s = br.readLine().split(" ");
			V = Integer.parseInt(s[0]);
			Node[] v = new Node[V+1];
			E = Integer.parseInt(s[1]);
			for(int j = 1;j<=V;j++){
				v[j] = new Node();
			}
			Arrays.fill(visited,0);
			for(int j = 0;j<E;j++){
				String[] se = br.readLine().split(" ");
				int a = Integer.parseInt(se[0]);
				int b = Integer.parseInt(se[1]);
				v[a].conn.add(b);
				v[b].conn.add(a);
			}
			Stack<Integer> stk = new Stack<>();
			int color = 0;
			int now = 0;
			boolean ret = true;
			for(int j = 1;j<=V;j++){
				if(visited[j] == 0){
					stk.push(j);
					visited[j] = 1;
					while(!stk.isEmpty() && ret){
						now = stk.pop();
						color = visited[now];
						for(int k:v[now].conn){
							if(visited[k] == color){
								ret = false;
								break;
							}
							if(visited[k] == 0){
								stk.push(k);
								visited[k] = -color;
							}
						}
					}
				}
				if(!ret){
					break;
				}
			}
			if(ret){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}
