import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main{
	static int[] sq;
	static int[] perm;
	static int sum;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		sq = new int[N];
		perm = new int[N];
		visited = new boolean[N];
		for(int i = 0;i<N;i++){
			sq[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sq);
		pm(0);
		System.out.println(sum);
	}
	static int sum(){
		int ret = 0;
		for(int i = 0;i<perm.length-1;i++){
			ret += Math.abs(perm[i] - perm[i+1]);
		}
		return ret;
	}
	static void pm(int idx){
		if(idx == sq.length){
			sum = Math.max(sum,sum());		
		}
		for(int i = 0;i<sq.length;i++){
			if(visited[i])continue;
			visited[i] = true;
			perm[idx] = sq[i];
			pm(idx+1);
			visited[i] = false;
		}
	}
}
