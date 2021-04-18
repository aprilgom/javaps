import java.util.*;
import java.io.*;

class Stuff{
	public int volume,need;
	public Stuff(int volume,int need){
		this.volume = volume;
		this.need = need;
	}
}

public class Main{
	static int N,W;
	static Stuff[] stuff;
	static int[][] dp;
	static Map<Integer,String> stuff_name;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0;tc<TC;tc++){
			stuff_name = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			dp = new int[N][W+1];
			stuff = new Stuff[N];
			for(int i = 0;i<N;i++){
				Arrays.fill(dp[i],-1);
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				int v = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				stuff[i] = new Stuff(v,n);
				stuff_name.put(i,name);
			}

			int max_need =  get_max_need(0,0);

			List<Integer> rec = new ArrayList<>();
			reconstruct(0,0,rec);
			int max_stuff_n = rec.size();

			sb.append(max_need)
				.append(" ")
				.append(max_stuff_n)
				.append("\n");
			for(int i:rec){
				sb.append(stuff_name.get(i))
					.append("\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
	static int get_max_need(int idx,int vol){
		if(idx>=N || vol>W){
			return 0;
		}
		if(dp[idx][vol] != -1){
			return dp[idx][vol];
		}
		int packed = 0;
		if(vol+stuff[idx].volume <= W){
			packed = stuff[idx].need + get_max_need(idx+1,vol+stuff[idx].volume);
		}
		int passed = get_max_need(idx+1,vol);
		int ret = Math.max(packed,passed);
		dp[idx][vol] = ret;
		return ret;
	}
	static void reconstruct(int idx,int vol,List<Integer> ret){
		if(idx>=N){
			return;
		}
		int now_need = get_max_need(idx,vol);
		int next_need = get_max_need(idx+1,vol);
		if(now_need != next_need){
			ret.add(idx);
			vol += stuff[idx].volume;
		}
		reconstruct(idx+1,vol,ret);
	}
}

