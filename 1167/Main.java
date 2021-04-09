import java.util.*;
import java.io.*;
class Node{
	public Map<Integer,Integer> connected;
	public Node(){
		connected = new HashMap<>();
	}
}

public class Main{
	static Map<Integer,Node> tree; 
	static int N;
	static int l_tmp;
	static int longest;
	static boolean[] visited;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new HashMap<>();
		visited = new boolean[N+1];
		StringTokenizer st;
		for(int i = 0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			Node node = new Node();
			int n = Integer.parseInt(st.nextToken());
			String s;
			while(!(s = st.nextToken()).equals("-1")){
				int len = Integer.parseInt(st.nextToken());
				node.connected.put(Integer.parseInt(s),len);
			}
			tree.put(n,node);
		}
		findLongest(1,0);
		Arrays.fill(visited,false);
		findLongest(l_tmp,0);
		System.out.println(longest);
	}
	static void findLongest(int i,int len){
		if(longest < len){
			longest = len;
			l_tmp = i;
		}
		Node node = tree.get(i);
		if(node.connected.keySet().isEmpty()){
			return;
		}
		visited[i] = true;
		int longest = 0;
		for(Map.Entry<Integer,Integer> c:node.connected.entrySet()){
			if(visited[c.getKey()]){
				continue;
			}
			findLongest(c.getKey(),len + c.getValue());
		}
		return;
	}
}
