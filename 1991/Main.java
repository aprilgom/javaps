import java.util.*;
import java.io.*;
class Node{
	public String l,r;
}
public class Main{
	static Map<String,Node> tree;
	static StringBuilder sb;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree = new HashMap<>();
		sb= new StringBuilder();
		for(int i = 0;i<N;i++){
			String[] s = br.readLine().split(" ");
			Node node = new Node();
			node.l = s[1];
			node.r = s[2];
			tree.put(s[0],node);
		}
		pre_trav("A");
		sb.append("\n");
		in_trav("A");
		sb.append("\n");
		post_trav("A");
		sb.append("\n");
		System.out.println(sb);
	}
	static void pre_trav(String n){
		Node node = tree.get(n);
		if(node == null){
			return;
		}
		sb.append(n);
		pre_trav(node.l);
		pre_trav(node.r);
	}
	static void in_trav(String n){
		Node node = tree.get(n);
		if(node == null){
			return;
		}
		in_trav(node.l);
		sb.append(n);
		in_trav(node.r);
	}
	static void post_trav(String n){
		Node node = tree.get(n);
		if(node == null){
			return;
		}
		post_trav(node.l);
		post_trav(node.r);
		sb.append(n);
	}
}
