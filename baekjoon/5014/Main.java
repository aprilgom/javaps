import java.util.*;
import java.io.*;

public class Main{
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		visited = new boolean[F+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(S);
		q.add(0);
		visited[S] = true;
		int ret = -1;
		while(!q.isEmpty()){
			int now_f = q.remove();
			int n = q.remove();
			if(now_f == G){
				ret = n;
				break;
			}
			int up_f = now_f + U;
			if(up_f <= F && !visited[up_f]){
				q.add(up_f);
				q.add(n+1);
				visited[up_f] = true;
			}
			int dn_f = now_f - D;
			if(dn_f > 0 && !visited[dn_f]){
				q.add(dn_f);
				q.add(n+1);
				visited[dn_f] = true;
			}
		}
		if(ret == -1){
			System.out.println("use the stairs");
		}else{
			System.out.println(ret);
		}
	}
}
