import java.util.*;
import java.io.*;

public class Main{
	static int[] lim;
	static int[] cup;
	static boolean[][][] visited;
	static TreeSet<Integer> ret;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		cup = new int[3];
		lim = new int[3];
		ret = new TreeSet<>();
		lim[0] = Integer.parseInt(st.nextToken());
		lim[1] = Integer.parseInt(st.nextToken());
		lim[2] = Integer.parseInt(st.nextToken());
		visited = new boolean[lim[0]+1][lim[1]+1][lim[2]+1];
		cup[2] = lim[2];
		sol();
		StringBuilder sb = new StringBuilder();
		for(int i:ret){
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
	static void sol(){
		
		for(int from = 0;from<=2;from++){
			for(int to = 0;to<=2;to++){
				int[] tmp = cup.clone();
				pour(from,to);
				if(visited[cup[0]][cup[1]][cup[2]]){
					cup = tmp;
					continue;
				}
				visited[cup[0]][cup[1]][cup[2]] = true;
				if(cup[0] == 0){
					ret.add(cup[2]);
				}
				sol();
				cup = tmp;
			}
		}
	}
	static void pour(int from,int to){
		if(from == to){
			return;
		}
		if(cup[from] == 0 || cup[to] == lim[to])return;
		int to_capa = lim[to] - cup[to];//옮길 컵의 남은 용량

		if(cup[from] > to_capa){//다 부었을때 넘친다면
			cup[to] = lim[to];
			cup[from] -= to_capa;
		}else{
			cup[to] += cup[from];
			cup[from] = 0;
		}
	}
}
