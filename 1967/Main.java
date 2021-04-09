import java.util.*;
import java.io.*;

class Node{
	public Map<Integer,Integer> connected;
	public Node(){
		connected = new HashMap<>();
	}
}
public class Main{
	static int N;
	static int longest_node;
	static Map<Integer,Node> tree = new HashMap<>();
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N == 1){
			System.out.println(0);
			return;
		}
		for(int i = 0;i<N-1;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent_n = Integer.parseInt(st.nextToken());
			int child_n = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			Node parent_node = getOrCreate(parent_n);
			Node child_node = getOrCreate(child_n);
			parent_node.connected.put(child_n,weight);
			child_node.connected.put(parent_n,weight);
		}
		getLongest(1);
		System.out.println(getLongest(longest_node));
	}
	static int getLongest(int n){
		int ret = 0;
		boolean[] visited = new boolean[N+1];
		Stack<Integer> stk = new Stack<>();
		stk.push(n);
		stk.push(0);
		visited[n] = true;
		while(!stk.isEmpty()){
			int parent_len = stk.pop();
			int parent_n = stk.pop();
			Node node = tree.get(parent_n);
			for(Map.Entry<Integer,Integer> e:node.connected.entrySet()){
				int child_n = e.getKey();
				int child_len = e.getValue();
				if(visited[child_n]){
					continue;
				}
				visited[child_n] = true;
				if(ret<parent_len+child_len){
					ret = parent_len+child_len;
					longest_node = child_n;
				}
				stk.push(child_n);
				stk.push(parent_len+child_len);
			}
		}
		return ret;
	}
	static Node getOrCreate(int n){
		Node node;
		if(tree.containsKey(n)){
			node = tree.get(n);
		}else{
			node = new Node();
			tree.put(n,node);
		}
		return node;
	}
}
