import java.util.*;
import java.io.*;

public class Main{
	static Set<String> visited; 
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sx = 0;
		int sy = 0;
		StringBuilder sb = new StringBuilder();
		for(int y = 0;y<3;y++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x = 0;x<3;x++){
				int num = Integer.parseInt(st.nextToken());
				if(num == 0){
					sx = x;
					sy = y;
				}
				sb.append(num);
			}
		}
		String start = sb.toString();
		String target = "123456780";

		visited = new HashSet<>();
		Queue<String> puz_q = new ArrayDeque<>();
		Queue<Integer> q = new ArrayDeque<>();
		puz_q.add(start);
		q.add(sx);
		q.add(sy);
		q.add(0);
		int ret = -1;
		while(!q.isEmpty()){
			String puz = puz_q.remove();
			int x = q.remove();
			int y = q.remove();
			int n = q.remove();
			if(puz.equals(target)){
				ret = n;
				break;
			}
			for(int i = 0;i<4;i++){
				int tx = x+dx[i];
				int ty = y+dy[i];
				if(tx<0 ||tx>=3||ty<0||ty>=3){
					continue;
				}
				int idx = y*3+x;
				int t_idx = ty*3 +tx;
				sb = new StringBuilder(puz);
				sb.setCharAt(idx,sb.charAt(t_idx));
				sb.setCharAt(t_idx,'0');
				String t_puz = sb.toString();
				if(visited.contains(t_puz)){
					continue;
				}
				visited.add(t_puz);
				puz_q.add(t_puz);
				q.add(tx);
				q.add(ty);
				q.add(n+1);
			}
		}
		System.out.println(ret);
	}
}
