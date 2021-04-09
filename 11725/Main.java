import java.util.*;
import java.io.*;

class Node{
	public Set<Integer> connected;
	int parent = -1;
	public Node(){
		connected = new HashSet<>();
	}
}
public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Map<Integer,Node> tree = new HashMap<>();
		for(int i = 0;i<N-1;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Node node_a;
			if(tree.containsKey(a)){
				node_a = tree.get(a);
			}else{
				node_a = new Node();
				tree.put(a,node_a);
			}
			Node node_b;
			if(tree.containsKey(b)){
				node_b = tree.get(b);
			}else{
				node_b = new Node();
				tree.put(b,node_b);
			}
			node_a.connected.add(b);
			node_b.connected.add(a);
		}
		Queue<Integer> q = new ArrayDeque<>();
		tree.get(1).parent = 1;
		q.add(1);
		while(!q.isEmpty()){
			int me = q.remove();
			Node node = tree.get(me);
			for(int c:node.connected){
				if(tree.get(c).parent == -1){
					tree.get(c).parent = me; 
					q.add(c);
				}
			}
		}
		for(int i = 2;i<=N;i++){
			System.out.println(tree.get(i).parent);
		}
	}
}
