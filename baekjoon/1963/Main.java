import java.util.*;
import java.io.*;

public class Main{
	static boolean[] primes;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		primes = new boolean[10000];
		Arrays.fill(primes,true);
		primes[0] = false;
		primes[1] = false;
		for(int i = 2;i<10000;i++){
			if(primes[i] == false){
				continue;
			}
			for(int j = i*2;j<10000;j+=i){
				primes[j] = false;
			}
		}
		StringTokenizer st;
		for(int t = 0;t<T;t++){
			visited = new boolean[10000];
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == b){
				System.out.println(0);
				continue;
			}
			int ret = -1;
			Queue<Integer> q = new ArrayDeque<>();
			q.add(a);
			q.add(0);
			visited[a] = true;
			while(!q.isEmpty()&&ret == -1){
				int item = q.remove();
				int n = q.remove();
				for(int i = 0;i<4;i++){
					StringBuilder sb = new StringBuilder(String.valueOf(item));
					for(int j = 0;j<=9;j++){
						sb.setCharAt(i,(char)(j+'0'));
						int next = Integer.parseInt(sb.toString());
						if(next == a){
							continue;
						}
						if(next<1000){
							continue;
						}
						if(!primes[next]){
							continue;
						}
						if(visited[next]){
							continue;
						}
						if(next == b){
							ret = n+1;
						}
						visited[next] = true;
						q.add(next);
						q.add(n+1);
					}
				}
			}
			if(ret == 0){
				System.out.println("Impossible");
			}else{
				System.out.println(ret);
			}
		}
	}
}
