import java.util.*;
import java.io.*;

public class Main{
	static int[] sq;
	static int N,S;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		sq = new int[N];
		for(int i = 0;i<N;i++){
			sq[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> lset = sol(0,N/2);
		List<Integer> rset = sol(N/2,N);
		int[] ll = lset.stream()
			.sorted()
			.mapToInt(i->i)
			.toArray();
		int[] rl = rset.stream()
			.sorted()
			.mapToInt(i->i)
			.toArray();
		int l = 0;
		int r = rl.length-1;
		long ret = 0;
		if(S==0){
			ret = -1;
		}
		while(l < ll.length && r >= 0){
			int sum = ll[l] + rl[r];
			if(sum>S){
				r--;
			}else if(sum<S){
				l++;
			}else{
				long lc = 1;
				long rc = 1;
				l++;
				r--;
				while(l < ll.length && ll[l] == ll[l-1]){
					lc++;
					l++;
				}
				while(r >= 0 && rl[r] == rl[r+1]){
					rc++;
					r--;
				}
				ret+=lc*rc;
			}
		}
		System.out.println(ret);
	}
	static List<Integer> sol(int s,int e){
		Stack<Integer> stk = new Stack<>();
		List<Integer> ret = new ArrayList<>();
		for(int i = s;i<e;i++){
			stk.push(sq[i]);
			stk.push(i);
		}
		while(!stk.isEmpty()){
			int idx = stk.pop();
			int sum = stk.pop();
			ret.add(sum);
			for(int i = idx+1;i<e;i++){
				stk.push(sum + sq[i]);
				stk.push(i);
			}
		}
		ret.add(0);
		return ret;
	}
}
