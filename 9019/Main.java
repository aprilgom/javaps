import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[10000];
			Queue<Integer> q = new ArrayDeque<>();
			Queue<String> path_q = new ArrayDeque<>(); 
			q.add(A);
			path_q.add("");
			StringBuilder sb; 
			String ret = "";
			while(!q.isEmpty()){
				int item = q.remove();
				String path = path_q.remove();
				if(item == B){
					ret = path;
					break;
				}

				int d = D(item);
				int s = S(item);
				int l = L(item);
				int r = R(item);
				if(!visited[d]){
					visited[d] = true;
					q.add(d);
					path_q.add(path.concat("D"));
				}
				if(!visited[s]){
					visited[s] = true;
					q.add(s);
					path_q.add(path.concat("S"));
				}
				if(!visited[l]){
					visited[l] = true;
					q.add(l);
					path_q.add(path.concat("L"));
				}
				if(!visited[r]){
					visited[r] = true;
					q.add(r);
					path_q.add(path.concat("R"));
				}
			}
			System.out.println(ret);
		}
	}
	static int D(int n){
		return (n<<1)%10000;
	}
	static int S(int n){
		return n==0?9999:n-1;
	}
	static int L(int n){
		n *= 10;
		int rsn = n/10000;
		n = n - rsn*10000 + rsn;
		return n;
	}
	static int R(int n){
		int lsn = n%10;
		n /= 10;
		n += 1000*lsn;
		return n;
	}
}
